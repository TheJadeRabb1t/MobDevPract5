package com.example.mobdevpract5.data.DataSource.room;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {
    private static final String APP_PREFERENCES = "my_settings";
    private SharedPreferences mSettings;

    public MySharedPreferences(Context context) {
        mSettings = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void setSomeValue(int value) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt("some_key", value);
        editor.apply();
    }

    public int getSomeValue() {
        return mSettings.getInt("some_key", 0);
    }
}
