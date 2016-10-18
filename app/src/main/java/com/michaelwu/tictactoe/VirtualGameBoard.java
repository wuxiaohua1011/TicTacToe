package com.michaelwu.tictactoe;

import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * This class is used to
 * 1) record the entire board
 * 2) import the recorded data into an 2D array to determine win/lose
 * 3) if win, determine which player won, restart the game (w/o restarting the program, preserve users' choice of icon)
 * 4) if no win detected, keep going
 * 5) if result is a draw(no win detected but the board is FULL)
 *
 *
 * KEY to *position*
 * 0 = no background picture found
 * 1 = background picture found
 * Created by micha on 10/17/2016.
 */


public class VirtualGameBoard {


    private int imageButton00,imageButton01,imageButton02,imageButton10,imageButton11,imageButton12,imageButton20,imageButton21,imageButton22;

    public VirtualGameBoard(ImageButton imageButton00, ImageButton imageButton01, ImageButton imageButton02,
                            ImageButton imageButton10, ImageButton imageButton11, ImageButton imageButton12,
                            ImageButton imageButton20, ImageButton imageButton21, ImageButton imageButton22){
        this.imageButton00 = checkImage(imageButton00);
        this.imageButton01 = checkImage(imageButton01);
        this.imageButton02 = checkImage(imageButton02);
        this.imageButton10 = checkImage(imageButton10);
        this.imageButton11 = checkImage(imageButton11);
        this.imageButton12 = checkImage(imageButton12);
        this.imageButton20 = checkImage(imageButton20);
        this.imageButton21 = checkImage(imageButton21);
        this.imageButton22 = checkImage(imageButton22);



    }
    public void checkGameBoard(ImageButton imageButton00, ImageButton imageButton01, ImageButton imageButton02,
                               ImageButton imageButton10, ImageButton imageButton11, ImageButton imageButton12,
                               ImageButton imageButton20, ImageButton imageButton21, ImageButton imageButton22){
        this.imageButton00 = checkImage(imageButton00);
        this.imageButton01 = checkImage(imageButton01);
        this.imageButton02 = checkImage(imageButton02);
        this.imageButton10 = checkImage(imageButton10);
        this.imageButton11 = checkImage(imageButton11);
        this.imageButton12 = checkImage(imageButton12);
        this.imageButton20 = checkImage(imageButton20);
        this.imageButton21 = checkImage(imageButton21);
        this.imageButton22 = checkImage(imageButton22);

    }
    private int checkImage(ImageButton imageButton) {
        if (imageButton.isClickable()){
            return 0; // if isClickable() return true, that means that imageButton has not been clicked, that means no image should display
        }
        else{
            return 1;
        }
    }

    public boolean detectWin(){
        //vertical wins
        if (imageButton00 == 1 && imageButton10 == 1 && imageButton20 == 1){
            return true;
        }
        if (imageButton01 == 1 && imageButton11 == 1 && imageButton21 == 1){
            return true;
        }
        if (imageButton02 == 1 && imageButton12 == 1 && imageButton22 == 1){
            return true;
        }
        //horizontal wins
        if (imageButton00 == 1 && imageButton01 == 1 && imageButton02 == 1){
            return true;
        }
        if (imageButton10 == 1 && imageButton11 == 1 && imageButton12 == 1){
            return true;
        }
        if (imageButton20 == 1 && imageButton21 == 1 && imageButton22 == 1){
            return true;
        }
        //diagnoal wins
        if (imageButton00 == 1 && imageButton11 == 1 && imageButton22 == 1){
            return true;
        }
        if (imageButton02 == 1 && imageButton11 == 1 && imageButton02 == 1){
            return true;
        }
        return false;
    }
    public boolean detectDraw(){
        if (imageButton00==1 &&imageButton01==1 &&imageButton02==1 &&
                imageButton10==1 &&imageButton11==1 &&imageButton12==1 &&
                imageButton20==1 &&imageButton21==1 &&imageButton22==1){
            return true;
        }
        else{
            return false;
        }
    }
}
