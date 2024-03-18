package com.example.visamanagementsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class Application_Form extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    EditText name,email,res_country,dob,pov,dot,doi,doe;
    Button button_submit,button_view;
    @SuppressLint({"MissingInflatedId","WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_form);
        name = findViewById(R.id.editText2);
        email = findViewById(R.id.editText3);
        res_country = findViewById(R.id.editText4);
        dob = findViewById(R.id.editText5);
        pov = findViewById(R.id.editText6);
        dot = findViewById(R.id.editText7);
        doi = findViewById(R.id.editText8);
        doe = findViewById(R.id.editText9);
        button_submit = findViewById(R.id.button_submit);
        button_view = findViewById(R.id.button_view);

        button_submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = name.getText().toString();
                String stringEmail = email.getText().toString();
                String stringRes_country = res_country.getText().toString();
                String stringDob = dob.getText().toString();
                String stringPov = pov.getText().toString();
                String stringDot = dot.getText().toString();
                String stringDoi = doi.getText().toString();
                String stringDoe = doe.getText().toString();

                if (stringName.length() <= 0 || stringEmail.length() <= 0||stringRes_country.length()<=0||stringDob.length()<=0||stringPov.length()<=0||stringDot.length()<=0||stringDoi.length()<=0||stringDoe.length()<=0) {
                    Toast.makeText(Application_Form.this, "Please Enter All Data before save", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper DB = new DBHelper(Application_Form.this);
                    ApplicationModelClass applicationModelClass = new ApplicationModelClass(stringName, stringEmail, stringRes_country, stringDob, stringPov, stringDot, stringDoi, stringDoe);
                    DB.addApplicant(applicationModelClass);
                    Toast.makeText(Application_Form.this, "You are Successfully applied", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                    }
                }
        });

        button_view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Application_Form.this, ViewApplicant.class);
                startActivity(intent);
            }
        });
    }

    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item){
        int itemId = item.getItemId();
        if (itemId == R.id.item1) {
//            Toast.makeText(this, "Item 1 clicked", Toast.LENGTH_SHORT).show();
            // Start Main Activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.item2) {
//            Toast.makeText(this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
            // Start Activity2
            Intent intent = new Intent(this, Login_Form.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.item3) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start CreateAccountForm
            Intent intent = new Intent(this, CreateAccountForm.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.item4) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start Application form
            Intent intent = new Intent(this, Application_Form.class);
            startActivity(intent);
            return true; }
        else if (itemId == R.id.item5) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start Application form
            Intent intent = new Intent(this, Document_Uploading.class);
            startActivity(intent);
            return true; }
        else if (itemId == R.id.item6) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start Application form
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
            return true; }
        else if (itemId == R.id.item8) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start Application form
            Intent intent = new Intent(this,ActivityAudio.class);
            startActivity(intent);
            return true; }
        else if (itemId == R.id.item7) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start Application form
            Intent intent = new Intent(this,ViewApplicant.class);
            startActivity(intent);
            return true; }
        else if (itemId == R.id.item9) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start Application form
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
            return true; }
        else {
            return false;
        }
    }
    }

