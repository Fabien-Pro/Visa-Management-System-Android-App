package com.example.visamanagementsystem;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class ViewApplicant extends AppCompatActivity {
//    private List<Item> itemList;
//    private ApplicationAdapterClass applicationAdapterClass;

        RecyclerView recyclerView;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_applicant);
            recyclerView = findViewById(R.id.recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);

            DBHelper DB = new DBHelper(this);
            List<ApplicationModelClass> applicationModelClasses = DB.getApplicantList();
            if (applicationModelClasses.size() > 0){
                ApplicationAdapterClass applicationadapterclass= new ApplicationAdapterClass(applicationModelClasses,ViewApplicant.this);
                recyclerView.setAdapter(applicationadapterclass);
            }else {
                Toast.makeText(this, "There is no applicant in the database", Toast.LENGTH_SHORT).show();
            }

    }
}






