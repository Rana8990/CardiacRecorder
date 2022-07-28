package com.example.cardiacrecorder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText m_date2, m_time2, m_sp2,m_dp2, m_hr2, m_cmt2;
    Button update_button, delete_button;

    String id, date, time, sp,dp,hr,cmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        m_date2 = findViewById(R.id.m_date2);
        m_time2 = findViewById(R.id.m_time2);
        m_sp2 = findViewById(R.id.m_sp2);
        m_dp2 = findViewById(R.id.m_dp2);
        m_hr2 = findViewById(R.id.m_hr2);
        m_cmt2 = findViewById(R.id.m_cmt2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(date);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                date = m_date2.getText().toString().trim();
                time = m_time2.getText().toString().trim();
                sp = m_sp2.getText().toString().trim();
                dp = m_dp2.getText().toString().trim();
                hr = m_hr2.getText().toString().trim();
                cmt = m_cmt2.getText().toString().trim();
                myDB.updateData(id, date, time, sp,dp,hr,cmt);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("author") && getIntent().hasExtra("pages")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            date = getIntent().getStringExtra("date");
            time = getIntent().getStringExtra("time");
            sp = getIntent().getStringExtra("sp");
            dp = getIntent().getStringExtra("dp");
            hr = getIntent().getStringExtra("hr");
            cmt = getIntent().getStringExtra("cmt");

            //Setting Intent Data
            m_date2.setText(date);
            m_time2.setText(time);
            m_sp2.setText(sp);
            m_dp2.setText(dp);
            m_hr2.setText(hr);
            m_cmt2.setText(cmt);
            Log.d("stev", date+" "+time+" "+sp+" "+dp+" "+hr+" "+cmt);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + date + " ?");
        builder.setMessage("Are you sure you want to delete " + date + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}