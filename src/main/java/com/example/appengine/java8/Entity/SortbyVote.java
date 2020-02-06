package com.example.appengine.java8.Entity;

import java.util.Comparator;

public class SortbyVote implements Comparator<VotingResult>
{
    public int compare(VotingResult a, VotingResult b)
    {
        return a.votes - b.votes;
    }
}
