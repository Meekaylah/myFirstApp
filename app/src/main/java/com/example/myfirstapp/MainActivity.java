package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /* Called when the user taps the Send Button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editTextText);
        String message = editText.getText().toString();
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        String radioText = selectedRadioButton.getText().toString();
        EditText password = findViewById(R.id.editTextTextPassword);
        String passText = password.getText().toString();
        CheckBox checkBox = findViewById(R.id.checkBox);
        String isChecked = String.valueOf(checkBox.isChecked());
        Spinner spinner = findViewById(R.id.spinner);
        String spinVal = spinner.getSelectedItem().toString();
        SwitchCompat switchB = findViewById(R.id.switch1);
        String isSwitched = String.valueOf(switchB.isChecked());
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("radioValue", radioText);
        intent.putExtra("passValue", passText);
        intent.putExtra("checkValue", isChecked);
        intent.putExtra("spinValue", spinVal);
        intent.putExtra("switchValue", isSwitched);
        startActivity(intent);
    }
}