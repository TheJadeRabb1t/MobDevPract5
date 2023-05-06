package com.example.mobdevpract5.data.repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import com.example.mobdevpract5.data.models.Hotels;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HotelsRepositoryForAppSpecificStorage {
    private SharedPreferences preferences;

    public HotelsRepositoryForAppSpecificStorage(Context context) {
        preferences = context.getSharedPreferences("my_app_data", Context.MODE_PRIVATE);
    }

    public void saveData(Hotels data) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("data_key", serializeData(data));
        editor.apply();
    }

    public Hotels getData() {
        String dataString = preferences.getString("data_key", null);
        return deserializeData(dataString);
    }

    private String serializeData(Hotels data) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(data);
            so.flush();
            return Base64.encodeToString(bo.toByteArray(), Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Hotels deserializeData(String dataString) {
        try {
            byte[] bytes = Base64.decode(dataString, Base64.DEFAULT);
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Hotels) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
