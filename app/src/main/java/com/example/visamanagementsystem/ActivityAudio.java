package com.example.visamanagementsystem;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class ActivityAudio extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
    }


    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.jehovah);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
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
        else if (itemId == R.id.item7) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start Application form
            Intent intent = new Intent(this,ViewApplicant.class);
            startActivity(intent);
            return true; }
        else if (itemId == R.id.item8) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start Application form
            Intent intent = new Intent(this,ActivityAudio.class);
            startActivity(intent);
            return true; }
        else if (itemId == R.id.item9) {
//            Toast.makeText(this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
            // Start Application form
            Intent intent = new Intent(this,MainActivity3.class);
            startActivity(intent);
            return true; }
        else {
            return false;
        }
    }
}