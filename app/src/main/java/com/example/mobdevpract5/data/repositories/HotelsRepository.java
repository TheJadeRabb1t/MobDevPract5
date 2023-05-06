package com.example.mobdevpract5.data.repositories;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.mobdevpract5.data.DataSource.room.ExternalStorageManager;
import com.example.mobdevpract5.data.DataSource.room.HotelsDataSource;
import com.example.mobdevpract5.data.DataSource.room.MySharedPreferences;
import com.example.mobdevpract5.data.DataSource.room.StorageManager;
import com.example.mobdevpract5.data.DataSource.room.entities.ExerciseEntity;
import com.example.mobdevpract5.data.DataSource.room.root.AppDatabase;
import com.example.mobdevpract5.data.models.Hotels;

import java.util.List;
import java.util.stream.Collectors;

public class HotelsRepository {
    private HotelsDataSource mDataSource;
    private AppDatabase databaseSource;

    private StorageManager storageManager;

    private ExternalStorageManager externalStorageManager;

    private MySharedPreferences mySharedPreferences;


    public HotelsRepository(Application application) {
        this.mDataSource = new HotelsDataSource();
        this.databaseSource = AppDatabase.getDatabase(application);
    }

    public LiveData<List<Hotels>> getData() {
        return mDataSource.items();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public LiveData<List<Hotels>> getDatabaseData() {
        return Transformations.map(
                databaseSource.exerciseDAO().getAllExercises(),
                (values) -> values.stream().map(ExerciseEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public void addItem(Hotels newExercise) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            databaseSource.exerciseDAO().addNewExercise(new ExerciseEntity(newExercise.getValue()));
        });
    }
}
