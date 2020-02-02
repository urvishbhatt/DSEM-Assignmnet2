package com.example.appengine.java8.Services;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class VotingService {

    public void AddingTODatabase(String candidate_Name, String token_Number){
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity email = new Entity("Voting");

        email.setProperty("VoteTo", candidate_Name);
        email.setProperty("From_Token_Number", token_Number);

        ds.put(email);
    }
}
