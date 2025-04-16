package com.example.studentattendencesystem;

import android.content.Intent;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.animation.ObjectAnimator;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentLogin extends AppCompatActivity {

    EditText prn, password;
    Button loginbtn;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

        // Binding UI elements
        loginbtn = findViewById(R.id.loginButton);
        prn = findViewById(R.id.prnEditText);
        password = findViewById(R.id.passwordEditText);
        tv1 = findViewById(R.id.signUpTextView);
        ImageView imageView = findViewById(R.id.imageView);

        // Load and animate image
        Drawable drawable = getDrawable(R.drawable.loginimg);
        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).start();
        }
        imageView.setImageDrawable(drawable);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        // SignUp text click
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(StudentLogin.this, StudentSignup.class);
                startActivity(i1);
            }
        });

        // Login button click
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (prn.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter PRN", Toast.LENGTH_SHORT).show();
                    shakeAnimation(prn);
                    return;
                }
                if (password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_SHORT).show();
                    shakeAnimation(password);
                    return;
                }

                // You can add login verification here

                Intent intent = new Intent(StudentLogin.this, StudentDashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    // Back button override (⬅️ goes to MainActivity)
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(StudentLogin.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    // Shake animation if fields are empty
    private void shakeAnimation(View view) {
        ObjectAnimator shake = ObjectAnimator.ofFloat(view, "translationX", 0, 10, -10, 10, -10, 5, -5, 0);
        shake.setDuration(400);
        shake.start();
    }
}
