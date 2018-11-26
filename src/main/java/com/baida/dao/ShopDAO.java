package com.baida.dao;

import com.baida.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 14:23
 */

@Repository
public class ShopDAO implements CrudRepository<Shop, String> {


    @Override
    public <S extends Shop> S save(S s) {
        return null;
    }

    @Override
    public <S extends Shop> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Shop> findById(String s) {
        return null;
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Shop> findAll() {
        return null;
    }

    @Override
    public Iterable<Shop> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Shop shop) {

    }

    @Override
    public void deleteAll(Iterable<? extends Shop> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
