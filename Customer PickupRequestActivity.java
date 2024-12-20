package com.example.myapplication;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;

public class PickupRequestActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private EditText editTextPickupLocation;
    private EditText editTextDropOffLocation;
    private TextView textViewDefaultAddress;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_request);

        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        editTextPickupLocation = findViewById(R.id.editTextPickupLocation);
        editTextDropOffLocation = findViewById(R.id.editTextDropOffLocation);
        textViewDefaultAddress = findViewById(R.id.textViewDefaultAddress);
        buttonNext = findViewById(R.id.buttonNext);

        // Set up the toolbar
        setSupportActionBar(toolbar);

        // Set up the drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set default address text
        textViewDefaultAddress.setText("Place: Campus Center\nDistance: 1.5 km\nAddress: 123 University Road, Campus City");

        // Handle "Next" button click
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder for handling next action
                Toast.makeText(PickupRequestActivity.this, "Next button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle clicks on sidebar items (e.g., TextViews for Edit Profile, etc.)
        findViewById(R.id.textEditProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(PickupRequestActivity.this, "Edit Profile clicked", Toast.LENGTH_SHORT).show();
//                go to EditProfileActivity
                Intent intent = new Intent(PickupRequestActivity.this, EditProfileActivity.class);
                startActivity(intent);
                closeDrawer();
            }
        });

        findViewById(R.id.textManageDeliveryPreferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PickupRequestActivity.this, "Manage Delivery Preferences clicked", Toast.LENGTH_SHORT).show();
                closeDrawer();
            }
        });

        findViewById(R.id.textGiveFeedback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PickupRequestActivity.this, "Give Feedback clicked", Toast.LENGTH_SHORT).show();
                closeDrawer();
            }
        });

        findViewById(R.id.textSignOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(PickupRequestActivity.this, "Sign Out clicked", Toast.LENGTH_SHORT).show();
//                go to LoginActivity
                Intent intent = new Intent(PickupRequestActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

                closeDrawer();
            }
        });
    }

    // Close the drawer if open
    private void closeDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    // Handle back button press to close the drawer if it's open
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

