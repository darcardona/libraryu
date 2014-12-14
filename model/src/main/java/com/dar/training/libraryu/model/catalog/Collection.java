package com.dar.training.libraryu.model.catalog;

/**
 * Created by dar on 11/23/14.
 */
public class Collection {

    private Long id;
    private String name;
    private Long lendingTime;
    private Long lendingLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLendingTime() {
        return lendingTime;
    }

    public void setLendingTime(Long lendingTime) {
        if (lendingTime > 0)
            this.lendingTime = lendingTime;
        this.lendingTime = 0L;
    }

    public Long getLendingLimit() {
        return lendingLimit;
    }

    public void setLendingLimit(Long lendingLimit) {
        if (lendingLimit > 0)
            this.lendingLimit = lendingLimit;
        this.lendingLimit = 0L;
    }
}
