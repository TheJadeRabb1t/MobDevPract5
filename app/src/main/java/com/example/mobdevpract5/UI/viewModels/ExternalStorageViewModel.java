package com.example.mobdevpract5.UI.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.mobdevpract5.data.repositories.ExternalStorageRepository;

import java.io.IOException;

public class ExternalStorageViewModel extends ViewModel {
    private ExternalStorageRepository externalStorageRepository;

    public ExternalStorageViewModel() {
        externalStorageRepository = new ExternalStorageRepository();
    }

    public void saveFileToExternalStorage(String fileName, byte[] fileData) {
        try {
            externalStorageRepository.saveFileToExternalStorage(fileName, fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
