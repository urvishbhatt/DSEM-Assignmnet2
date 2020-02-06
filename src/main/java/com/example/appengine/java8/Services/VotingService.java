package com.example.appengine.java8.Services;

import com.example.appengine.java8.Entity.Votes;
import com.google.appengine.api.datastore.*;

import java.util.ArrayList;
import java.util.List;

public class VotingService {

    public void AddingTODatabase(String candidate_Id, String token_Number){
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity voteing = new Entity("Voting");

        voteing.setProperty("VoteTo", candidate_Id);
        voteing.setProperty("From_Token_Number", token_Number);

        ds.put(voteing);
    }

    public List<Votes> getVote(){
        List<Votes> votesList = new ArrayList<>();
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("Voting");
        PreparedQuery pq = ds.prepare(q);
        for (Entity result : pq.asIterable()) {
            String vote_to = (String) result.getProperty("VoteTo");
            String token_number = (String) result.getProperty("From_Token_Number");
            Votes votes = new Votes(vote_to,token_number);
            votesList.add(votes);
        }
        return votesList;
    }

    public int numberOfVote(){ return getVote().size(); }

    public int candidateVote(String candidate_id){

        return 0;
    }
}
