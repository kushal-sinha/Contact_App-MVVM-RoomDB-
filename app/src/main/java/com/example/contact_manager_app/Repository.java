package com.example.contact_manager_app;

import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    // The Available Data Sources:
    // 1. ROOM Database.

    private final ContactDAO contactDAO; // This is the Data Access Object.
    ExecutorService executor;
    Handler handler;

    public Repository(ContactDAO contactDAO) {

        this.contactDAO = contactDAO;
       executor = Executors.newSingleThreadExecutor();
        // Used for Main Thread.
   handler = new Handler(Looper.getMainLooper());
    }
    // Used for Background Threads.


    public void addContact(Contacts contact){


        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Execute this code asynchonously.
                // on a seprate thread.
                contactDAO.insert(contact);
            }
        });
    }

    public void deleteContact(Contacts contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Execute this code asynchonously.
                // on a seprate thread.
                contactDAO.delete(contact);
            }
        });

    }

    public List<Contacts> getAllContacts(){
        //Execute this code asynchonously.
        // on a seprate thread.
        return contactDAO.getAllContacts();
    }
}
