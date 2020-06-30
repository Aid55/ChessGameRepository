/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author atbat
 */
public class Game implements ActionListener {
    
    private Board board;
    private Square[][] squares;
    private Player white;
    private Player black;
    private boolean gameOver = false;
    private Square selectedSquare;
    private Square previousSquare;
    private Player currentMove;
    
    public Game(Board board, Square[][] squares, Player white, Player black){
        this.board = board;
        this.squares = squares;
        this.white = white;
        this.black = black;
        this.addActionListeners();
        this.startGame();
    }
    
    private void addActionListeners(){
        for (int y=0; y< this.getBoard().getBoardHeight(); y++){
            for (int x=0; x<this.getBoard().getBoardWidth(); x++){
                this.getSquares()[x][y].addActionListener(this);
            }
        }
    }
    
    public void actionPerformed(ActionEvent anEvent){
        this.setPreviousSquare(this.getSelectedSquare());
        this.setSelectedSquare((Square) anEvent.getSource());
        if (this.getSelectedSquare().getPieceOnSquare() != null && this.getSelectedSquare().getPieceOnSquare().getPlayer() == this.currentMove){
            this.getPossibleMoves();
        }
        
    }
    
    private void getPossibleMoves(){
        this.getBoard().showPossibleMoves(this.getSelectedSquare().getPieceOnSquare().findPossibleMoves(this.getSquares()));
        this.getBoard().setSelectedSquareColour(this.getSelectedSquare());
    }
            

    private void startGame(){
        this.currentMove = this.black;
//        while (gameOver != true){
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }
//            catch (Exception e){
//                
//            }
//            if (this.currentMove == this.white){
//                this.white.makeMove();
//                
//            }
//            else if (this.currentMove == this.black){
//                this.black.makeMove();
//            }
//        }
    }
    
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Square getPreviousSquare() {
        return previousSquare;
    }

    public void setPreviousSquare(Square previousSquare) {
        this.previousSquare = previousSquare;
    }

    public Square getSelectedSquare() {
        return selectedSquare;
    }

    public void setSelectedSquare(Square selectedSquare) {
        this.selectedSquare = selectedSquare;
    }
    
}
