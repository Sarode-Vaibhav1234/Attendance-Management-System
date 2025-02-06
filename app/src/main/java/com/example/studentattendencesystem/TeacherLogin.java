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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class TeacherLogin extends AppCompatActivity {

    private EditText usernameInput, passwordInput;
    private Button loginButton;
    private TextView tv1;
    private ImageView imageView;
    String url = "http://192.168.24.200/Project/loginTeacher.php";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_login);

        tv1 = (TextView) findViewById(R.id.signUpTxtView);
        imageView =(ImageView) findViewById(R.id.imageview);
        usernameInput = (EditText) findViewById(R.id.username);
        passwordInput = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);

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


        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(), TeacherSignup.class);
                startActivity(i1);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateLogin();
            }
        });
    }

    private void validateLogin() {

        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();


        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(TeacherLogin.this,"Server response" + response,Toast.LENGTH_SHORT).show();
            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(TeacherLogin.this,"Error : "+ error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();
                params.put("username",username);
                params.put("password",password);
                return params;
            }

        };


        requestQueue.add(stringRequest);
    }
}
