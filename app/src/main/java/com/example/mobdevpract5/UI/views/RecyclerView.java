package com.example.mobdevpract5.UI.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobdevpract5.R;
import com.example.mobdevpract5.UI.viewModels.MyViewModel;

public class RecyclerView extends Fragment {

    public RecyclerView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MyViewModel myViewModel;
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.saveData("key", "value");
        String data = myViewModel.getData("key", "default value");
        return inflater.inflate(R.layout.fragment_recucler_view, container, false);
    }
}