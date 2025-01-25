package com.example.studentattendencesystem;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TeacherSignup extends AppCompatActivity {

    private EditText username, email, password, confirmPassword, department, phone;
    private Button signupButton;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_signup);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        department = findViewById(R.id.department);
        phone = findViewById(R.id.phone);
        signupButton = findViewById(R.id.signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInputs();
            }
        });
    }

    private void validateInputs() {
        String usernameInput = username.getText().toString().trim();
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();
        String confirmPasswordInput = confirmPassword.getText().toString().trim();
        String departmentInput = department.getText().toString().trim();
        String phoneInput = phone.getText().toString().trim();

        if (TextUtils.isEmpty(usernameInput)) {
            Toast.makeText(getApplicationContext(), "Enter User name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(emailInput) || !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Toast.makeText(getApplicationContext(), "Valid email is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwordInput) || passwordInput.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!passwordInput.equals(confirmPasswordInput)) {
            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(departmentInput)) {
            Toast.makeText(getApplicationContext(), "Department is required", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(phoneInput) && phoneInput.length() != 10) {
            Toast.makeText(getApplicationContext(), "Contact no is required", Toast.LENGTH_SHORT).show();
        }
    }
}