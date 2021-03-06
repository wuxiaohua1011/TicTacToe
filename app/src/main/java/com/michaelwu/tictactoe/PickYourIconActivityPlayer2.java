package com.michaelwu.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

public class PickYourIconActivityPlayer2 extends AppCompatActivity implements View.OnClickListener {
    private Button backButton;
    private ImageButton cameraButton;
    private ImageButton lizardButton, corgiButton, kittenButton, teslaButton, bunnyButton, clownButton, xButton, oButton;
    static final int CAM_REQUEST = 1;
    static boolean PLAYER2_CAMERA_USED=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_your_icon_activity_player2);
        wireWidget();
        setListener();
    }

    private boolean checkSameImageWithPlayer1(int imageId){
        SharedPreferences sharedPreferences = getSharedPreferences("player1pic",MODE_PRIVATE);
        String imagePath = sharedPreferences.getString("player1pic","nothing");

        if (PickYourIconActivityPlayer1.camera_used){
            return false;
        }
        else if (Integer.parseInt(imagePath) == imageId){
            return true;
        }
        else{
            return false;
        }
    }

    private void wireWidget() {
        backButton = (Button) findViewById(R.id.activity_pick_your_icon_player_2_button_back);
        cameraButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_selfie);
        lizardButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_lizard);
        corgiButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_corgi);
        kittenButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_kitten);
        teslaButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_tesla);
        bunnyButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_bunny);
        clownButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_clown);
        oButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_O);
        xButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_X);
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
        SharedPreferences player2SharedPreferences = getSharedPreferences("player2pic",MODE_PRIVATE);
        SharedPreferences.Editor editor = player2SharedPreferences.edit();
        PLAYER2_CAMERA_USED=false;
        switch (view.getId()) {
            case R.id.activity_pick_your_icon_player_2_button_back:startActivity(new Intent(this,SettingActivity.class));finish();break;
            case R.id.activity_pick_your_icon_player_2_imageButton_selfie:
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile(this);
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);
                break;
            case R.id.activity_pick_your_icon_player_2_imageButton_lizard:
                if (checkSameImageWithPlayer1(R.drawable.lizard)) {
                    Toast.makeText(PickYourIconActivityPlayer2.this, getString(R.string.activity_pickYourIconPlayer1_and_2_imageDuplicate_toast), Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putString("player2pic", "" + R.drawable.lizard);
                    editor.commit();
                    startActivity(new Intent(this, SettingActivity.class));
                    finish();
                }
                break;
            case R.id.activity_pick_your_icon_player_2_imageButton_corgi:
                if (checkSameImageWithPlayer1(R.drawable.corgi)) {
                    Toast.makeText(PickYourIconActivityPlayer2.this, getString(R.string.activity_pickYourIconPlayer1_and_2_imageDuplicate_toast), Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putString("player2pic", "" + R.drawable.corgi);
                    editor.commit();
                    startActivity(new Intent(this, SettingActivity.class));
                    finish();
                }
                break;
            case R.id.activity_pick_your_icon_player_2_imageButton_kitten:
                if (checkSameImageWithPlayer1(R.drawable.kitten)) {
                    Toast.makeText(PickYourIconActivityPlayer2.this, getString(R.string.activity_pickYourIconPlayer1_and_2_imageDuplicate_toast), Toast.LENGTH_SHORT).show();
                }
                else {

                    editor.putString("player2pic", "" + R.drawable.kitten);
                    editor.commit();
                    startActivity(new Intent(this, SettingActivity.class));
                    finish();
                }
                break;
            case R.id.activity_pick_your_icon_player_2_imageButton_tesla:
                if (checkSameImageWithPlayer1(R.drawable.tesla)) {
                    Toast.makeText(PickYourIconActivityPlayer2.this, getString(R.string.activity_pickYourIconPlayer1_and_2_imageDuplicate_toast), Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putString("player2pic", "" + R.drawable.tesla);
                    editor.commit();
                    startActivity(new Intent(this, SettingActivity.class));
                    finish();
                }
                break;
            case R.id.activity_pick_your_icon_player_2_imageButton_bunny:
                if (checkSameImageWithPlayer1(R.drawable.bunny)) {
                    Toast.makeText(PickYourIconActivityPlayer2.this, getString(R.string.activity_pickYourIconPlayer1_and_2_imageDuplicate_toast), Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putString("player2pic", "" + R.drawable.bunny);
                    editor.commit();
                    startActivity(new Intent(this, SettingActivity.class));
                    finish();
                }
                break;
            case R.id.activity_pick_your_icon_player_2_imageButton_clown:
                if (checkSameImageWithPlayer1(R.drawable.clown)) {
                    Toast.makeText(PickYourIconActivityPlayer2.this, getString(R.string.activity_pickYourIconPlayer1_and_2_imageDuplicate_toast), Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putString("player2pic", "" + R.drawable.clown);
                    editor.commit();
                    startActivity(new Intent(this, SettingActivity.class));
                    finish();
                }
                break;
            case R.id.activity_pick_your_icon_player_2_imageButton_X:
                if (checkSameImageWithPlayer1(R.drawable.x)) {
                    Toast.makeText(PickYourIconActivityPlayer2.this, getString(R.string.activity_pickYourIconPlayer1_and_2_imageDuplicate_toast), Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putString("player2pic", "" + R.drawable.x);
                    editor.commit();
                    startActivity(new Intent(this, SettingActivity.class));
                    finish();
                }
                break;
            case R.id.activity_pick_your_icon_player_2_imageButton_O:
                if (checkSameImageWithPlayer1(R.drawable.o)){
                    Toast.makeText(PickYourIconActivityPlayer2.this, getString(R.string.activity_pickYourIconPlayer1_and_2_imageDuplicate_toast), Toast.LENGTH_SHORT).show();
                }
            else{
                editor.putString("player2pic", "" + R.drawable.o);
                editor.commit();
                startActivity(new Intent(this, SettingActivity.class));
                finish();
                }
                break;
            default:
                Toast.makeText(PickYourIconActivityPlayer2.this, getString(R.string.activity_pickYourIconActivityPlayer2_Toast_something_wrong_happened) , Toast.LENGTH_SHORT).show();
                break;

        }

    }

    public File getFile(Context context) {

        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if(externalFilesDir == null)
        {
            return null;
        }
        return new File(externalFilesDir, getPhotoFileName());
    }
    public String getPhotoFileName() {
        return "cam_image2.jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = this.getFile(this).getPath(); //+ "/camera_app/cam_image2.jpg";
        PLAYER2_CAMERA_USED = true;
        //  Log.d("", "onActivityResult: " + path);
        cameraButton.setBackground(Drawable.createFromPath(path));
        SharedPreferences sharedPreferences = getSharedPreferences("player2pic", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("player2pic",path);
        editor.commit();
    }
}
