package com.michaelwu.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void activity_setting_button_player_1_clicked(View view) {
        startActivity(new Intent(this, PickYourIconActivity.class));finish();
    }

    public void activity_setting_button_player_2_clicked(View view) {
        startActivity(new Intent(this, PickYourIconActivity.class));finish();
    }
}
