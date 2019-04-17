package com.codecool.backgroundimage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Image(String name){
        this.name = name;
    }
}
