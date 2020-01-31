package com.example.appengine.java8.Services;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Transaction;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateSetter {

    private Transaction txn;

    public void create(java.util.Date string_date, java.util.Date ending_date) {

//        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

//        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
//        txn = ds.beginTransaction();
//
//        Entity entity = new Entity("Date");
//
//        entity.setProperty("startDateProperty", string_date);
//        entity.setProperty("endDateProperty", ending_date);
//        ds.put(txn, entity);
//        txn.commit();

//        entity.setProperty("staring_date",string_date);
//        entity.setProperty("ending_date",ending_date);
//
//        datastoreService.put(entity);


        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity book = new Entity("Dates");
        book.setProperty("authorBirthdate", string_date);
        book.setProperty("authorBirthdate2", ending_date);
        ds.put(book);

    }

}
