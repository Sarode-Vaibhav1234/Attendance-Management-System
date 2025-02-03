package com.example.studentattendencesystem;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

        // Find the ImageView where the GIF will be displayed
        ImageView imageView = findViewById(R.id.imageView);

        // Load the GIF drawable
        Drawable drawable = getDrawable(R.drawable.login3);  // Ensure your GIF is placed in 'res/drawable'

        if (drawable instanceof AnimatedImageDrawable) {
            // Start the GIF animation if it's an animated drawable
            ((AnimatedImageDrawable) drawable).start();
        }

        // Set the drawable (GIF) to the ImageView
        imageView.setImageDrawable(drawable);

        // Make sure the ImageView adjusts bounds to match the aspect ratio of the image
        imageView.setAdjustViewBounds(true);

        // Set the scaleType to 'centerInside' to scale the image appropriately
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
}
