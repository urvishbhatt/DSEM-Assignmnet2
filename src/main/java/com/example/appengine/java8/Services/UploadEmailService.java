package com.example.appengine.java8.Services;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class UploadEmailService {


    public void uploadFile(String[] nextRecord) {
        System.out.println(nextRecord[0]);

        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity email = new Entity("Email");

        email.setProperty("Email", nextRecord[0]);
        ds.put(email);
    }
}
