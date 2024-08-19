package com.example.m1test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private TextView NameBox, EmailBox, TelBox, AddBox, GenBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        NameBox = findViewById(R.id.textView2);
        String NameBoxText = getIntent().getStringExtra("Username");
        NameBox.setText(NameBoxText);

        EmailBox = findViewById(R.id.textView4);
        String EmailBoxText = getIntent().getStringExtra("Email");
        EmailBox.setText(EmailBoxText);

        TelBox = findViewById(R.id.textView5);
        String TelBoxText = getIntent().getStringExtra("Tel");
        TelBox.setText(TelBoxText);

        AddBox = findViewById(R.id.textView6);
        String AddBoxText = getIntent().getStringExtra("Address");
        AddBox.setText(AddBoxText);

        GenBox = findViewById(R.id.textView7);
        String GenBoxText = getIntent().getStringExtra("Gender");
        GenBox.setText(GenBoxText);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void GotoCalc(View view) {
        Intent Calcu = new Intent(this,ThirdActivity.class);
    }

    public void GotoIntentActivity(View view) {
        Intent intu = new Intent(this,FourthActivity.class);
    }

    public void GotoGetNo(View view) {
        Intent GetNoo = new Intent(this,FifthActivity.class);
    }
}