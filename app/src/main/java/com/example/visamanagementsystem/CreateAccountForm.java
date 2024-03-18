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

public class CreateAccountForm extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    EditText username, password, password1;
    Button signup, login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_form);
//        email=findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        password1 = findViewById(R.id.password1);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        DB = new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = password1.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(CreateAccountForm.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkUsername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass, repass);
                            if(insert==true){
                                Toast.makeText(CreateAccountForm.this,"User Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),Login_Form.class);
                                startActivity(intent);
                            } else {
                                  Toast.makeText(CreateAccountForm.this,"Registration failed, Please try again",Toast.LENGTH_SHORT).show();
                            }
                            }else{
                            Toast.makeText(CreateAccountForm.this,"User Already exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(CreateAccountForm.this,"Password are not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent intent=new Intent(getApplicationContext(), Login_Form.class);
           startActivity(intent);
            }
        });
    }
    // Menu
    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item){
        int itemId = item.getItemId();
        if (itemId == R.id.item2) {
//            Toast.makeText(this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
            // Start Activity2
            Intent intent = new Intent(this, Login_Form.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.item1) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start CreateAccountForm
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        else if (itemId == R.id.item3) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start CreateAccountForm
            Intent intent = new Intent(this, CreateAccountForm.class);
            startActivity(intent);
            return true;
        }
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