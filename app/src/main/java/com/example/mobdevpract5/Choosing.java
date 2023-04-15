package com.example.mobdevpract5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Choosing extends Fragment {
    View view;

    public Choosing() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choosing, container, false);
        view.findViewById(R.id.registration_button).setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("buttonPressing", "1");
            Navigation.findNavController(view).navigate(R.id.action_choosing_to_registration, bundle);
        });
        return view;
    }
}