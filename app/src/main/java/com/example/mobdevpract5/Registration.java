package com.example.mobdevpract5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Registration extends Fragment {

    public Registration() {
        // Required empty public constructor
    }

    public static Registration newInstance() {
        Registration fragment = new Registration();
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
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextInputEditText name = view.findViewById(R.id.Name);
        TextInputEditText surname = view.findViewById(R.id.Surname);
        TextInputEditText email = view.findViewById(R.id.Email);

        Button submit = view.findViewById(R.id.submit_button);

        submit.setOnClickListener(v ->{
            Bundle profileInfo = new Bundle();
            profileInfo.putString("name", Objects.requireNonNull(name.getText()).toString());
            profileInfo.putString("surname", Objects.requireNonNull(surname.getText()).toString());
            profileInfo.putString("email", Objects.requireNonNull(email.getText()).toString());
            Navigation.findNavController(view).navigate(R.id.action_registration_to_profile, profileInfo);
        });

    }
}