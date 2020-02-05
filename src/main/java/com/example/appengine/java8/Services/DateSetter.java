package com.example.appengine.java8.Services;

import com.google.appengine.api.datastore.*;

import java.util.Date;


public class DateSetter {

    public void create(java.util.Date string_date, java.util.Date ending_date) {
        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("Dates");
        PreparedQuery pq = ds.prepare(q);
        Entity dates = pq.asSingleEntity();
        if (dates==null){
            Entity newDate = new Entity("Dates");
            newDate.setProperty("begin_date", string_date);
            newDate.setProperty("ending_date", ending_date);
            ds.put(newDate);
        }else {
            dates.setProperty("begin_date", string_date);
            dates.setProperty("ending_date", ending_date);
            ds.put(dates);
        }
    }

    public boolean isDateValid(){

        boolean validDate = false;

        java.util.Date string_date = null;
        java.util.Date ending_date = null;
        java.util.Date todayDate = new Date();


        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Query q = new Query("Dates");
        PreparedQuery pq = ds.prepare(q);
        for (Entity result : pq.asIterable()) {
            string_date = (Date)result.getProperty("begin_date");
            ending_date = (Date)result.getProperty("ending_date");
        }


        if(todayDate.after(string_date) && todayDate.before(ending_date)) {
            validDate = true;
        }

        return validDate;
    }
}