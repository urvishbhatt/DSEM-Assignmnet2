package com.example.appengine.java8.Entity;

public class Votes {
    String vote_to, token_number;

    public Votes(String vote_to, String token_number) {
        this.vote_to = vote_to;
        this.token_number = token_number;
    }

    public String getVote_to() {
        return vote_to;
    }

    public void setVote_to(String vote_to) {
        this.vote_to = vote_to;
    }

    public String getToken_number() {
        return token_number;
    }

    public void setToken_number(String token_number) {
        this.token_number = token_number;
    }
}
