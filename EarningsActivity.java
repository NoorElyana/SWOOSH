package com.example.setavailability;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EarningsActivity extends AppCompatActivity {

    private TextView totalEarningsText, jobsCompletedText;
    private Button dailyButton, weeklyButton;
    private Spinner monthSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earnings);

        // Initialize views
        totalEarningsText = findViewById(R.id.totalEarningsText);
        jobsCompletedText = findViewById(R.id.jobsCompletedText);
        dailyButton = findViewById(R.id.dailyButton);
        weeklyButton = findViewById(R.id.weeklyButton);
        monthSpinner = findViewById(R.id.monthSpinner);

        // Set default values
        totalEarningsText.setText("Total Earnings: RM 179.50");
        jobsCompletedText.setText("10 Jobs Completed");

        // Set up Spinner for selecting months
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.months,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(adapter);

        monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedMonth = parent.getItemAtPosition(position).toString();
                Toast.makeText(EarningsActivity.this, "Selected: " + selectedMonth, Toast.LENGTH_SHORT).show();
                // Add functionality to update data based on the selected month
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Button click listeners for Daily and Weekly views
        dailyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EarningsActivity.this, "Daily earnings view selected", Toast.LENGTH_SHORT).show();
                // Add functionality to show daily earnings
            }
        });

        weeklyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EarningsActivity.this, "Weekly earnings view selected", Toast.LENGTH_SHORT).show();
                // Add functionality to show weekly earnings
            }
        });

        // (Optional) Add functionality to populate the job list dynamically
        populateJobList();
    }

    private void populateJobList() {
        // Example: Dynamically load job details into the list
        // You can implement RecyclerView here for a scrollable list
        // For simplicity, this method is just a placeholder
    }
}
