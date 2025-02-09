package com.example.stopwatch;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button enc, dec, abt;
    ViewFlipper vf;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set full-screen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set the content view
        setContentView(R.layout.activity_main);

        // Initialize buttons
        enc = findViewById(R.id.encd);
        dec = findViewById(R.id.decd);

        // Set button click listeners
        enc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent temp = new Intent(MainActivity.this, Encoder.class); // Ensure Encoder.class exists
                startActivity(temp);
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent temp = new Intent(MainActivity.this, Decoder.class); // Ensure Decoder.class exists
                startActivity(temp);
            }
        });

        // Initialize ViewFlipper
        vf=findViewById(R.id.vf);

        // Add images to ViewFlipper
        int images[] = {
                R.drawable.bellaso_cipher, // Ensure this drawable exists
                R.drawable.caesar_cipher_encryption, // Ensure this drawable exists
                R.drawable.dorabella_cipher // Ensure this drawable exists
        };

        for (int image : images) {
            flipper(image);
        }
    }

    public void flipper(int image) {
        // Create a new ImageView and add it to the ViewFlipper
        ImageView test = new ImageView(this);
        test.setImageResource(image);
        vf.addView(test);

        // Configure ViewFlipper settings
        vf.setFlipInterval(3000); // Set flip interval in milliseconds
        vf.setAutoStart(true);
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
