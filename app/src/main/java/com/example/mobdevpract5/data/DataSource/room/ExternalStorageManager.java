package com.example.mobdevpract5.data.DataSource.room;

import android.content.Context;
import android.os.Environment;

import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorageManager {
    public static boolean writeToExternalStorage(Context context, String fileName, String content) {

        if (!isExternalStorageWritable()) {
            return false;
        }

        File directory = getExternalStoragePublicDirectory(context);

        File file = new File(directory, fileName);

        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    private static File getExternalStoragePublicDirectory(Context context) {
        return ContextCompat.getExternalFilesDirs(context, null)[0];
    }
}
