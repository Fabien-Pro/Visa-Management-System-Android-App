package com.example.visamanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class Login_Form extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
EditText username,password;
Button login,signup;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        login=findViewById(R.id.login1);
        signup=findViewById(R.id.signup1);
        DB=new DBHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String pass1=pass;
                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass))
                Toast.makeText(Login_Form.this,"All fields Required",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkUsernamePassword(user, pass, pass1);
                    if (checkuserpass == true) {
                        Toast.makeText(Login_Form.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), ActivityAudio.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(Login_Form.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Form.this,CreateAccountForm.class);
                startActivity(intent);
                finish();
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
        else {
            return false;
        }
    }
}