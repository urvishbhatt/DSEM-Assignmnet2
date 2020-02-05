package com.example.appengine.java8.Services;

import com.example.appengine.java8.Entity.Emails;
import com.google.appengine.api.datastore.*;

import java.util.ArrayList;
import java.util.List;

public class UploadEmailService {

    String currentUserKey;

    public void uploadFile(String[] nextRecord) {
        if (!isAbleToAdd(nextRecord[0])){
            DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
            Entity email = new Entity("Email");
            email.setProperty("email", nextRecord[0]);
            email.setProperty("isTokenActive",true);
            ds.put(email);
        }
    }

    public List<Emails> getMail(){
        List<Emails> emailsList = new ArrayList<>();
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("Email");
        PreparedQuery pq = ds.prepare(q);
        for (Entity result : pq.asIterable()) {
            String email = (String) result.getProperty("email");
            boolean isTokenActive = (boolean) result.getProperty("isTokenActive");
            Emails emails = new Emails(String.valueOf(result.getKey().getId()),email,isTokenActive);
            emailsList.add(emails);
        }
        return emailsList;
    }

    public boolean isAbleToVote(String currentUserMail){
        boolean justBoolena = false;
        List<Emails> emailsList = getMail();

        for(Emails emails : emailsList ){
            if (currentUserMail.equals(emails.getEmail())){
                if (emails.isTokenActive()){
                    justBoolena = true;
                    currentUserKey = emails.getKey();
                }
            }
        }
        return justBoolena;
    }
    public String getEmailKey(){ return currentUserKey; }

    public boolean isAbleToAdd(String currentUserMail){
        boolean justBoolena = false;
        List<Emails> emailsList = getMail();

        for(Emails emails : emailsList ){
            if (currentUserMail.equals(emails.getEmail())){
                justBoolena = true;
            }
        }
        return justBoolena;
    }

    public void update(String Token_Number){
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("Email");
        PreparedQuery pq = ds.prepare(q);
        for (Entity result : pq.asIterable()) {
            if ((String.valueOf(result.getKey().getId())).equals(Token_Number)){
                result.setProperty("isTokenActive",false);
                ds.put(result);
            }
        }
    }

    public int numberOfVoter(){
        List<Emails> list = getMail();
        return list.size();
    }
}
