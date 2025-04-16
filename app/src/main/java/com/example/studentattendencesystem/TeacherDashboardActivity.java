package com.example.studentattendencesystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class TeacherDashboardActivity extends AppCompatActivity {

    LinearLayout takeAttendance, studentReports, manageTimetable,
            examManagement, academicCalendar, messages,
            leaveRequests, aboutSupport;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard); // Replace with your actual layout file

        // Initialize all cards/layouts
        takeAttendance = findViewById(R.id.takeAttendance);
        studentReports = findViewById(R.id.studentReports);
        manageTimetable = findViewById(R.id.manageTimetable);
        examManagement = findViewById(R.id.examManagement);
        messages = findViewById(R.id.messages);
        leaveRequests = findViewById(R.id.leaveRequests);

        // Set click listeners
        takeAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TakeAttendanceActivity.class));
            }
        });

        studentReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StudentReportsActivity.class));
            }
        });



        examManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ExamManagementActivity.class));
            }
        });

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MessagesActivity.class));
            }
        });

        leaveRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LeaveRequestActivity.class));
            }
        });
    }
}
