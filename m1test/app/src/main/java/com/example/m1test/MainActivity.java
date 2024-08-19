package com.example.m1test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText name,tel,email,address;
    private RadioGroup gender;
    private RadioButton GenCho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void SubmitForm(View view) {
        name = findViewById(R.id.editTextText);
        email = findViewById(R.id.editTextTextEmailAddress);
        tel = findViewById(R.id.editTextNumber);
        address = findViewById(R.id.editTextTextMultiLine);
        gender = findViewById(R.id.radioGroup);

        int genderChosen = gender.getCheckedRadioButtonId();
        GenCho = (RadioButton)findViewById(genderChosen);
        String Gender;
        if(genderChosen==-1){
            Gender = "None";
        } else {
            Gender = GenCho.getText().toString();
        }

        Intent gotosecond = new Intent(MainActivity.this, SecondActivity.class);
        gotosecond.putExtra("Username",name.getText().toString());
        gotosecond.putExtra("Email",email.getText().toString());
        gotosecond.putExtra("Tel",tel.getText().toString());
        gotosecond.putExtra("Address",address.getText().toString());
        gotosecond.putExtra("Gender", Gender);
        startActivity(gotosecond);
    }


}