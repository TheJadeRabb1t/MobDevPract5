package com.example.mobdevpract5.UI.views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobdevpract5.R;
import com.example.mobdevpract5.UI.viewModels.MyViewModel;
import com.example.mobdevpract5.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {
    MyViewModel myViewModel;

    final public static String TAG = LoginFragment.class.getSimpleName();
    FragmentLoginBinding binding;
    public static void printSum(long val1, int val2) {
        System.out.println(val1 + val2);
    }
    public LoginFragment(){

    }

    public static LoginFragment newInstance(Bundle data) {
        LoginFragment loginFragment = new LoginFragment();
        if(data != null){
            loginFragment.setArguments(data);
            return loginFragment;
        }
        return newInstance();
    }
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        return inflater.inflate(R.layout.fragment_recucler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            binding.editTextEmail.setText(getArguments().getString("email"));
            binding.editTextPassword.setText(getArguments().getString("password"));
        }
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.saveData("email", binding.editTextEmail.getText().toString());
        myViewModel.saveData("password", binding.editTextPassword.getText().toString());
        binding.editTextEmail.setText(myViewModel.getData("email", "default value"));
        binding.editTextPassword.setText(myViewModel.getData("password", "default value"));
    }

}
