package com.example.studentattendencesystem;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class StudentSignup extends AppCompatActivity {

    private EditText etName, etPrn, etEmail, etAdmission, etContact, etPassword, etConfirmPassword;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_signup);

        // Initialize views
        etName = findViewById(R.id.et_name);
        etPrn = findViewById(R.id.et_prn);
        etEmail = findViewById(R.id.et_email);
        etAdmission = findViewById(R.id.et_admission);
        etContact = findViewById(R.id.et_contact);
        etPassword = findViewById(R.id.password);
        etConfirmPassword = findViewById(R.id.confirm_password);
        btnSignup = findViewById(R.id.btn_signup);

        btnSignup.setOnClickListener(v -> signup());
    }

    private void signup() {
        String name = etName.getText().toString().trim();
        String prn = etPrn.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String admission = etAdmission.getText().toString().trim();
        String contact = etContact.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        // Validate inputs
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(prn) || TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(admission) || TextUtils.isEmpty(contact) ||
                TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show();
            return;
        }

        if (contact.length() != 10) {
            Toast.makeText(this, "Contact number must be 10 digits", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Send data to the server
        new Thread(() -> {
            try {
                URL url = new URL("http://10.0.2.2/student_attendence_system/student_signup.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("prn", "UTF-8") + "=" + URLEncoder.encode(prn, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("admission", "UTF-8") + "=" + URLEncoder.encode(admission, "UTF-8") + "&" +
                        URLEncoder.encode("contact", "UTF-8") + "=" + URLEncoder.encode(contact, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                writer.write(data);
                writer.flush();
                writer.close();
                os.close();

                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Handle the server response
                String responseStr = response.toString();
                Log.d("Server Response", responseStr);

                runOnUiThread(() -> {
                    if (responseStr.contains("\"status\":\"success\"")) {
                        Toast.makeText(StudentSignup.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(StudentSignup.this, "Signup failed. Try again.", Toast.LENGTH_SHORT).show();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(StudentSignup.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        }).start();
    }
}
