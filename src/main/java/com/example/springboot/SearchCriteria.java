package com.example.springboot;

import javax.validation.constraints.NotBlank;

public class SearchCriteria {

    //@NotBlank(message = "username can't empty!")
    //String username;

    /*public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }*/

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
                '}';
    }

    private String authorName;
    private String search;
    private String category;


}
