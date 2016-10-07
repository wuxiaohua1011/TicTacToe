package com.michaelwu.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private Button playGameButton, settingsButton, rateThisAppButton;

    public void wireWidgets()
    {
        playGameButton = (Button)findViewById(R.id.activity_main_button_play_game);
        settingsButton = (Button)findViewById(R.id.activity_main_button_settings);
        rateThisAppButton = (Button)findViewById(R.id.activity_main_button_rate_this_app);

    }
    public void activity_main_button_play_game_clicked(View view) {
        startActivity(new Intent(this,PvpActivity.class));finish();
    }

    public void activity_main_button_setting_clicked(View view) {
        startActivity(new Intent(this,SettingActivity.class));finish();
    }
}
