package com.example.springboot;

import javax.validation.constraints.NotBlank;

public class SearchCriteria {


    private String authorName;
    private String search;
    private String category;
    private int pageShowing;
    private int nuberOfRecords;
    private Tags tags;

    public int getPageShowing() {
        return pageShowing;
    }

    public void setPageShowing(int pageShowing) {
        this.pageShowing = pageShowing;
    }

    public int getNuberOfRecords() {
        return nuberOfRecords;
    }

    public void setNuberOfRecords(int nuberOfRecords) {
        this.nuberOfRecords = nuberOfRecords;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "authorName='" + authorName + '\'' +
                ", search='" + search + '\'' +
                ", category='" + category + '\'' +
                ", pageShowing=" + pageShowing +
                ", nuberOfRecords=" + nuberOfRecords +
                ", tags=" + tags +
                '}';
    }
}
