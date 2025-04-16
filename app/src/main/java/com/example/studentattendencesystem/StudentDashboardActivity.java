package com.example.studentattendencesystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDashboardActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentdashboard);
        LinearLayout openPdfBtn = findViewById(R.id.academicCalendar);
        LinearLayout opentimetablebtn = findViewById(R.id.timetable);

        opentimetablebtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), studenttimeActivity.class);
            startActivity(intent);
        });

        openPdfBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PdfViewerActivity.class);
            startActivity(intent);
        });
    }
}
