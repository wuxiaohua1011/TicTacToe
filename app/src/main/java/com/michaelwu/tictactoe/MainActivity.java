package com.michaelwu.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void activity_main_button_play_game_clicked(View view) {
        startActivity(new Intent(this,PvpActivity.class));finish();
    }
    //better comment
}
