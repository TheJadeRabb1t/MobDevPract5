package com.example.mobdevpract5.UI.views;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.mobdevpract5.R;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getBaseContext(), "31321", Toast.LENGTH_SHORT).show();
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        final WindowManager.LayoutParams params = new
                WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        View rootView = LayoutInflater.from(this).inflate(R.layout.fragment_profile, null);
        ((TextView) rootView.findViewById(R.id.name)).setText("Vasya");
        windowManager.addView(rootView, params);
        params.gravity = Gravity.BOTTOM | Gravity.CENTER;
        windowManager.updateViewLayout(rootView, params);

        rootView.findViewById(R.id.return_button).setOnClickListener(v -> {
            windowManager.removeView(rootView);
        });
        return super.onStartCommand(intent, flags, startId);
    }
}