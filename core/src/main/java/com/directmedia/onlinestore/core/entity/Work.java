/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.core.entity;

/**
 *
 * @author User
 */
public class Work {
    private String title;
    private String genre;
    private int release;
    private String summury;
    private Artist mainArtist;

    public Work() {
    }

    public Work(String title) {
        this.title = title;
    }
    
    
    

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRelease() {
        return release;
    }
    public void setRelease(int release) {
        this.release = release;
    }

    public String getSummury() {
        return summury;
    }
    public void setSummury(String summury) {
        this.summury = summury;
    }

    public Artist getMainArtist() {
        return mainArtist;
    }
    public void setMainArtist(Artist mainArtist) {
        this.mainArtist = mainArtist;
    }
    
    
    
    
}
