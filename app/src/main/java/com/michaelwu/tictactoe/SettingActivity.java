package com.michaelwu.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SettingActivity extends Activity implements View.OnClickListener {
private Button backButton, player1Button,player2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        wireWidget();
        addListener();
    }

    private void wireWidget() {
        backButton=(Button)findViewById(R.id.activity_setting_button_back);
        player1Button=(Button)findViewById(R.id.activity_setting_button_change_player_1_icon);
        player2Button=(Button)findViewById(R.id.activity_setting_button_change_player_2_icon);
    }

    private void addListener() {
        backButton.setOnClickListener(this);
        player1Button.setOnClickListener(this);
        player2Button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_setting_button_back:startActivity(new Intent(this,MainActivity.class));finish();break;
            case R.id.activity_setting_button_change_player_1_icon:startActivity(new Intent(this,PickYourIconActivity.class));finish();break;
            case R.id.activity_setting_button_change_player_2_icon:startActivity(new Intent(this,PickYourIconActivity.class));finish();break;
            default:
                Toast.makeText(SettingActivity.this, "Something is wrong", Toast.LENGTH_SHORT).show();break;
        }
    }
}
