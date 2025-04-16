package com.example.studentattendencesystem;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

    private TextView signUpTextView;

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
        ImageView imageView = findViewById(R.id.imageView);
        signUpTextView = findViewById(R.id.signUpTextView);

        Drawable drawable = getDrawable(R.drawable.signup);

        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).start();
        }

        imageView.setImageDrawable(drawable);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(getApplicationContext(),StudentLogin.class);
                startActivity(ii);
            }
        });
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

        if (name.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            shakeAnimation(etName);
            return;
        }

        if (prn.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            shakeAnimation(etPrn);
            return;
        }

        if (email.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            shakeAnimation(etEmail);
            return;
        }

        if (admission.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            shakeAnimation(etAdmission);
            return;
        }

        if (contact.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            shakeAnimation(etContact);
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            shakeAnimation(etPassword);
            return;
        }

        if (confirmPassword.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            shakeAnimation(etConfirmPassword);
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





    }
    private void shakeAnimation(View view) {
        ObjectAnimator shake = ObjectAnimator.ofFloat(view, "translationX", 0, 10, -10, 10, -10, 5, -5, 0);
        shake.setDuration(400);
        shake.start();
    }
    public void onBackPressed() {
        Intent intent = new Intent(StudentSignup.this, StudentLogin.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Optional: prevents returning to this activity from login
    }
}
