package com.example.mobdevpract5;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Choosing extends Fragment {
    private static final int NOTIFY_ID = 0;
    private final String CHANNEL_ID = "channel_id";
    View view;

    @SuppressLint("MissingPermission")
    public void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Реализация уведомления")
                .setContentText("Продолжение реализации уведомления")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
        notificationManagerCompat.notify(NOTIFY_ID, builder.build());
    }

    public Choosing() {
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
        view.findViewById(R.id.notificationButton).setOnClickListener(v ->{
            showNotification();
        });
        return view;
    }
}