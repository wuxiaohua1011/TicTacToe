package com.michaelwu.tictactoe;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
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
    private int player1IconResourcePathInt,player2IconResourcePathInt;
    private String player1IconResourcePathCameraUsed,player2IconResourcePathCameraUsed;
    private boolean runningPvpTimer = true;
    private boolean countDownTimerStarted= false;
    private boolean isPlayer1CameraUsed,isPlayer2CameraUsed;



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
    }

    /**
     * Resets board
     */
    private void startNewGame() {
        //opt: Toast.makeText(this, "New Game starts in 3.5 seconds.", Toast.LENGTH_LONG).show();//
        //if this happens and thread pauses during the display time, the board will not reset until disappears.
        //But you want it to clear first, then toast, then start timer
        activateAllImageButton();
        activateCountdownTimer();//you want to start timer immediately. opt. this'll change
        //TODO: activate countdown timer when new round. not game.
        //TODO: make the timer hold for a second on 1 and 5.
        //TODO: stop timer when you leave pvp
        // current one
        gameBoard=new VirtualGameBoard();
        playerTurnTextView.setText("Player " + playerTurn + "'s turn");
    }

    private void importPlayer2Icon() {
        SharedPreferences sharedPreference = getSharedPreferences("player2pic",MODE_PRIVATE);
        String path = sharedPreference.getString("player2pic","nothing");
        isPlayer2CameraUsed= sharedPreference.getBoolean(PickYourIconActivityPlayer2.PLAYER2_CAMERA_USED,false);
        if (isPlayer2CameraUsed){
            player2IconResourcePathCameraUsed = path;
        }
        else if (path.equals("nothing")){
            player2IconResourcePathInt= R.drawable.o;

        }
        else{
            player2IconResourcePathInt=Integer.parseInt(path);
        }

    }
    private void importPlayer1Icon() {
        SharedPreferences sharedPreference = getSharedPreferences("player1pic",MODE_PRIVATE);
        String path = sharedPreference.getString("player1pic","nothing");
        isPlayer1CameraUsed= sharedPreference.getBoolean(PickYourIconActivityPlayer1.PLAYER1_CAMERA_USED,false);
        if (isPlayer1CameraUsed){
            player1IconResourcePathCameraUsed = path;
        }
        else if (path.equals("nothing")){
            player1IconResourcePathInt= R.drawable.x;
        }
        else{
            player1IconResourcePathInt=Integer.parseInt(path);
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

    /**
     * Lets the game know that the active player has changed.
     */
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
    private void inactiveAllImageButton(){
        imageButton00.setClickable(false);
        imageButton01.setClickable(false);
        imageButton02.setClickable(false);
        imageButton10.setClickable(false);
       imageButton20.setClickable(false);
        imageButton11.setClickable(false);
        imageButton22.setClickable(false);
        imageButton12.setClickable(false);
        imageButton21.setClickable(false);
    }
    private void importTimeConstraint(){
        SharedPreferences sharedPreferences = getSharedPreferences(SettingActivity.TIME_CONSTRAINT,MODE_PRIVATE);
        timeConstraint=sharedPreferences.getInt(SettingActivity.TIME_CONSTRAINT,5);
        timeConstraintTextView.setText(""+timeConstraint);
    }

    /**
     * Makes a pause
     */
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

    /**
     * TODO: stop the "countdown finished" toast from appearing infinitely.
     */
    private void updateScore(){
        String tempPlayer1Score = getString(R.string.activity_pvp_textView_player1);
        String tempPlayer2Score=getString(R.string.activity_pvp_textView_player2);
        player1ScoreTextView.setText(tempPlayer1Score+player1Score);
        player2ScoreTextView.setText(tempPlayer2Score+player2Score);
    }

    /**
     * Increments the active player's score (winning player)
     * @param player either 1 or something else (2?) indicative of the current active player
     */
    private void addScoretoPlayerX(int player){
        if (player == 1){
            player1Score++;
        }
        else{
            player2Score++;
        }
    }

    private void cancelCountDownTimer(){
        if (countDownTimerStarted){
            countDownTimer.cancel();
        }
    }

   private void activateCountdownTimer(){
        countDownTimerStarted=true;
        countDownTimer = new CountDownTimer(timeConstraint*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeConstraintTextView.setText("Time Left: "+ (int)(1+millisUntilFinished)/1000);
                    if(runningPvpTimer == false)
                    {
                        countDownTimer.cancel();
                    }
                } //makes the 0 appear, but small delay not exactly on click

            @Override
            public void onFinish() {
                timeConstraintTextView.setText("Time Left: " + 0);//TODO: works, but a little delay between 1 and 0
                Toast.makeText(PvpActivity.this, "countDownFinished", Toast.LENGTH_SHORT).show();
                countDownTimerStarted=false;
                switchPlayer();
                activateCountdownTimer();//omg will this make the timer start over once the next player's turn??
            }
        }.start();
    }

    private void imageButtonClicked(ImageButton tempImageButton, String positionInGameBoard){
        tempImageButton.setClickable(false);
       if (playerTurn==1){
           if (isPlayer1CameraUsed){
               tempImageButton.setBackground(Drawable.createFromPath(player1IconResourcePathCameraUsed));
           }
           else{
               tempImageButton.setBackgroundResource(player1IconResourcePathInt);
           }
       }
        else{
           if (isPlayer2CameraUsed){
               tempImageButton.setBackground(Drawable.createFromPath(player2IconResourcePathCameraUsed));
           }
           else{
               tempImageButton.setBackgroundResource(player2IconResourcePathInt);
           }

       }

        gameBoard.updateGameBoard(positionInGameBoard+ playerTurn);
        if (gameBoard.detectWin(playerTurn)){
            addScoretoPlayerX(playerTurn);
            Toast.makeText(PvpActivity.this, "Player " + playerTurn + " won", Toast.LENGTH_SHORT).show();
            inactiveAllImageButton();
            tempWait();
        }
        if (gameBoard.detectDraw()){
            Toast.makeText(PvpActivity.this, "Draw", Toast.LENGTH_SHORT).show();
            tempWait();
        }
        switchPlayer();
        playerTurnTextView.setText("Player " + playerTurn + "'s turn");

    }
    @Override
    public void onClick(View v) {
        //region Activated when you click a button
        switch (v.getId())
        {
            case R.id.PvpActivity_button_back:
                startActivity(new Intent(this,MainActivity.class));finish();cancelCountDownTimer();break;
                //ADDITION
            case R.id.PvpActivity_imageButton_00:
                cancelCountDownTimer();imageButtonClicked(imageButton00,"00");break;
            case R.id.PvpActivity_imageButton_01:cancelCountDownTimer();
                cancelCountDownTimer();imageButtonClicked(imageButton01,"01");break;
            case R.id.PvpActivity_imageButton_02:cancelCountDownTimer();
                cancelCountDownTimer();imageButtonClicked(imageButton02,"02");break;
            case R.id.PvpActivity_imageButton_10:cancelCountDownTimer();
                cancelCountDownTimer();imageButtonClicked(imageButton10,"10");break;
            case R.id.PvpActivity_imageButton_11:cancelCountDownTimer();
                cancelCountDownTimer();imageButtonClicked(imageButton11,"11");break;
            case R.id.PvpActivity_imageButton_12:cancelCountDownTimer();
                cancelCountDownTimer();imageButtonClicked(imageButton12,"12");break;
            case R.id.PvpActivity_imageButton_20:cancelCountDownTimer();
                cancelCountDownTimer();imageButtonClicked(imageButton20,"20");break;
            case R.id.PvpActivity_imageButton_21:cancelCountDownTimer();
                cancelCountDownTimer();imageButtonClicked(imageButton21,"21");break;
            case R.id.PvpActivity_imageButton_22:cancelCountDownTimer();
                cancelCountDownTimer();imageButtonClicked(imageButton22,"22");break;
            default:
                Toast.makeText(PvpActivity.this, "Oops, something is wrong", Toast.LENGTH_SHORT).show();
        }
        //endregion
        updateScore();
        activateCountdownTimer();



    }
}
