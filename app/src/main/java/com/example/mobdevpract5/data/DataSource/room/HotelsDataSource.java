package com.example.mobdevpract5.data.DataSource.room;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobdevpract5.data.models.Hotels;

import java.util.ArrayList;
import java.util.List;

public class HotelsDataSource {
    public LiveData<List<Hotels>> items() {
        MutableLiveData<List<Hotels>> result = new MutableLiveData<>();

        new Thread(() -> {
            List<Hotels> resultArr = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                resultArr.add(new Hotels("Hotel #" + (i + 1)));
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
