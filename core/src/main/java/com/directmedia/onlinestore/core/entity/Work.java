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
    
    private static int lastId;
    
       public Work() {
        this.id=lastId++;
            }

       public Work(String title) {
        this();                 // J'ai juste fait appel au this du constructeur sans parametre de work; 
        this.title = title;
    }
    
    private long id;
    private String title;
    private String genre;
    private int release;
    private String summary;
    private Artist mainArtist;
    

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

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Artist getMainArtist() {
        return mainArtist;
    }
    public void setMainArtist(Artist mainArtist) {
        this.mainArtist = mainArtist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    
}
