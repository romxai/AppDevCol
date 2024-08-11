package com.example.knowyournumber;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText num;
    private Button submit;
    private TextView result;
    private Spinner choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.NumberIn);
        submit = findViewById(R.id.Submit);
        choice = findViewById(R.id.Choice);
        result = findViewById(R.id.Result);

        ArrayList<String> choiceList = new ArrayList<>();
        choiceList.add("Factorial");
        choiceList.add("Even/Odd");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown, R.id.item, choiceList);
        choice.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(MainActivity.this);
                String input = num.getText().toString();
                String option = choice.getSelectedItem().toString();
                if(TextUtils.isEmpty(input)){
                    num.setError("Field Cannot Be Empty.");
                    Toast.makeText(MainActivity.this, "Field Cannot Be Empty.", Toast.LENGTH_SHORT).show();
                    return;
                }
                int intInput = Integer.parseInt(input), i;
                int resultOut = 1;

                switch (option){
                    case "Factorial":
                        for(i = 1; i<= intInput; i++){
                            resultOut *= i;
                        }
                        result.setText(resultOut + "");
                        break;
                    case "Even/Odd":
                        if(intInput % 2 == 0){
                            result.setText("Even Number");
                        }
                        else{
                            result.setText("Odd Number");
                        }
                        break;
                }
            }
        });

    }

    public static void hideKeyboard(Context context) {
        View view = ((Activity) context).getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.CUPCAKE) {
                imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            }
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}