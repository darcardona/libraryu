package com.dar.training.libraryu.model.catalog.item;

/**
 * Created by dar on 11/19/14.
 */
public class Item implements Comparable<Item> {

    private Long id;
    private String name;
    private String author;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * http://www.javapractices.com/topic/TopicAction.do?Id=10
     *
     * @param item
     * @return
     */
    public int compareTo(Item item) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == item) return EQUAL;

        int comparison = this.getName().compareTo(item.getName());
        if (comparison != EQUAL) return comparison;

        comparison = this.getAuthor().compareTo(item.getAuthor());
        if (comparison != EQUAL) return comparison;

        if (this.getId() < item.getId()) return BEFORE;
        if (this.getId() > item.getId()) return AFTER;

        //all comparisons have yielded equality
        //verify that compareTo is consistent with equals (optional)
        assert this.equals(item) : "compareTo inconsistent with equals.";

        return EQUAL;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
