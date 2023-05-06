package com.example.mobdevpract5.UI.viewModels;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveData;

import com.example.mobdevpract5.data.models.Hotels;
import com.example.mobdevpract5.data.models.User;
import com.example.mobdevpract5.data.repositories.HotelsRepository;
import com.example.mobdevpract5.data.repositories.UserRepository;

import java.util.List;

public class RegistrationViewModels {
    private HotelsRepository repo;
    private LiveData<List<Hotels>> mExercises;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public RegistrationViewModels(Application application) {
        super();
        this.repo = new HotelsRepository(application);
        mExercises = repo.getDatabaseData();
    }

    public LiveData<List<Hotels>> getExercises() {
        return mExercises;
    }

    public void addItem() {
        repo.addItem(new Hotels("Hotels #interesting id"));
    }

}
