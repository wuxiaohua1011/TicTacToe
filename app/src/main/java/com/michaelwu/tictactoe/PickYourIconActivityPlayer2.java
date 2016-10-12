package com.michaelwu.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_your_icon_activity_player2);
        wireWidget();
        setListener();
    }

    private void wireWidget() {
        backButton = (Button) findViewById(R.id.activity_pick_your_icon_player_2_button_back);
        cameraButton = (ImageButton) findViewById(R.id.activity_pick_your_icon_player_2_imageButton_selfie);
    }

    private void setListener() {
        backButton.setOnClickListener(this);
        cameraButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_pick_your_icon_player_2_button_back:
                startActivity(new Intent(this, SettingActivity.class));
                finish();
                break;
            case R.id.activity_pick_your_icon_player_2_imageButton_selfie:
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, 1);
                break;
            default:
                Toast.makeText(PickYourIconActivityPlayer2.this, "Something Wrong happened", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    private File getFile() {
        File folder = new File("sdcard/camera_app2");
        File image_file;
        if (!folder.exists()) {
            folder.mkdir();
            image_file = new File(folder, "cam_image2.jpg");
        } else {
            folder.delete();
            File folder2 = new File("sdcard/camera_app2");
            image_file = new File(folder, "cam_image2.jpg");
        }


        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/camera_app2/cam_image2.jpg";
        cameraButton.setBackground(Drawable.createFromPath(path));
        SharedPreferences sharedPreferences = getSharedPreferences("player2pic",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("player2pic",path);
        editor.commit();
    }
}
