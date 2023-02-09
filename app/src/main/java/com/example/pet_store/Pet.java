package com.example.pet_store;

import java.util.List;

public class Pet {

    public int categoryId;
    private Category categoryName;
    private List<String> PhotoUrl;
    private int tagId;
    private List<Tag> tagName;
    private String petStatus;
    private String name;

    public Category getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }



    public List<Tag> getTagName() {
        return tagName;
    }
    public void setTagName(List<Tag> tagName) {
        this.tagName = tagName;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }



    public List<String> getPhotoUrl() {
        return PhotoUrl;
    }
    public void setPhotoUrl(List<String> photoUrl) {
        PhotoUrl = photoUrl;
    }



    public int getTagId() {
        return tagId;
    }
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }



    public String getPetStatus() {
        return petStatus;
    }
    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }
}
