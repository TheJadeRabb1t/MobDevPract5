package com.example.mobdevpract5.data.DataSource.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobdevpract5.data.DataSource.room.entities.ExerciseEntity;

import java.util.List;

@Dao
public interface ExerciseDAO {
    @Query("SELECT * FROM ExerciseEntity")
    LiveData<List<ExerciseEntity>> getAllExercises();

    @Insert
    void addNewExercise(ExerciseEntity newExercise);
}
