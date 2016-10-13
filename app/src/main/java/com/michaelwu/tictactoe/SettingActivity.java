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



        SharedPreferences player1Icon = getSharedPreferences("player1pic",MODE_PRIVATE);
        int intPath = player1Icon.getInt("player1pic",0);
        if (intPath == 0){
            String stringPath=player1Icon.getString("player1pic","no path found");
            if (stringPath.equals("no path found")){
                Toast.makeText(SettingActivity.this, "problem occured", Toast.LENGTH_SHORT).show();
            }
            else{
                player1ImageView.setBackground(Drawable.createFromPath(stringPath));
            }
        }
        else{
            player1ImageView.setBackground(Drawable.createFromPath(player1Icon.getString("player1pic","nothing is found")));
        }




    }

    private void wireWidget() {
        backButton=(Button)findViewById(R.id.activity_setting_button_back);
        player1Button=(Button)findViewById(R.id.activity_setting_button_change_player_1_icon);
        player2Button=(Button)findViewById(R.id.activity_setting_button_change_player_2_icon);
        player1ImageView = (ImageView) findViewById(R.id.activity_setting_imageView_player_1);
        player2ImageView = (ImageView) findViewById(R.id.activity_setting_imageView_player2);
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
            case R.id.activity_setting_button_back:startActivity(new Intent(this,MainActivity.class));finish();break;
            case R.id.activity_setting_button_change_player_1_icon:startActivity(new Intent(this,PickYourIconActivityPlayer1.class));finish();break;
            case R.id.activity_setting_button_change_player_2_icon:startActivity(new Intent(this,PickYourIconActivityPlayer2.class));finish();break;
            default:
                Toast.makeText(SettingActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();break;
        }
    }
}
