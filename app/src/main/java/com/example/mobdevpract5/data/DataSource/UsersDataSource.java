package com.example.mobdevpract5.data.DataSource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobdevpract5.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDataSource {
    public LiveData<List<User>> items() {
        MutableLiveData<List<User>> result = new MutableLiveData<>();

        new Thread(() -> {
            ArrayList<User> resultArr = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                resultArr.add(new User("gh", "kl", "dsf", "sfd"));
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            result.postValue(resultArr);
        }).start();


        return result;
    }
}

