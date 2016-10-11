package com.michaelwu.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PickYourIconActivity extends AppCompatActivity implements View.OnClickListener{
    private Button cameraButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_your_icon);
        wireWidget();
        setListener();
    }

    private void wireWidget() {
       backButton=(Button)findViewById(R.id.pick_your_icon_activity_button_back);

    }

    private void setListener() {
        backButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pick_your_icon_activity_button_back:startActivity(new Intent(this,SettingActivity.class));finish();break;
            default:
                Toast.makeText(PickYourIconActivity.this, "Something Wrong happened", Toast.LENGTH_SHORT).show();break;
        }

    }
}
