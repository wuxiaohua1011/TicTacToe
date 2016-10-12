package com.michaelwu.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class PvpActivity extends AppCompatActivity {
private ImageView imageView1,imageview2;
    private ImageButton temp22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);
        imageView1=(ImageView)findViewById(R.id.imageView1);
        imageview2=(ImageView)findViewById(R.id.imageView2);
        temp22= (ImageButton)findViewById(R.id.PvpActivity_imageButton_22);


        temp22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences player1SharedPreferences = getSharedPreferences("player1pic",MODE_PRIVATE);
                SharedPreferences player2SharedPreferences = getSharedPreferences("player2pic",MODE_PRIVATE);
                String player1ImagePath = player1SharedPreferences.getString("player1pic","nothing");
                Toast.makeText(PvpActivity.this, ""+player1ImagePath, Toast.LENGTH_SHORT).show();
                imageView1.setBackground(Drawable.createFromPath(player1ImagePath));
            }
        });




    }
    public void back_button_clicked(View view) {
        startActivity(new Intent(this,MainActivity.class ));finish();
    }
}
