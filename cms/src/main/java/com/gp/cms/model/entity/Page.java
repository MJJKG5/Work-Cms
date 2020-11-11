package com.gp.cms.model.entity;

public class Page {
    /**
     * 下标
     */
    private Integer index;
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 页数
     */
    private Integer pageCount;
    /**
     * 总数量
     */
    private Long total;

    public Page(Integer pageNo, Integer pageSize, Long total) {
        this.total = total < 1 ? 0 : total;
        this.pageSize = pageSize < 1 ? 20 : pageSize;
        this.index = (pageNo - 1) * pageSize <= 0 ? 0 : pageNo;
        this.pageCount = Math.toIntExact(total / pageSize);
        if (total % pageSize != 0) {
            this.pageCount++;
        }
        if (pageCount < 0) {
            this.pageCount = 0;
        }
        this.pageNo = pageNo < 1 ? 1 : (pageNo > this.pageCount ? this.pageCount : pageNo);
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
