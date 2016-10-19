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
 * 0 = not picked
 * 1 = picked by player1
 * 2 = picked by player2
 * Created by micha on 10/17/2016.
 */


public class VirtualGameBoard {


    private int[][] gameBoard;

    public VirtualGameBoard(){
        gameBoard=new int[3][3];
    }
    public void updateGameBoard(String code){
        int row = Integer.parseInt(code.substring(0,1));
        int col = Integer.parseInt(code.substring(1,2));
        int player = Integer.parseInt(code.substring(2));
        gameBoard[row][col]=player;
    }

    public boolean detectWin(int player){
        //vertical wins
        if (gameBoard[0][0] == player && gameBoard[1][0] == player && gameBoard[2][0] == player){
            return true;
        }
        if (gameBoard[0][1] == player && gameBoard[1][1]== player && gameBoard[2][1] == player){
            return true;
        }
        if (gameBoard[0][2] == player && gameBoard[1][2]== player && gameBoard[2][2]== player){
            return true;
        }
        //horizontal wins
        if (gameBoard[0][0] == player && gameBoard[0][1]== player&& gameBoard[0][2] == player){
            return true;
        }
        if (gameBoard[1][0] == player && gameBoard[1][1]== player && gameBoard[1][2]== player){
            return true;
        }
        if (gameBoard[2][0]== player && gameBoard[2][1]== player && gameBoard[2][2]== player){
            return true;
        }
        //diagnoal wins
        if (gameBoard[0][0]== player && gameBoard[1][1]== player && gameBoard[2][2]== player){
            return true;
        }
        if (gameBoard[0][2] == player && gameBoard[1][1]== player && gameBoard[2][0]== player){
            return true;
        }
        return false;
    }
    public boolean detectDraw(){
        if ( (gameBoard[0][0]==1 || gameBoard[0][0]==2) && (gameBoard[0][1] == 1 || gameBoard[0][1] == 2) && (gameBoard[0][2]==1 || gameBoard[0][2] == 2) &&
                (gameBoard[1][0] == 1 || gameBoard[1][0]==2) && (gameBoard[1][1]==1 || gameBoard[1][1] == 2) && (gameBoard[1][2]== 1 ||gameBoard[1][2] == 2)&&
                (gameBoard[2][0] == 1 || gameBoard[2][0] == 2) && (gameBoard[2][1] == 1 || gameBoard[2][1] == 2) && (gameBoard[2][2] == 1 || gameBoard[2][2] == 2)){
            return true;
        }
        else{
            return false;
        }
    }
}
