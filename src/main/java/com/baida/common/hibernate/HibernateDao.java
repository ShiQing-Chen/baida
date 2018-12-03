package com.baida.common.hibernate;

import com.baida.common.pager.Pager;
import com.baida.common.pager.PagerList;
import com.baida.common.utils.ReflectionUtil;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 功能:Hibernate基础CRUD数据操作实现类
 * <p>
 * 修改历史:对程序的修改历史进行记录
 * </p>
 *
 * @param <T> 泛型实体
 * @param <K> 泛型主键类型
 * @author none
 */
public class HibernateDao<T, K extends Serializable> {
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int FIREST_RESULT_START = 0;
    public static final int MAX_RESULT_SIZE = 10000;
    public static final int MMAX_RESULT_SIZE = MAX_RESULT_SIZE * 10;
    /**
     * 要跟配置中的hibernate.jdbc.batch_size一致
     */
    private static final int BATCH_SIZE = 50;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateDao.class);

    /**
     * hibernate sessionFactory.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 实体类.
     */
    protected Class<T> entityClass;

    /**
     * 默认的无参构造函数,默认情况下xml配置的hibernate sessionFactory的id=sessionFactory.
     */
    public HibernateDao() {
        this.entityClass = ReflectionUtil.getSuperClassGenricType(getClass());
    }

    /**
     * 返回一个Hibernate的Session.
     *
     * @return Session Hibernate的Session
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 保存一个对象.
     *
     * @param entity 被保存的对象
     * @return T 保存后生成ID的对象
     */
    public T save(T entity) {
        Assert.notNull(entity, "entity is not null!!!");
        Session session = getSession();
        session.saveOrUpdate(entity);
        return entity;
    }

    /**
     * 保存一个集合的对象.
     *
     * @param entities 被保存的集合
     * @return Collection<T> 返回保存成功后的对象
     */
    public List<T> save(List<T> entities) {
        List<T> list = new ArrayList<>();
        Assert.notNull(entities, "entities is null!!!");
        Assert.notEmpty(entities, "entities is empty!!!");
        for (T t : entities) {
            list.add(save(t));
        }
        return list;
    }

    public Collection<T> save(Collection<T> collection) {
        for (T t : collection) {
            sessionFactory.getCurrentSession().saveOrUpdate(t);
        }
        return collection;
    }

    /**
     * 根据主键ID删除一个对象.
     *
     * @param id 被删除对象的主键ID
     */
    public void delete(K id) {
        Assert.notNull(id, "id is not null!!!");
        delete(get(id));
        LOGGER.debug("delete id: {}", id);
    }

    /**
     * 直接删除一个实体对象.
     *
     * @param entity 被删除的对象
     */
    public void delete(T entity) {
        if (entity == null) {
            LOGGER.warn("#### 试图删除一个空的数据库对象");
            return;
        }
        Session session = getSession();
        session.delete(entity);
        LOGGER.debug("delete entity {}", entity);
    }

    /**
     * 根据一个主键ID的集合删除对象
     *
     * @param ids 被删除对象ID的集合
     */
    public void delete(Collection<K> ids) {
        Assert.notNull(ids, "ids is not null!!!");
        Assert.notEmpty(ids, "ids is not empty!!!");
        for (K id : ids) {
            delete(id);
        }
        LOGGER.debug("delete ids {}", ids);
    }

    /**
     * 更新一个对象.
     *
     * @param entity 被更新的对象
     */
    public void update(T entity) {
        getSession().update(entity);
    }

    /**
     * 根据主键ID查询一个对象.
     *
     * @param id 主键ID
     * @return T 查出的对象
     */
    @SuppressWarnings("unchecked")
    public T get(K id) {
        if(id == null){
            return null;
        }
        return (T) getSession().get(entityClass, id);
    }


    /**
     * 根据hql语句进行查询.
     *
     * @param hql    查询语句
     * @param values 条件
     * @return Collection<T> 对象集合
     * Modify by HanHongmin 2017-11-01 最多返回10000 条记录
     */
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql, Object... values) {
        Query query = createQuery(hql, values);
        query.setFirstResult(0);
        query.setMaxResults(MAX_RESULT_SIZE);
        return query.list();
    }

    /**
     * 根据主键ID的集合返回一个对象集合.
     *
     * @param ids 主键ID的集合
     * @return Collection<T> 对象的集合
     */
    public List<T> findByIds(Collection<K> ids) {
        return find(Restrictions.in(getIdName(), ids));
    }

    /**
     * 按Criteria查询对象列表.
     *
     * @param criterion 数量可变的Criterion.
     *                  Modify by HanHongmin 2017-11-01 最多返回10000 条记录
     */
    @SuppressWarnings("unchecked")
    public List<T> find(final Criterion... criterion) {
        Criteria criteria = createCriteria(criterion).setCacheable(true);
        criteria.setFirstResult(0);
        criteria.setMaxResults(MAX_RESULT_SIZE);
        return criteria.list();
    }

    /**
     * 根据Criterion条件创建Criteria.
     * <p/>
     * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
     *
     * @param criterion 数量可变的Criterion.
     */
    private Criteria createCriteria(final Criterion... criterion) {
        Criteria criteria = getSession().createCriteria(entityClass);
        criteria.setCacheable(true);
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        return criteria;
    }

    /**
     * 根据查询HQL与参数列表创建Query对象.
     * <p/>
     * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
     *
     * @param values 数量可变的参数,按顺序绑定.
     */
    protected Query createQuery(final String queryString,
                                final Object... values) {
        Query query = getSession().createQuery(queryString);
        query.setCacheable(true);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }

    /**
     * @param queryString sql
     * @param values      参数
     * @return 查询对象
     */
    protected SQLQuery createSQLQuery(final String queryString, final Map<String, Object> values) {
        SQLQuery query = getSession().createSQLQuery(queryString);
        query.setCacheable(true);
        if (values != null) {
            query.setProperties(values);
        }
        return query;
    }

    /**
     * 根据查询HQL与参数列表创建Query对象.
     *
     * @param values 命名参数,按名称绑定.
     */
    protected Query createQuery(final String queryString,
                                final Map<String, Object> values) {
        Query query = getSession().createQuery(queryString);
        query.setCacheable(true);
        if (values != null) {
            query.setProperties(values);
        }
        return query;
    }


    /**
     * 取得对象的主键名.
     */
    private String getIdName() {
        ClassMetadata meta = sessionFactory.getClassMetadata(entityClass);
        return meta.getIdentifierPropertyName();
    }

    protected Criteria getExecutableCriteria(DetachedCriteria dc) {
        return dc.getExecutableCriteria(sessionFactory.getCurrentSession());
    }


    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(DetachedCriteria dc, int firstResult, int maxResults) {
        int first = firstResult < 0 ? 0 : firstResult;

        Criteria c = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
        c.setFirstResult(first);
        c.setMaxResults(maxResults);
        return c.list();
    }

    protected Long getRowCount(DetachedCriteria dc) {
        Criteria c = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
        Object o = c.setProjection(Projections.rowCount()).uniqueResult();
        Long totalCount = (Long) o;
        c.setProjection(null);
        return totalCount;
    }

    @SuppressWarnings("unchecked")
    protected T uniqueResult(DetachedCriteria dc) {
        Criteria c = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
        return (T) c.uniqueResult();
    }

    protected Object uniqueObject(DetachedCriteria dc) {
        Criteria c = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
        return c.uniqueResult();
    }

    @SuppressWarnings("Duplicates")
    public void batchSave(Collection<T> list) {
        Session session = getSession();
        int i = 1;
        for (T bean : list) {
            session.saveOrUpdate(bean);
            if (i % BATCH_SIZE == 0 || i == list.size()) {
                LOGGER.debug("batch save:{}", i);
                session.flush();
                session.clear();
            }
            i = i + 1;
        }
    }



    @SuppressWarnings("unchecked")
    public PagerList<T> pagerByCriteria(DetachedCriteria dc, int pageNum, int pageSize) {
        Criteria c = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
        Long totalCount=(Long)c.setProjection(Projections.rowCount())
                .uniqueResult();
        Pager pager = new Pager(pageNum,pageSize);
        pager.setTotalRows(totalCount.intValue());
        c.setProjection(null);
        c.setFirstResult(pager.getStartRow());
        c.setMaxResults(pager.getPageSize());
        List<T> list = c.list();

        PagerList<T> pl = new PagerList<T>();
        pl.setDataList(list);
        pl.setPager(pager);
        return pl;
    }


    @SuppressWarnings("Duplicates")
    public void batchSave(Collection<T> list, int batchSize) {
        Session session = getSession();
        int i = 1;
        for (T bean : list) {
            session.saveOrUpdate(bean);
            if (i % batchSize == 0 || i == list.size()) {
                LOGGER.debug("batch save:{}", i);
                session.flush();
                session.clear();
            }
            i = i + 1;
        }
    }
}
