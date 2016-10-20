package com.michaelwu.tictactoe;
/*
*player 1 always goes first
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PvpActivity extends AppCompatActivity implements View.OnClickListener{
    private Button backButton;
    private ImageButton imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,imageButton12,imageButton20,imageButton21,imageButton22;
    private TextView timeConstraintTextView,player1ScoreTextView, player2ScoreTextView,playerTurnTextView;
    private CountDownTimer countDownTimer;
    private int playerTurn = 1, timeConstraint, player1Score, player2Score;
    private VirtualGameBoard gameBoard;
    private int player1IconResourcePath,player2IconResourcePath;
    private boolean countDownTimerStarted= false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);
        wireWidget();
        addListener();

        importTimeConstraint();
        importPlayer1Icon();
        importPlayer2Icon();
        startNewGame();
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

    private void startNewGame() {
        activateAllImageButton();
        gameBoard=new VirtualGameBoard();
        playerTurnTextView.setText("Player " + playerTurn + "'s turn");
    }

   //// TODO: 10/18/2016 tell the girls to implement scoring system
    //// TODO: 10/17/2016 make everything clearer, add comments, implement more methods rather than writing each procedure over and over again 
    //// TODO: 10/17/2016 fix the issue of  "The application may be doing too much work on its main thread."
    //// TODO: 10/18/2016 fix the camera problem
    //// TODO: 10/18/2016 ask mr shorr why the hell my phone does not run this app

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
        player1ScoreTextView = (TextView)findViewById(R.id.PvpActivity_textView_player1_score);
        player2ScoreTextView=(TextView)findViewById(R.id.PvpActivity_textView_player2_score);
        playerTurnTextView=(TextView)findViewById(R.id.activity_pvp_textView_player_turn);

    }
    private void switchPlayer(){
        if (playerTurn==1){
            playerTurn=2;
        }
        else{
            playerTurn=1;
        }
    }
    private void activateAllImageButton(){
        imageButton00.setBackgroundResource(R.drawable.blank_background);imageButton00.setClickable(true);
        imageButton01.setBackgroundResource(R.drawable.blank_background);imageButton01.setClickable(true);
        imageButton02.setBackgroundResource(R.drawable.blank_background);imageButton02.setClickable(true);
        imageButton10.setBackgroundResource(R.drawable.blank_background);imageButton10.setClickable(true);
        imageButton20.setBackgroundResource(R.drawable.blank_background);imageButton20.setClickable(true);
        imageButton11.setBackgroundResource(R.drawable.blank_background);imageButton11.setClickable(true);
        imageButton22.setBackgroundResource(R.drawable.blank_background);imageButton22.setClickable(true);
        imageButton12.setBackgroundResource(R.drawable.blank_background);imageButton12.setClickable(true);
        imageButton21.setBackgroundResource(R.drawable.blank_background);imageButton21.setClickable(true);


    }
    private void importTimeConstraint(){
        SharedPreferences sharedPreferences = getSharedPreferences(SettingActivity.TIME_CONSTRAINT,MODE_PRIVATE);
        timeConstraint=sharedPreferences.getInt(SettingActivity.TIME_CONSTRAINT,5000);
        timeConstraintTextView.setText(""+timeConstraint);
    }
    private void tempWait() {
        new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                startNewGame();
            }
        }.start();
    }
    private void updateScore(){
        String tempPlayer1Score = getString(R.string.activity_pvp_textView_player1);
        String tempPlayer2Score=getString(R.string.activity_pvp_textView_player2);
        player1ScoreTextView.setText(tempPlayer1Score+player1Score);
        player2ScoreTextView.setText(tempPlayer2Score+player2Score);
    }
    private void addScoretoPlayerX(int player){
        if (player == 1){
            player1Score++;
        }
        else{
            player2Score++;
        }
    }
//   private void activateCountdownTimer(){
//        countDownTimerStarted=true;
//        countDownTimer = new CountDownTimer(timeConstraint*1000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                timeConstraintTextView.setText("Time Left: "+ timeConstraint );
//            }
//
//            @Override
//            public void onFinish() {
//                Toast.makeText(PvpActivity.this, "countDownFinished", Toast.LENGTH_SHORT).show();
//                countDownTimerStarted=false;
//            }
//        }.start();
//    }
//    private void cancelCountdownTimer(){
//        if (countDownTimerStarted){
//            countDownTimer.cancel();
//        }
//    }

    @Override
    public void onClick(View v) {

        //region Activated when you click a button
        switch (v.getId())
        {
            case R.id.PvpActivity_button_back:
                startActivity(new Intent(this,MainActivity.class));finish();break;

            case R.id.PvpActivity_imageButton_00:
                //region ImageButton00 Execution
                imageButton00.setClickable(false);
                if (playerTurn == 1){
                    imageButton00.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton00.setBackgroundResource(player2IconResourcePath);
                }
               gameBoard.updateGameBoard("00"+ playerTurn);
                if (gameBoard.detectWin(playerTurn)){
                    addScoretoPlayerX(playerTurn);
                    Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                if (gameBoard.detectDraw()){
                    Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                switchPlayer();
                playerTurnTextView.setText("Player " + playerTurn + "'s turn");
                break;
            //endregion
            case R.id.PvpActivity_imageButton_01:
                //region imageButton01 Execution
                imageButton01.setClickable(false);
                if (playerTurn == 1){
                    imageButton01.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton01.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.updateGameBoard("01"+ playerTurn);
                if (gameBoard.detectWin(playerTurn)){
                    addScoretoPlayerX(playerTurn);
                    Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                if (gameBoard.detectDraw()){
                    Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                switchPlayer();
                playerTurnTextView.setText("Player " + playerTurn + "'s turn");
                break;
            //endregion
            case R.id.PvpActivity_imageButton_02:
                //region imageButton02 Execution
                imageButton02.setClickable(false);
                if (playerTurn == 1){
                    imageButton02.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton02.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.updateGameBoard("02"+ playerTurn);
                if (gameBoard.detectWin(playerTurn)){
                    addScoretoPlayerX(playerTurn);
                    Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
                    tempWait();

                }
                if (gameBoard.detectDraw()){
                    Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                switchPlayer();
                playerTurnTextView.setText("Player " + playerTurn + "'s turn");
                break;
            //endregion
            case R.id.PvpActivity_imageButton_10:
                //region ImageButton10 Execution
                imageButton10.setClickable(false);
                if (playerTurn == 1){
                    imageButton10.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton10.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.updateGameBoard("10"+ playerTurn);
                if (gameBoard.detectWin(playerTurn)){
                    addScoretoPlayerX(playerTurn);
                    Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                if (gameBoard.detectDraw()){
                    Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                switchPlayer();
                playerTurnTextView.setText("Player " + playerTurn + "'s turn");
                break;
            //endregion
            case R.id.PvpActivity_imageButton_11:
                //region ImageButton11 Execution
                imageButton11.setClickable(false);
                if (playerTurn == 1){
                    imageButton11.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton11.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.updateGameBoard("11"+ playerTurn);
                if (gameBoard.detectWin(playerTurn)){
                    addScoretoPlayerX(playerTurn);
                    Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                if (gameBoard.detectDraw()){
                    Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                switchPlayer();
                playerTurnTextView.setText("Player " + playerTurn + "'s turn");
                break;
            //endregion
            case R.id.PvpActivity_imageButton_12:
                //region ImageButton12 Execution
                imageButton12.setClickable(false);
                if (playerTurn == 1){
                    imageButton12.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton12.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.updateGameBoard("12"+ playerTurn);
                if (gameBoard.detectWin(playerTurn)){
                    addScoretoPlayerX(playerTurn);
                    Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
                    tempWait();


                }
                if (gameBoard.detectDraw()){
                    Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                switchPlayer();playerTurnTextView.setText("Player " + playerTurn + "'s turn");

                break;
            //endregion
            case R.id.PvpActivity_imageButton_20:
                //region ImageButton20 Execution
                imageButton20.setClickable(false);
                if (playerTurn == 1){
                    imageButton20.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton20.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.updateGameBoard("20"+ playerTurn);
                if (gameBoard.detectWin(playerTurn)){
                    addScoretoPlayerX(playerTurn);
                    Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                if (gameBoard.detectDraw()){
                    Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                switchPlayer();
                playerTurnTextView.setText("Player " + playerTurn + "'s turn");
                break;
            //endregion
            case R.id.PvpActivity_imageButton_21:
                //region ImageButton21 Execution
                imageButton21.setClickable(false);
                if (playerTurn == 1){
                    imageButton21.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton21.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.updateGameBoard("21"+ playerTurn);
                if (gameBoard.detectWin(playerTurn)){
                    addScoretoPlayerX(playerTurn);
                    Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                if (gameBoard.detectDraw()){
                    Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                switchPlayer();
                playerTurnTextView.setText("Player " + playerTurn + "'s turn");
                break;
            //endregion
            case R.id.PvpActivity_imageButton_22:
                //region imageButton22 Execution
                imageButton22.setClickable(false);
                if (playerTurn == 1){
                    imageButton22.setBackgroundResource(player1IconResourcePath);
                }
                else{
                    imageButton22.setBackgroundResource(player2IconResourcePath);
                }
                gameBoard.updateGameBoard("22"+ playerTurn);
                if (gameBoard.detectWin(playerTurn)){
                    addScoretoPlayerX(playerTurn);
                    Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                if (gameBoard.detectDraw()){
                    Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
                    tempWait();
                }
                switchPlayer();
                playerTurnTextView.setText("Player " + playerTurn + "'s turn");
                break;
            //endregion
            default:
                Toast.makeText(PvpActivity.this, "Oops, something is wrong", Toast.LENGTH_SHORT).show();
        }
        //endregion
        updateScore();
//TODO: make all buttons unclickable once detected win.


    }


}
