package com.example.appengine.java8.Services;

import com.example.appengine.java8.Entity.Candidate;
import com.google.appengine.api.datastore.*;

import java.util.ArrayList;
import java.util.List;

public class CandidateService {

    public void create(String Name, String Surname, String Faculty){
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity candidate = new Entity("Cadidates");

        candidate.setProperty("Name", Name);
        candidate.setProperty("Surname", Surname);
        candidate.setProperty("Faculty", Faculty);
        ds.put(candidate);
    }
//
    public List<Candidate> getCandidateList(){
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("Cadidates");
        PreparedQuery pq = ds.prepare(q);
        List<Candidate> candidateList = new ArrayList<>();

        for (Entity result : pq.asIterable()) {
            String key = String.valueOf(result.getKey().getId());
            String name = (String) result.getProperty("Name");
            String surname = (String) result.getProperty("Surname");
            String faculty = (String) result.getProperty("Faculty");
            Candidate candidate = new Candidate(key,name,surname,faculty);
            candidateList.add(candidate);
        }

        return candidateList;
    }
}
