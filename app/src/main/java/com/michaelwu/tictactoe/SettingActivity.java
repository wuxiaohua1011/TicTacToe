package com.michaelwu.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

public class SettingActivity extends Activity implements View.OnClickListener {
private Button backButton, player1Button,player2Button;
    private NumberPicker numberPicker;
    public static final String TIME_CONSTRAINT = "timeConstraint";
    private ImageView p1Image,p2Image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        wireWidget();
        addListener();
        changeP1Image();
       changeP2Image();
        setNumberPicker();
    }

    private void setNumberPicker() {
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(60);
       numberPicker.setValue(5);

    }

    private void changeP2Image() {
        SharedPreferences sharedPreference = getSharedPreferences("player2pic",MODE_PRIVATE);
        String path = sharedPreference.getString("player2pic","nothing");
        if (path.contains("cam_image2")){
            p2Image.setBackground(Drawable.createFromPath(path));
        }
        else if (!path.equals("nothing")){
            int intPath = Integer.parseInt(path);
            p2Image.setBackgroundResource(intPath);
        }
        else{
            p2Image.setBackgroundResource(R.mipmap.o);
        }
    }

    private void changeP1Image() {
        SharedPreferences sharedPreference = getSharedPreferences("player1pic",MODE_PRIVATE);
        String path = sharedPreference.getString("player1pic","nothing");;
        if (path.contains("cam_image")){
            path = sharedPreference.getString("player1pic","nothing");
            p1Image.setBackground(Drawable.createFromPath(path));
        }
       else if (!path.equals("nothing")){
            int intPath = Integer.parseInt(path);
            p1Image.setBackgroundResource(intPath);
        }
        else{
            p1Image.setBackgroundResource(R.mipmap.x);
        }
    }

    private void wireWidget() {
        backButton=(Button)findViewById(R.id.activity_setting_button_back);
        player1Button=(Button)findViewById(R.id.activity_setting_button_change_player_1_icon);
        player2Button=(Button)findViewById(R.id.activity_setting_button_change_player_2_icon);
        numberPicker=(NumberPicker)findViewById(R.id.activity_setting_numberPicker_time);
        numberPicker.setValue(5);
        p1Image = (ImageView)findViewById(R.id.activity_setting_imageView_player_1);
        p2Image = (ImageView)findViewById(R.id.activity_setting_imageView_player_2);
    }

    private void addListener() {
        backButton.setOnClickListener(this);
        player1Button.setOnClickListener(this);
        player2Button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(TIME_CONSTRAINT,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(TIME_CONSTRAINT,numberPicker.getValue());
        editor.commit();
        switch (view.getId()){
            case R.id.activity_setting_button_back:startActivity(new Intent(this,MainActivity.class));break;
            case R.id.activity_setting_button_change_player_1_icon:startActivity(new Intent(this,PickYourIconActivityPlayer1.class));break;
            case R.id.activity_setting_button_change_player_2_icon:startActivity(new Intent(this,PickYourIconActivityPlayer2.class));break;
            default:
                Toast.makeText(SettingActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();break;
        }
    }
}
