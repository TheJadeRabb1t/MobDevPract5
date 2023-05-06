package com.example.mobdevpract5.UI.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mobdevpract5.R;
import com.example.mobdevpract5.UI.adapters.RecyclerViewAdapter;
import com.example.mobdevpract5.UI.viewModels.ExternalStorageViewModel;
import com.example.mobdevpract5.UI.viewModels.MyViewModel;
import com.example.mobdevpract5.UI.viewModels.RegistrationViewModelSecond;
import com.example.mobdevpract5.UI.viewModels.RegistrationViewModels;
import com.example.mobdevpract5.data.DataSource.room.MySharedPreferences;
import com.example.mobdevpract5.databinding.RecyclerViewFragmentBinding;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Registration extends Fragment {

    Context context = getActivity();
    RecyclerViewFragmentBinding mBinding;
    RegistrationViewModels mRegistrationViewModels;

    RegistrationViewModelSecond modelSecond;

    private MySharedPreferences mPreferences;

    private MyViewModel myViewModel;

    public Registration() {
        // Required empty public constructor
    }

    public static Registration newInstance() {
        Registration fragment = new Registration();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //appSpecificStorage
        modelSecond = new ViewModelProvider(this).get(RegistrationViewModelSecond.class);
        modelSecond.getData().observe(this, myData -> {
        });

        //externalStorage
        ExternalStorageViewModel externalStorageViewModel = new ViewModelProvider(this).get(ExternalStorageViewModel.class);
        externalStorageViewModel.saveFileToExternalStorage("example.txt", "Hello world".getBytes());

        //sharedPreference
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.saveData("key", "value");
        String data = myViewModel.getData("key", "default value");
        super.onCreate(savedInstanceState);
    }

    @androidx.annotation.Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable Bundle savedInstanceState) {
        mBinding = RecyclerViewFragmentBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
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

        mRegistrationViewModels = new ViewModelProvider(this).get(RegistrationViewModels.class);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerView.setAdapter(new RecyclerViewAdapter());
        mBinding.addItem.setOnClickListener((v) -> {
            mRegistrationViewModels.addItem();
        });

        mRegistrationViewModels.getExercises().observe(getViewLifecycleOwner(), (value) -> {
            ((RecyclerViewAdapter) mBinding.recyclerView.getAdapter()).updateData(value);
        });

    }
}