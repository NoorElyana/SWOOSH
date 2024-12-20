package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;

public class EditProfileActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhoneNumber;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // Initialize Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Edit Profile");
        }

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        buttonSave = findViewById(R.id.buttonSave);

        // Load existing user data (this is dummy data for now)
        loadUserData();

        // Handle Save button click
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
            }
        });
    }

    private void loadUserData() {
        // Simulate loading user data (replace with actual data from a database or API)
        editTextName.setText("John Doe");
        editTextEmail.setText("johndoe@example.com");
        editTextPhoneNumber.setText("+1234567890");
    }

    private void saveUserData() {
        // Get the input values
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();

        // Validate the inputs
        if (name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
            Toast.makeText(EditProfileActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simulate saving data (replace this with actual database or API call)
        Toast.makeText(EditProfileActivity.this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();

        // Optionally, finish the activity
        // finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


}
