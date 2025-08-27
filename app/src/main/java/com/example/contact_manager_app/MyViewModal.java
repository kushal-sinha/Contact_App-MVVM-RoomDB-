package com.example.contact_manager_app;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModal extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Contacts>> allContacts;

    // Constructor for the ViewModel
    public MyViewModal(@NonNull Application application) {
        super(application);

        // The constructor of the Repository class is called here
        // to initialize the 'repository' variable.
        // This is a common practice in Android development using the MVVM
        // (Model-View-ViewModel) architecture.

        // The 'repository' is responsible for handling data operations,
        // such as fetching data from a database or a network API.
        this.repository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        allContacts = repository.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contacts contact){
        repository.addContact(contact);
    }

    public void deleteContact(Contacts contact){
        repository.deleteContact(contact);
    }
}
