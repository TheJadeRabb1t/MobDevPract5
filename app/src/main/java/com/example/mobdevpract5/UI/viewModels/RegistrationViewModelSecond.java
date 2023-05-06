package com.example.mobdevpract5.UI.viewModels;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobdevpract5.data.models.Hotels;
import com.example.mobdevpract5.data.repositories.HotelsRepositoryForAppSpecificStorage;

public class RegistrationViewModelSecond extends AndroidViewModel {
    private HotelsRepositoryForAppSpecificStorage repository;
    private MutableLiveData<Hotels> data = new MutableLiveData<>();

    public RegistrationViewModelSecond(Application application) {
        super(application);
        Context context = null;
        repository = new HotelsRepositoryForAppSpecificStorage(application);
        data.setValue(repository.getData());
    }

    public void saveData(Hotels newData) {
        repository.saveData(newData);
        data.setValue(repository.getData());
    }

    public LiveData<Hotels> getData() {
        return data;
    }

    Context context = null;
}
