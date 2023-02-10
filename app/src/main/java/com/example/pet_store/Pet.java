package com.example.pet_store;

import java.util.List;

public class Pet {

    private Integer id;
    private List<String> PhotoUrl;
    private String petStatus;
    private String name;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    public List<String> getPhotoUrl() {
        return PhotoUrl;
    }
    public void setPhotoUrl(List<String> photoUrl) {
        PhotoUrl = photoUrl;
    }



    public String getPetStatus() {
        return petStatus;
    }
    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }
}
