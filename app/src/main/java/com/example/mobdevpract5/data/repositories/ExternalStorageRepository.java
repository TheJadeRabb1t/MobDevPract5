package com.example.mobdevpract5.data.repositories;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorageRepository {
    public void saveFileToExternalStorage(String fileName, byte[] fileData) throws IOException, IOException {
        File externalStorage = Environment.getExternalStorageDirectory();
        File file = new File(externalStorage.getAbsolutePath() + "/" + fileName);

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(fileData);
        outputStream.close();
    }
}
