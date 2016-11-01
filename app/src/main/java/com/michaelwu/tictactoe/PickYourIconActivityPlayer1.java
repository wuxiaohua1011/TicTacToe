package com.michaelwu.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

public class PickYourIconActivityPlayer1 extends AppCompatActivity implements View.OnClickListener{
    private Button backButton;
    private ImageButton cameraButton;
    private ImageButton lizardButton, corgiButton, kittenButton, teslaButton, bunnyButton, clownButton, xButton, oButton;
    static final int CAM_REQUEST = 1;
    static final String PLAYER1_CAMERA_USED="PLAYER_1_CAMERA_USED";
    private boolean camera_used = false;
    private int player2ImagePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_your_icon_player_1);
        camera_used=false;
        wireWidget();
        setListener();
        checkImageDuplicate();
    }

    private void checkImageDuplicate() {
        importPlayer2Pic();
        if (player2ImagePath == 0)
        {

        }
        if (player2ImagePath == R.id.activity_pick_your_icon_player_2_imageButton_lizard)
        {
            lizardButton.setClickable(false);
        }
        if (player2ImagePath == R.id.activity_pick_your_icon_player_2_imageButton_corgi)
        {
            corgiButton.setClickable(false);
        }
        if (player2ImagePath == R.id.activity_pick_your_icon_player_2_imageButton_kitten)
        {
            kittenButton.setClickable(false);
        }
        if (player2ImagePath == R.id.activity_pick_your_icon_player_2_imageButton_tesla)
        {
            teslaButton.setClickable(false);
        }
        if (player2ImagePath == R.id.activity_pick_your_icon_player_2_imageButton_bunny)
        {
            bunnyButton.setClickable(false);
        }
        if (player2ImagePath == R.id.activity_pick_your_icon_player_2_imageButton_clown)
        {
            clownButton.setClickable(false);
        }
        if (player2ImagePath == R.id.activity_pick_your_icon_player_2_imageButton_O)
        {
            oButton.setClickable(false);
        }
        if (player2ImagePath == R.id.activity_pick_your_icon_player_2_imageButton_X)
        {
            xButton.setClickable(false);
        }
    }

    private void importPlayer2Pic() {
        SharedPreferences sharePreferences = getSharedPreferences("player2pic",MODE_PRIVATE);
        String path = sharePreferences.getString("player2pic","nothing");

        if (path.equals("nothing")){
            player2ImagePath = 0;
        }
        else{
            player2ImagePath = Integer.parseInt(path);
        }

    }

    private void wireWidget() {
       backButton=(Button)findViewById(R.id.activity_pick_your_icon_player_1_button_back);
        cameraButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_1_imageButton_selfie);
        lizardButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_1_imageButton_lizard);
        corgiButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_1_imageButton_corgi);
        kittenButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_1_imageButton_kitten);
        teslaButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_1_imageButton_tesla);
        bunnyButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_1_imageButton_bunny);
        clownButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_1_imageButton_clown);
        oButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_1_imageButton_O);
        xButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_1_imageButton_X);
    }

    private void setListener() {
        backButton.setOnClickListener(this);
        cameraButton.setOnClickListener(this);
        lizardButton.setOnClickListener(this);
        corgiButton.setOnClickListener(this);
        kittenButton.setOnClickListener(this);
        teslaButton.setOnClickListener(this);
        bunnyButton.setOnClickListener(this);
        clownButton.setOnClickListener(this);
        oButton.setOnClickListener(this);
        xButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        SharedPreferences player1SharedPreferences = getSharedPreferences("player1pic",MODE_PRIVATE);
        SharedPreferences.Editor editor = player1SharedPreferences.edit();
        switch (view.getId()){
            case R.id.activity_pick_your_icon_player_1_button_back:startActivity(new Intent(this,SettingActivity.class));finish();break;
            case R.id.activity_pick_your_icon_player_1_imageButton_selfie:
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);break;
            case R.id.activity_pick_your_icon_player_1_imageButton_lizard:
                editor.putString("player1pic","" + R.drawable.lizard);
                editor.commit();
                break;
            case R.id.activity_pick_your_icon_player_1_imageButton_corgi:
                editor.putString("player1pic","" + R.drawable.corgi);
                editor.commit();
                break;
            case R.id.activity_pick_your_icon_player_1_imageButton_kitten:
                editor.putString("player1pic","" + R.drawable.kitten);
                editor.commit();
                break;
            case R.id.activity_pick_your_icon_player_1_imageButton_tesla:
                editor.putString("player1pic","" + R.drawable.tesla);
                editor.commit();
                break;
            case R.id.activity_pick_your_icon_player_1_imageButton_bunny:
                editor.putString("player1pic","" + R.drawable.bunny);
                editor.commit();
                break;
            case R.id.activity_pick_your_icon_player_1_imageButton_clown:
                editor.putString("player1pic","" + R.drawable.clown);
                editor.commit();
                break;
            case R.id.activity_pick_your_icon_player_1_imageButton_X:
                editor.putString("player1pic","" + R.drawable.x);
                editor.commit();
                break;
            case R.id.activity_pick_your_icon_player_1_imageButton_O:
                editor.putString("player1pic","" + R.drawable.o);
                editor.commit();
                break;
            default:
                Toast.makeText(PickYourIconActivityPlayer1.this, getString(R.string.activity_pickYourIconActivityPlayer1_Toast_something_wrong_happened), Toast.LENGTH_SHORT).show();break;

        }

    }
    private File getFile() {
        File folder = new File("camera_app");
        File image_file;
        if (!folder.exists()) {
            folder.mkdir();
            image_file = new File(folder, "cam_image.jpg");
        } else {
            folder.delete();
            File folder2 = new File("camera_app");
            image_file = new File(folder, "cam_image.jpg");
        }


        return image_file;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        camera_used=true;
        String path = "camera_app/cam_image.jpg";
        cameraButton.setBackground(Drawable.createFromPath(path));
        SharedPreferences sharedPreferences = getSharedPreferences("player1pic",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(PLAYER1_CAMERA_USED,camera_used);
        editor.putString("player1pic",path);
        editor.commit();
    }
}
