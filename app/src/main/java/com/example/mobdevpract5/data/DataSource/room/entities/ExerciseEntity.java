package com.example.mobdevpract5.data.DataSource.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.mobdevpract5.data.models.Hotels;

@Entity
public class ExerciseEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "value")
    public String value;

    public ExerciseEntity() {
    }

    public ExerciseEntity(String value) {
        this.value = value;
    }

    public Hotels toDomainModel(){
        return new Hotels(value);
    }
}
