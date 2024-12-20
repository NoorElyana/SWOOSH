package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // Initialize views
        EditText feedbackEditText = findViewById(R.id.feedbackEditText);
        Button submitFeedbackButton = findViewById(R.id.submitFeedbackButton);

        // Handle feedback submission
        submitFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedback = feedbackEditText.getText().toString().trim();
                if (!feedback.isEmpty()) {
                    // Display a confirmation message
                    Toast.makeText(FeedbackActivity.this, "Feedback submitted: " + feedback, Toast.LENGTH_LONG).show();

                    // Clear the input field after submission
                    feedbackEditText.setText("");
                } else {
                    // Show error if feedback is empty
                    Toast.makeText(FeedbackActivity.this, "Please enter your feedback.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
