package com.example.studentattendencesystem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton teacher, student;
        teacher = findViewById(R.id.b1);
        student = findViewById(R.id.b2);

//        teacher.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, TeacherDashboardActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        student.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle student button click
//            }
//        });
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String prn = prnEditText.getText().toString();
//                String psw = pswEditText.getText().toString();
//                // Handle login logic
//            }
//        });
//
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle signup logic
//            }
//        });
//
//        fpswtv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle forgot password logic
//            }
//        });


    }
    public void teacherLogin(View v) {
//        Toast.makeText(this, "Welcome to TeacherLogin", Toast.LENGTH_SHORT).show();
        Intent i1=new Intent(MainActivity.this,TeacherLogin.class);
        startActivity(i1);
    }
    public void studentLogin(View v) {
//        Toast.makeText(this, "Welcome to StudentLogin", Toast.LENGTH_SHORT).show();
        Intent i1=new Intent(MainActivity.this,StudentLogin.class);
        startActivity(i1);
    }

}
