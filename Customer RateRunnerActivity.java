package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RateRunnerActivity extends AppCompatActivity {

    private String selectedRunner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_runner);

        // Initialize views
        Spinner runnerSpinner = findViewById(R.id.runnerSpinner);
        RatingBar runnerRatingBar = findViewById(R.id.runnerRatingBar);
        Button submitRatingButton = findViewById(R.id.submitRatingButton);
        TextView selectedRunnerTextView = findViewById(R.id.selectedRunnerTextView);

        // Mock list of runners
        String[] runners = {"Runner A", "Runner B", "Runner C", "Runner D"};

        // Set up Spinner with runner list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, runners);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        runnerSpinner.setAdapter(adapter);

        // Handle runner selection
        runnerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedRunner = runners[position];
                selectedRunnerTextView.setText("Selected Runner: " + selectedRunner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedRunner = null;
            }
        });

        // Handle rating submission
        submitRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedRunner != null) {
                    float rating = runnerRatingBar.getRating();
                    Toast.makeText(RateRunnerActivity.this, "Rated " + selectedRunner + " with " + rating + " stars!", Toast.LENGTH_LONG).show();

                    // Reset rating for next use
                    runnerRatingBar.setRating(0);
                    runnerSpinner.setSelection(0);
                } else {
                    Toast.makeText(RateRunnerActivity.this, "Please select a runner.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
