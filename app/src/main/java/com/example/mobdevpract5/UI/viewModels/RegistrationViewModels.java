package com.example.mobdevpract5.UI.viewModels;

import androidx.lifecycle.LiveData;

import com.example.mobdevpract5.data.models.User;
import com.example.mobdevpract5.data.repositories.UserRepository;

import java.util.List;

public class RegistrationViewModels {
    private UserRepository userRepository;
    private LiveData<List<User>> users;

    public LiveData<List<User>> getUsers() {
        return users;
    }
//    public void addUser(String email, String password, String name, String surname) {
//        mItems.setValue(
//        );
}
