package com.laura.parcial_2.clases;

public class Usuario {

    private String name;
    private String status;
    private String gender;
    private String species;
    private String location;
    private String type;
    private String image;

    public Usuario(String name, String gender, String status, String species, String type, String location, String image) {
        this.name = name;
        this.gender = gender;
        this.status = status;
        this.species = species;
        this.type = type;
        this.location = location;
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
