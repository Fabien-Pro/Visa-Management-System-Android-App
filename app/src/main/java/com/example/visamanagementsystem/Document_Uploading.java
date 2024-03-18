package com.example.visamanagementsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class Document_Uploading extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private static final int PICK_FILE_REQUEST_CODE = 1;
    private Button chooseFileButton;
    private TextView selectedFileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_uploading);

        chooseFileButton = findViewById(R.id.chooseFileButton);
        selectedFileName = findViewById(R.id.selectedFileName);
        chooseFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*"); // Allow all file types
                startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
            }
        });

// Implement the uploadButton onClickListener for uploading logic
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri uri = data.getData();

            // Get the selected file name
            String fileName = getFileName(uri);
            selectedFileName.setText(fileName);

            // You can implement the file read and upload logic here
        }
    }
    @SuppressLint("Range")
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
        }
        if (result == null) {
            result = uri.getLastPathSegment();
        }
        return result;
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
        else {
            return false;
        }
    }

}