package com.example.mobdevpract5.data.repositories;

import android.content.Context;
import android.content.SharedPreferences;

public class MyRepository {
    private SharedPreferences sharedPreferences;

    public MyRepository(Context context) {
        sharedPreferences = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
    }

    public void saveData(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getData(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }
}
