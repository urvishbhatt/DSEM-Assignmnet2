package com.example.appengine.java8.Entity;

public class Candidate {
    public String key;
    public String name;
    public String surname;
    public String faculty;

    public Candidate(String name,String surname, String faculty){
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
    }

    public Candidate(String key,String name,String surname, String faculty){
        this.key = key;
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
    }

    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}