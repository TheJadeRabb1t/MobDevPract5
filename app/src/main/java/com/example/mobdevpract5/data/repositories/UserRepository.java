package com.example.mobdevpract5.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.mobdevpract5.data.DataSource.room.UsersDataSource;
import com.example.mobdevpract5.data.models.User;

import java.util.List;

public class UserRepository {
    private UsersDataSource usersDataSource;
    private User user;
    public UserRepository(User user) {
        this.user = user;
    }

    public LiveData<List<User>> getUser() {
        return usersDataSource.items();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
