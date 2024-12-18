package com.example.setavailability;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private boolean isOnline = false; // To track online/offline status

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        ImageView earningsIcon = findViewById(R.id.earningsIcon);
        ImageView profileIcon = findViewById(R.id.profileIcon);
        ImageView mapGif = findViewById(R.id.mapGif);
        TextView offlineText = findViewById(R.id.offlineText);
        Button goOnlineButton = findViewById(R.id.goOnlineButton);

        // Load the animated GIF into the ImageView using Glide
        Glide.with(this)
                .asGif()
                .load(R.drawable.map_animation) // Ensure this GIF is in the res/drawable folder
                .into(mapGif);

        // Set up click listener for Earnings Icon
        earningsIcon.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EarningsActivity.class);
            startActivity(intent);
        });

        // Set up click listener for Profile Icon
        profileIcon.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // Set up click listener for Go Online Button
        goOnlineButton.setOnClickListener(v -> {
            if (isOnline) {
                // If the user is online, set to offline
                isOnline = false;
                offlineText.setText("You're offline.");
                offlineText.setTextColor(Color.RED);
                goOnlineButton.setText("Go Online");
            } else {
                // If the user is offline, set to online
                isOnline = true;
                offlineText.setText("You're Online.");
                offlineText.setTextColor(Color.GREEN);
                goOnlineButton.setText("Go Offline");
            }
        });
    }
}
