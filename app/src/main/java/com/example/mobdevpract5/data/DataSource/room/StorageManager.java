package com.example.mobdevpract5.data.DataSource.room;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageManager {
    private Context mContext;

    public StorageManager(Context context) {
        mContext = context;
    }

    public void writeFile(String filename, String content) throws IOException {
        File file = new File(mContext.getFilesDir(), filename);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(content.getBytes());
        outputStream.close();
    }

    public String readFile(String filename) throws IOException {
        File file = new File(mContext.getFilesDir(), filename);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        inputStream.read(bytes);
        inputStream.close();
        return new String(bytes);
    }
}
