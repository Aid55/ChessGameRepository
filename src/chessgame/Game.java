/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

/**
 *
 * @author atbat
 */
public class Game {
    
    private Board board;
    private Player white;
    private Player black;
    private boolean gameOver = false;
    
    public Game(Board board, Player white, Player black){
        this.board = board;
        this.white = white;
        this.black = black;
        this.startGame();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    private void startGame(){
//        while (gameOver != true){
//        }
    }
    
}
