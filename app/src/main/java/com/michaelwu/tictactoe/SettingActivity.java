package com.michaelwu.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SettingActivity extends Activity implements View.OnClickListener {
private Button backButton, player1Button,player2Button;
    private ImageView player1ImageView, player2ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        wireWidget();
        addListener();


        SharedPreferences player1Icon = getSharedPreferences("player1pic", MODE_PRIVATE);
        String path = player1Icon.getString("player1pic", "nothing");

        if (!path.equals("nothing")) {
            if (path.contains("sd")) {
                player1ImageView.setBackground(Drawable.createFromPath(path));
            } else {
                int pathInt = Integer.parseInt(path);
                player1ImageView.setBackgroundResource(pathInt);
            }
        } else {
            Toast.makeText(SettingActivity.this, "noPicSelected", Toast.LENGTH_SHORT).show();
        }



        SharedPreferences player2Icon = getSharedPreferences("player2pic", MODE_PRIVATE);
        String path2 = player2Icon.getString("player2pic", "nothing");

        if (!path2.equals("nothing")) {
            if (path2.contains("sd")) {
                player2ImageView.setBackground(Drawable.createFromPath(path2));
            } else {
                int pathInt2 = Integer.parseInt(path2);
                player2ImageView.setBackgroundResource(pathInt2);
            }
        } else {
            Toast.makeText(SettingActivity.this, "noPicSelected", Toast.LENGTH_SHORT).show();
        }
    }




    private void wireWidget() {
        backButton=(Button)findViewById(R.id.activity_setting_button_back);
        player1Button=(Button)findViewById(R.id.activity_setting_button_change_player_1_icon);
        player2Button=(Button)findViewById(R.id.activity_setting_button_change_player_2_icon);
        player1ImageView = (ImageView) findViewById(R.id.activity_setting_imageView_player_1);
        player2ImageView = (ImageView) findViewById(R.id.activity_setting_imageView_player_2);
    }

    private void addListener() {
        backButton.setOnClickListener(this);
        player1Button.setOnClickListener(this);
        player2Button.setOnClickListener(this);
        player1ImageView.setOnClickListener(this);
        player2ImageView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_setting_button_back:startActivity(new Intent(this,MainActivity.class));break;
            case R.id.activity_setting_button_change_player_1_icon:startActivity(new Intent(this,PickYourIconActivityPlayer1.class));break;
            case R.id.activity_setting_button_change_player_2_icon:startActivity(new Intent(this,PickYourIconActivityPlayer2.class));break;
            default:
                Toast.makeText(SettingActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();break;
        }
    }
}
