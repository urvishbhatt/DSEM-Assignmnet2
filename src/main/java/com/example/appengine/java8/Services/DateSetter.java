package com.example.appengine.java8.Services;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


public class DateSetter {

    public void create(java.util.Date string_date, java.util.Date ending_date) {

        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity dates = new Entity("Dates");

        dates.setProperty("begin_date", string_date);
        dates.setProperty("ending_date", ending_date);
        ds.put(dates);

    }

}
