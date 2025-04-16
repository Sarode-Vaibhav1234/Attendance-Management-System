package com.example.studentattendencesystem;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class TeacherSignup extends AppCompatActivity {

    private EditText username, email, password, confirmPassword, department, phone;
    private Button signupButton;

    // Server API URL (Make sure your backend is running and accessible)
     String URL = "http://192.168.70.37/Project/registration.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_signup);

        // Initialize UI Components
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        department = findViewById(R.id.department);
        phone = findViewById(R.id.phone);
        signupButton = findViewById(R.id.signup_button);
        ImageView imageView = findViewById(R.id.imageView);

        // Animated image setup (if applicable)
        Drawable drawable = getDrawable(R.drawable.signup);
        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).start();
        }
        imageView.setImageDrawable(drawable);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        // Set onClickListener for signup button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInputs();
            }
        });
    }

    // Validate user inputs before sending data
    private void validateInputs() {
        String usernameInput = username.getText().toString().trim();
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();
        String confirmPasswordInput = confirmPassword.getText().toString().trim();
        String departmentInput = department.getText().toString().trim();
        String phoneInput = phone.getText().toString().trim();

        if (TextUtils.isEmpty(usernameInput)) {
            shakeAnimation(username);
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(emailInput) || !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            shakeAnimation(email);
            Toast.makeText(this, "Valid email is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwordInput) || passwordInput.length() < 6) {
            shakeAnimation(password);
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!passwordInput.equals(confirmPasswordInput)) {
            shakeAnimation(confirmPassword);
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(departmentInput)) {
            shakeAnimation(department);
            Toast.makeText(this, "Department is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(phoneInput) || phoneInput.length() != 10 || !phoneInput.matches("\\d+")) {
            shakeAnimation(phone);
            Toast.makeText(this, "Enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        // Send data to server
        sendDataToServer(usernameInput, emailInput, passwordInput, departmentInput, phoneInput);
    }

    // Send user data to the backend using Volley
    private void sendDataToServer(String usernameInput, String emailInput, String passwordInput, String departmentInput, String phoneInput) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("API_RESPONSE", "Server Response: " + response);
                        Toast.makeText(TeacherSignup.this, "Response: " + response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String message = (error.getMessage() != null) ? error.getMessage() : "Unknown error";
                        Log.e("API_ERROR", message);
                        Toast.makeText(TeacherSignup.this, "Error: " + message, Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("username", usernameInput);
                params.put("email", emailInput);
                params.put("password", passwordInput);
                params.put("department", departmentInput);
                params.put("phone", phoneInput);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    // Shake animation for invalid input fields
    private void shakeAnimation(View view) {
        ObjectAnimator shake = ObjectAnimator.ofFloat(view, "translationX", 0, 10, -10, 10, -10, 5, -5, 0);
        shake.setDuration(400);
        shake.start();
    }
}
