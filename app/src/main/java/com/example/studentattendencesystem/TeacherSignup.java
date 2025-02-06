package com.example.studentattendencesystem;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
    private TextView errorMessage;

<<<<<<< HEAD
    String url = "http://192.168.221.247/Project/registration.php";
=======
    String url = "http://192.168.24.200/Project/registration.php";
>>>>>>> 5b09090 (Teacher login has been updated)

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

        ImageView imageView = findViewById(R.id.imageView);

        Drawable drawable = getDrawable(R.drawable.signup);

        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).start();
        }

        imageView.setImageDrawable(drawable);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

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
            shakeAnimation(username);
            Toast.makeText(getApplicationContext(), "Enter User name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(emailInput) || !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            shakeAnimation(email);
            Toast.makeText(getApplicationContext(), "Valid email is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwordInput) || passwordInput.length() < 6) {
            shakeAnimation(password);
            Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!passwordInput.equals(confirmPasswordInput)) {
            shakeAnimation(confirmPassword);
            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(departmentInput)) {
            shakeAnimation(department);
            Toast.makeText(getApplicationContext(), "Department is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(phoneInput) && phoneInput.length() != 10) {
            shakeAnimation(phone);
            Toast.makeText(getApplicationContext(), "Contact no is required", Toast.LENGTH_SHORT).show();
            return;
        }
   // }

//    private void sendDataToServer() {

//        String name, mobile, email, password;
//
//        name = edt.getText().toString().trim();
//        mobile = edt2.getText().toString().trim();
//        email = edt3.getText().toString().trim();
//        password = edt4.getText().toString().trim();
//
//        // Validate input
//        if (name.isEmpty() || mobile.isEmpty() || email.isEmpty() || password.isEmpty()) {
//            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
//            return;
//        }

        // Create a Volley request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Create a StringRequest for the POST request
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(TeacherSignup.this, "Server Response: " + response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TeacherSignup.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Send parameters to the server
                Map<String, String> params = new HashMap<>();
                params.put("username", usernameInput);
                params.put("email", emailInput);
                params.put("password", passwordInput);
                params.put("department", departmentInput);
                params.put("phone",phoneInput);
                return params;
            }
        };

        // Add the request to the request queue
        requestQueue.add(stringRequest);
    }

    private void shakeAnimation(View view) {
        ObjectAnimator shake = ObjectAnimator.ofFloat(view, "translationX", 0, 10, -10, 10, -10, 5, -5, 0);
        shake.setDuration(400);
        shake.start();
    }


}