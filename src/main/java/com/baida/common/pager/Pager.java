package com.baida.common.pager;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 10:42
 */

public class Pager {



    /**
     * 总行数 最小为0
     */
    private int totalRows;
    /**
     * 每页显示的行数 最小为1
     */
    private int pageSize;
    /**
     * 当前页号 从1开始
     */
    private int currentPage;
    /**
     * 总页数 最小为0
     */
    private int totalPages;
    /**
     * 当前页在数据库中的起始行 从0开始
     */
    private int startRow;

    public Pager(int currentPage, int pageSize) {
        this.pageSize = pageSize;
        if (this.pageSize == 0){
            this.pageSize = 1;
        }

        this.currentPage = currentPage;

        if (this.currentPage <= 0)
            this.currentPage = 1;
        if (this.currentPage > this.totalPages && this.totalPages != 0)
            this.currentPage = this.totalPages;
        // 起始行startRow
        this.startRow = this.pageSize * (this.currentPage - 1);
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置总行数，内部各数据跟随改变<br>
     * pageSize不变<br>
     * currentPage不变
     *
     * @param totalRows 总行数
     */
    public void setTotalRows(int totalRows) {
        // 总条数totalRows
        this.totalRows = totalRows;

        // 总页数totalPages,0/n得0，0%n得0，这种情况不用考虑
        this.totalPages = this.totalRows / this.pageSize;
        int mod = this.totalRows % this.pageSize;
        if (mod > 0) {
            this.totalPages = this.totalPages + 1;
        }
        if (this.currentPage > this.totalPages && this.totalPages != 0)
            this.currentPage = this.totalPages;

        // 起始行startRow
        this.startRow = this.pageSize * (this.currentPage - 1);

    }

    @Override
    public String toString() {
        return (super.toString() + "\n") +
                "当前页" + this.currentPage + "\t" +
                "总页数" + this.totalPages + "\t" +
                "当前行" + this.startRow + "\t" +
                "总行数" + this.totalRows + "\t" +
                "页大小" + this.pageSize;
    }
}
