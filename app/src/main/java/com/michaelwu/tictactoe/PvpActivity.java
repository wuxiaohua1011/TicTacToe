package com.michaelwu.tictactoe;
/*
*player 1 always goes first
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PvpActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView1;
    private Button backButton;
    private ImageButton imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,imageButton12,imageButton20,imageButton21,imageButton22;
    private TextView timeConstraintTextView,player1Score, player2Score;
    private CountDownTimer countDownTimer;
    private int playerTurn = 1;
    private VirtualGameBoard gameBoard;
    private int player1IconResourcePath,player2IconResourcePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);
        wireWidget();
        addListener();
        importPlayer1Icon();
        importPlayer2Icon();
        gameBoard= new VirtualGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                imageButton12,imageButton20,imageButton21,imageButton22);
//        temp22= (ImageButton)findViewById(R.id.PvpActivity_imageButton_22);
//        timeConstraintTextView = (TextView)findViewById(R.id.activity_pvp_textView_timeConstraint);
//
//
//        temp22.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences player1SharedPreferences = getSharedPreferences("player1pic",MODE_PRIVATE);
//                String player1ImagePath = player1SharedPreferences.getString("player1pic","nothing");
//                Toast.makeText(PvpActivity.this, "" + player1ImagePath, Toast.LENGTH_SHORT).show();
//                imageView1.setBackground(Drawable.createFromPath(player1ImagePath));
//            }
//        });
//
//        SharedPreferences sharedPreferences = getSharedPreferences(SettingActivity.TIME_CONSTRAINT,MODE_PRIVATE);
//        final int timeConstraint = sharedPreferences.getInt(SettingActivity.TIME_CONSTRAINT,61);
//        if (timeConstraint == 61){
//            Toast.makeText(PvpActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(PvpActivity.this, ""+timeConstraint, Toast.LENGTH_SHORT).show();
//            countDownTimer = new CountDownTimer(timeConstraint*1000,1000) {
//                @Override
//                public void onTick(long l) {
//                    timeConstraintTextView.setText("Time Left: " + (int)l/1000);
//                }
//
//                @Override
//                public void onFinish() {
//                    Toast.makeText(PvpActivity.this, "Counted "+ timeConstraint, Toast.LENGTH_SHORT).show();
//                }
//            }.start();
//        }

//tp
    }
//// TODO: 10/17/2016 find out how to clear the game once "win" situation is detected 
    //// TODO: 10/17/2016 make everything clearer, add comments, implement more methods rather than writing each procedure over and over again 
    //// TODO: 10/17/2016 fix the issue of  "The application may be doing too much work on its main thread." 
    private void importPlayer2Icon() {
        SharedPreferences sharedPreference = getSharedPreferences("player2pic",MODE_PRIVATE);
        String path = sharedPreference.getString("player2pic","nothing");
        if (!path.equals("nothing")){
            player2IconResourcePath = Integer.parseInt(path);

        }
    }

    private void importPlayer1Icon() {
        SharedPreferences sharedPreference = getSharedPreferences("player1pic",MODE_PRIVATE);
        String path = sharedPreference.getString("player1pic","nothing");
        if (!path.equals("nothing")){
            player1IconResourcePath = Integer.parseInt(path);
        }
    }


    private void addListener() {
        backButton.setOnClickListener(this);
        imageButton00.setOnClickListener(this);
        imageButton01.setOnClickListener(this);
        imageButton02.setOnClickListener(this);
        imageButton10.setOnClickListener(this);
        imageButton11.setOnClickListener(this);
        imageButton12.setOnClickListener(this);
        imageButton20.setOnClickListener(this);
        imageButton21.setOnClickListener(this);
        imageButton22.setOnClickListener(this);
    }

    private void wireWidget() {
        imageButton00=(ImageButton)findViewById(R.id.PvpActivity_imageButton_00);
        imageButton01=(ImageButton)findViewById(R.id.PvpActivity_imageButton_01);
        imageButton02=(ImageButton)findViewById(R.id.PvpActivity_imageButton_02);
        imageButton10=(ImageButton)findViewById(R.id.PvpActivity_imageButton_10);
        imageButton11=(ImageButton)findViewById(R.id.PvpActivity_imageButton_11);
        imageButton12=(ImageButton)findViewById(R.id.PvpActivity_imageButton_12);
        imageButton20=(ImageButton)findViewById(R.id.PvpActivity_imageButton_20);
        imageButton21=(ImageButton)findViewById(R.id.PvpActivity_imageButton_21);
        imageButton22=(ImageButton)findViewById(R.id.PvpActivity_imageButton_22);
        backButton = (Button)findViewById(R.id.PvpActivity_button_back);
        timeConstraintTextView = (TextView)findViewById(R.id.activity_pvp_textView_timeConstraint);
        player1Score = (TextView)findViewById(R.id.PvpActivity_textView_player1_score);
        player2Score=(TextView)findViewById(R.id.PvpActivity_textView_player2_score);

    }
    private void switchPlayer(){
        if (playerTurn==1){
            playerTurn=2;
        }
        else{
            playerTurn=1;
        }
    }

    @Override
    public void onClick(View v) {

        //create a new game board



        switch (v.getId())
        {
            case R.id.PvpActivity_button_back:
                startActivity(new Intent(this,MainActivity.class));finish();break;
            case R.id.PvpActivity_imageButton_00:
               imageButton00.setClickable(false);
                if (playerTurn==1){
                    imageButton00.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton00.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.checkGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                        imageButton12,imageButton20,imageButton21,imageButton22);
                if (gameBoard.detectDraw() == true){
                    Toast.makeText(PvpActivity.this, "draw", Toast.LENGTH_SHORT).show();
                }
                if (gameBoard.detectWin()==true){
                    Toast.makeText(PvpActivity.this, "player" + playerTurn + " won", Toast.LENGTH_SHORT).show();
                }
                switchPlayer();
                break;


            case R.id.PvpActivity_imageButton_01:
                imageButton01.setClickable(false);
                if (playerTurn==1){
                    imageButton01.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton01.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.checkGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                        imageButton12,imageButton20,imageButton21,imageButton22);
                if (gameBoard.detectDraw() == true){
                    Toast.makeText(PvpActivity.this, "draw", Toast.LENGTH_SHORT).show();
                }
                if (gameBoard.detectWin()==true){
                    Toast.makeText(PvpActivity.this, "player" + playerTurn + " won", Toast.LENGTH_SHORT).show();
                }
                    switchPlayer();
                break;
            case R.id.PvpActivity_imageButton_02:
                imageButton02.setClickable(false);
                if (playerTurn==1){
                    imageButton02.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton02.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.checkGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                        imageButton12,imageButton20,imageButton21,imageButton22);
                if (gameBoard.detectDraw() == true){
                    Toast.makeText(PvpActivity.this, "draw", Toast.LENGTH_SHORT).show();
                }
                if (gameBoard.detectWin()==true){
                    Toast.makeText(PvpActivity.this, "player" + playerTurn + " won", Toast.LENGTH_SHORT).show();
                }
                switchPlayer();
                break;

            case R.id.PvpActivity_imageButton_10:
                imageButton10.setClickable(false);
                if (playerTurn==1){
                    imageButton10.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton10.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.checkGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                        imageButton12,imageButton20,imageButton21,imageButton22);
                if (gameBoard.detectDraw() == true){
                    Toast.makeText(PvpActivity.this, "draw", Toast.LENGTH_SHORT).show();
                }
                if (gameBoard.detectWin()==true){
                    Toast.makeText(PvpActivity.this, "player" + playerTurn + " won", Toast.LENGTH_SHORT).show();
                }
                switchPlayer();
                break;
            case R.id.PvpActivity_imageButton_11:
                imageButton11.setClickable(false);
                if (playerTurn==1){
                    imageButton11.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton11.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.checkGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                        imageButton12,imageButton20,imageButton21,imageButton22);
                if (gameBoard.detectDraw() == true){
                    Toast.makeText(PvpActivity.this, "draw", Toast.LENGTH_SHORT).show();
                }
                if (gameBoard.detectWin()==true){
                    Toast.makeText(PvpActivity.this, "player" + playerTurn + " won", Toast.LENGTH_SHORT).show();
                }
                switchPlayer();
                break;
            case R.id.PvpActivity_imageButton_12:
                imageButton12.setClickable(false);
                if (playerTurn==1){
                    imageButton12.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton12.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.checkGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                        imageButton12,imageButton20,imageButton21,imageButton22);
                if (gameBoard.detectDraw() == true){
                    Toast.makeText(PvpActivity.this, "draw", Toast.LENGTH_SHORT).show();
                }
                if (gameBoard.detectWin()==true){
                    Toast.makeText(PvpActivity.this, "player" + playerTurn + " won", Toast.LENGTH_SHORT).show();
                }
                switchPlayer();
                break;

            case R.id.PvpActivity_imageButton_20:
                imageButton20.setClickable(false);
                if (playerTurn==1){
                    imageButton20.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton20.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.checkGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                        imageButton12,imageButton20,imageButton21,imageButton22);
                if (gameBoard.detectDraw() == true){
                    Toast.makeText(PvpActivity.this, "draw", Toast.LENGTH_SHORT).show();
                }
                if (gameBoard.detectWin()==true){
                    Toast.makeText(PvpActivity.this, "player" + playerTurn + " won", Toast.LENGTH_SHORT).show();
                }
                switchPlayer();
                break;

            case R.id.PvpActivity_imageButton_21:
                imageButton21.setClickable(false);
                if (playerTurn==1){
                    imageButton21.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton21.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.checkGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                        imageButton12,imageButton20,imageButton21,imageButton22);
                if (gameBoard.detectDraw() == true){
                    Toast.makeText(PvpActivity.this, "draw", Toast.LENGTH_SHORT).show();
                }
                if (gameBoard.detectWin()==true){
                    Toast.makeText(PvpActivity.this, "player" + playerTurn + " won", Toast.LENGTH_SHORT).show();
                }
                switchPlayer();
                break;

            case R.id.PvpActivity_imageButton_22:
                imageButton22.setClickable(false);
                if (playerTurn==1){
                    imageButton22.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton22.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.checkGameBoard(imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,
                        imageButton12,imageButton20,imageButton21,imageButton22);
                if (gameBoard.detectDraw() == true){
                    Toast.makeText(PvpActivity.this, "draw", Toast.LENGTH_SHORT).show();
                }
                if (gameBoard.detectWin()==true){
                    Toast.makeText(PvpActivity.this, "player" + playerTurn + " won", Toast.LENGTH_SHORT).show();
                }
                switchPlayer();
                break;
            default:
                Toast.makeText(PvpActivity.this, "Oops, something is wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
