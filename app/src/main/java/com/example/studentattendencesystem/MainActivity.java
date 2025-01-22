package com.example.studentattendencesystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.DriverManager;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton teacher, student, login, signup;
//        TextView fpswtv;
//        EditText prnEditText, pswEditText;
        teacher = findViewById(R.id.b1);
        student = findViewById(R.id.b2);
//        login = findViewById(R.id.b3);
//        signup = findViewById(R.id.b4);
//        fpswtv = findViewById(R.id.forgotPasswordTextView);
//        prnEditText = findViewById(R.id.prnEditText);
//        pswEditText = findViewById(R.id.passwordEditText);
//
//        // Set up database connection (consider moving this to a separate thread or AsyncTask)
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
//        StrictMode.setThreadPolicy(policy);
//        Connection connection = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String ip = "your_ip"; // replace with actual IP
//            String port = "your_port"; // replace with actual port
//            String database = "your_database"; // replace with actual database name
//            String uname = "root"; // replace with actual username
//            String pass = "root"; // replace with actual password
//            String ConnectionURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";" + "databasename=" + database + ";user=" + uname + ";password=" + pass + ";";
//            connection = DriverManager.getConnection(ConnectionURL);
//            Log.d("DB Connection", "Connection successful");
//        } catch (Exception e) {
//            Log.e("Error in connection", e.getMessage());
//        }
//
//        // Set up click listeners
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
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this, TeacherLogin.class);
                startActivity(i1);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this, StudentLogin.class);
                startActivity(i1);
            }
        });
    }
}
