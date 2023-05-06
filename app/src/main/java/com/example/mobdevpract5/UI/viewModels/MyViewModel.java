package com.example.mobdevpract5.UI.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.mobdevpract5.data.repositories.MyRepository;

public class MyViewModel extends ViewModel {
    private MyRepository myRepository;

    public MyViewModel(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public void saveData(String key, String value) {
        myRepository.saveData(key, value);
    }

    public String getData(String key, String defaultValue) {
        return myRepository.getData(key, defaultValue);
    }
}
