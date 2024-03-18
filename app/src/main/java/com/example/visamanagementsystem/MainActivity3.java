package com.example.visamanagementsystem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    String fruitList[] ={" User Profile"," United States Visa","United Kingdom Visa","Back Icon","User Profile","Bench Press","Canada Visa"};

    int fruitImages []= {R.drawable.a,R.drawable.us_visa,R.drawable.uk_visa,R.drawable.download,R.drawable.a,R.drawable.canadian_passport_photos,R.drawable.airplane_icon_white_vector_16057386};
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView =(ListView) findViewById(R.id.ApplicantListView);
        ApplicantBaseAdapter applicantBaseAdapter = new ApplicantBaseAdapter(getApplicationContext(),fruitList, fruitImages);
        listView.setAdapter(applicantBaseAdapter);
    }
}