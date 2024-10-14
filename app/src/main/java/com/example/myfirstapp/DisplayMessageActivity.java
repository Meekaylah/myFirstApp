package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String pass_radio = intent.getStringExtra("radioValue");
        String pass = intent.getStringExtra("passValue");
        String show = intent.getStringExtra("checkValue");
        String gender = intent.getStringExtra("spinValue");
        String notifications = intent.getStringExtra("switchValue");


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textViewMessage);
        TextView radioText = findViewById(R.id.textViewPassRadio);
        TextView passText = findViewById(R.id.textViewPass);
        TextView showText = findViewById(R.id.textViewShow);
        TextView genText = findViewById(R.id.textViewGender);
        TextView notText = findViewById(R.id.textViewNot);

        textView.setText(message);
        radioText.setText(pass_radio);
        showText.setText(show);
        genText.setText(gender);
        notText.setText(notifications);
        passText.setText(pass);
    }
}