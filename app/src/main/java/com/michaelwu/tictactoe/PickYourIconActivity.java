package com.michaelwu.tictactoe;

import android.content.Intent;
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

public class PickYourIconActivity extends AppCompatActivity implements View.OnClickListener{
    private Button backButton;
    private ImageButton cameraButton;
    static final int CAM_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_your_icon);
        wireWidget();
        setListener();
    }

    private void wireWidget() {
       backButton=(Button)findViewById(R.id.pick_your_icon_activity_button_back);
        cameraButton = (ImageButton) findViewById(R.id.settingActivity_imageButton_selfie);
    }

    private void setListener() {
        backButton.setOnClickListener(this);
        cameraButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pick_your_icon_activity_button_back:startActivity(new Intent(this,SettingActivity.class));finish();break;
            case R.id.settingActivity_imageButton_selfie:
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);break;
            default:
                Toast.makeText(PickYourIconActivity.this, "Something Wrong happened", Toast.LENGTH_SHORT).show();break;

        }

    }
    private File getFile(){
        File folder = new File("sdcard/camera_app");
        File image_file;
        if (!folder.exists()){
            folder.mkdir();
            image_file = new File(folder,"cam_image.jpg");
        }
        else{
            folder.delete();
            File folder2 = new File("sdcard/camera_app");
            image_file = new File(folder,"cam_image.jpg");
        }


        return image_file;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/camera_app/cam_image.jpg";
        cameraButton.setBackground(Drawable.createFromPath(path));
    }
}
