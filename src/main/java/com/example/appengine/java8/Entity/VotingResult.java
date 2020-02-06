package com.example.appengine.java8.Entity;

public class VotingResult {
    String name;
    String faculty;
    int votes;

    public VotingResult(String name, String faculty, int votes) {
        this.name = name;
        this.faculty = faculty;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
