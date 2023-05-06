package com.example.mobdevpract5.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobdevpract5.R;
import com.example.mobdevpract5.UI.viewModels.ExternalStorageViewModel;

public class Profile extends Fragment {

    public Profile() {
    }

    public static Profile newInstance() {
        Profile fragment = new Profile();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView nameView = view.findViewById(R.id.name);
        TextView surnameView = view.findViewById(R.id.surname);
        TextView emailView = view.findViewById(R.id.email);

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            nameView.setText(bundle.get("name").toString());
            surnameView.setText(bundle.get("surname").toString());
            emailView.setText(bundle.get("email").toString());
            ExternalStorageViewModel externalStorageViewModel;
            externalStorageViewModel = new ViewModelProvider(this).get(ExternalStorageViewModel.class);
            String fileName = nameView.getText().toString() + " " + surnameView.getText().toString();
            externalStorageViewModel.saveFileToExternalStorage(fileName, emailView.getText().toString().getBytes());
        }
    }
}