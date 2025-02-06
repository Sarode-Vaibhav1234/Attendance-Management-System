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
    Button submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

<<<<<<< HEAD
        Button submitbtn = findViewById(R.id.loginButton);
        EditText prn = findViewById(R.id.prnEditText);
        EditText password = findViewById(R.id.prnEditText);
        TextView tv1 = findViewById(R.id.signUpTextView);
=======
        TextView tv1=findViewById(R.id.signUpTextView);
        // Find the ImageView where the GIF will be displayed
>>>>>>> 5b09090 (Teacher login has been updated)
        ImageView imageView = findViewById(R.id.imageView);

        Drawable drawable = getDrawable(R.drawable.loginimg);

        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).start();
        }

        imageView.setImageDrawable(drawable);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), StudentSignup.class);
                startActivity(i1);
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (prn.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter PRN", Toast.LENGTH_SHORT).show();
                    shakeAnimation(prn);
                }
                if (password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_SHORT).show();
                    shakeAnimation(password);
                }
            }
        });
    }

    private void shakeAnimation(View view) {
        ObjectAnimator shake = ObjectAnimator.ofFloat(view, "translationX", 0, 10, -10, 10, -10, 5, -5, 0);
        shake.setDuration(400);
        shake.start();
    }
}
