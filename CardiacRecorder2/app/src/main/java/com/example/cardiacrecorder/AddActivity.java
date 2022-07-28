package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText time_input, date_input, sp_input,dp_input,hr_input,cmt_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        time_input = findViewById(R.id.time_input);
        date_input = findViewById(R.id.date_input);
        sp_input = findViewById(R.id.sp_input);
        dp_input = findViewById(R.id.dp_input);
        hr_input = findViewById(R.id.hr_input);
        cmt_input = findViewById(R.id.cmt_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(time_input.getText().toString().trim(),
                        date_input.getText().toString().trim(),
                        sp_input.getText().toString().trim(),
                        dp_input.getText().toString().trim(),
                        hr_input.getText().toString().trim(),
                        cmt_input.getText().toString().trim());
            }
        });
    }
}