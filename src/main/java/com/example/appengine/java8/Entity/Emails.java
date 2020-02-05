package com.example.appengine.java8.Entity;

public class Emails {
    String key;
    String email;
    boolean isTokenActive;

    public Emails(String email, boolean isTokenActive) {
        this.email = email;
        this.isTokenActive = isTokenActive;
    }

    public Emails(String key, String email, boolean isTokenActive){
        this.key = key;
        this.email = email;
        this.isTokenActive = isTokenActive;
    }

    public String getKey() { return key; }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTokenActive() {
        return isTokenActive;
    }

    public void setTokenActive(boolean tokenActive) {
        isTokenActive = tokenActive;
    }
}
