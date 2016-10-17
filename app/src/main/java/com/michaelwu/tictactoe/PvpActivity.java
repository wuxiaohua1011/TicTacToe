package com.michaelwu.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PvpActivity extends AppCompatActivity {
private ImageView imageView1;
    private ImageButton temp22;
    private TextView timeConstraintTextView;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);
        imageView1=(ImageView)findViewById(R.id.imageView1);
        temp22= (ImageButton)findViewById(R.id.PvpActivity_imageButton_22);
        timeConstraintTextView = (TextView)findViewById(R.id.activity_pvp_textView_timeConstraint);


        temp22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences player1SharedPreferences = getSharedPreferences("player1pic",MODE_PRIVATE);
                String player1ImagePath = player1SharedPreferences.getString("player1pic","nothing");
                Toast.makeText(PvpActivity.this, ""+player1ImagePath, Toast.LENGTH_SHORT).show();
                imageView1.setBackground(Drawable.createFromPath(player1ImagePath));
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(SettingActivity.TIME_CONSTRAINT,MODE_PRIVATE);
        final int timeConstraint = sharedPreferences.getInt(SettingActivity.TIME_CONSTRAINT,61);
        if (timeConstraint == 61){
            Toast.makeText(PvpActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(PvpActivity.this, ""+timeConstraint, Toast.LENGTH_SHORT).show();
            countDownTimer = new CountDownTimer(timeConstraint*1000,1000) {
                @Override
                public void onTick(long l) {
                    timeConstraintTextView.setText("Time Left: " + (int)l/1000);
                }

                @Override
                public void onFinish() {
                    Toast.makeText(PvpActivity.this, "Counted "+ timeConstraint, Toast.LENGTH_SHORT).show();
                }
            }.start();
        }


    }
    public void back_button_clicked(View view) {
        startActivity(new Intent(this,MainActivity.class ));finish();
    }
}
