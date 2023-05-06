package com.example.mobdevpract5.data.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mobdevpract5.data.DataSource.UsersDataSource;
import com.example.mobdevpract5.data.models.User;

import java.util.List;

public class UserRepository {
    private UsersDataSource usersDataSource;
    public UserRepository(Application application) {
        this.usersDataSource = new UsersDataSource();
    }

    public LiveData<List<User>> getUser() {
        return usersDataSource.items();
    }

    public void setUser(Application application) {
        this.usersDataSource = usersDataSource;
    }
}
