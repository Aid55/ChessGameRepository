/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

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
        for (int y=0; y < Board.BOARDHEIGHT; y++){
            for (int x=0; x < Board.BOARDWIDTH; x++){
                this.squares[x][y].addActionListener(this);
            }
        }
    }
    
    public void actionPerformed(ActionEvent anEvent){
        Object source = anEvent.getSource();
        Square newSq = null;
        for (int y=0; y < Board.BOARDHEIGHT; y++){
            for (int x=0; x < Board.BOARDWIDTH; x++){
                if (source == this.squares[x][y]){
                    newSq = this.squares[x][y];
                }
            }
        }
        if (newSq != null){ //if new Square was found in the 2D array
            this.setPreviousSquare(this.getSelectedSquare());
            this.setSelectedSquare(newSq);
            if (this.getPreviousSquare() == null){
                this.setPreviousSquare(this.getSelectedSquare());
            }
            if (this.getSelectedSquare() == this.getPreviousSquare()){
                if(this.getSelectedSquare().getPieceOnSquare() == null){
                    //do nothing
                }
                else if(this.getSelectedSquare().getPieceOnSquare().getPlayer() == this.currentMove){
                    this.showPossibleMoves(this.getSelectedSquare());
                }
                else if(this.getSelectedSquare().getPieceOnSquare().getPlayer() != this.currentMove){
                    //do nothing
                }
            }
            
            else if(this.getSelectedSquare() != this.getPreviousSquare()){
                if(this.getPreviousSquare().getPieceOnSquare() == null){
                    if(this.getSelectedSquare().getPieceOnSquare() == null){
                        //do nothing
                    }
                    else if(this.getSelectedSquare().getPieceOnSquare().getPlayer() == this.currentMove){
                        this.showPossibleMoves(this.getSelectedSquare());
                    }
                    else if(this.getSelectedSquare().getPieceOnSquare().getPlayer() != this.currentMove){
                        //do nothing
                    }
                }
                else if(this.getPreviousSquare().getPieceOnSquare().getPlayer() == this.currentMove){
                    if(this.getSelectedSquare().getPieceOnSquare() == null){
                        if(this.getPreviousSquare().getPieceOnSquare().getPossibleMoves().contains(this.getSelectedSquare())){
                            this.makeMove();
                        }
                        else{
                            this.getBoard().recolourBoardSquares();
                        }
                    }
                    else if(this.getSelectedSquare().getPieceOnSquare().getPlayer() == this.currentMove){
                        this.showPossibleMoves(this.getSelectedSquare());
                    }
                    else if(this.getSelectedSquare().getPieceOnSquare().getPlayer() != this.currentMove){
                        if(this.getPreviousSquare().getPieceOnSquare().getPossibleMoves().contains(this.getSelectedSquare())){
                            this.makeMove();
                        }
                        else{
                            this.getBoard().recolourBoardSquares();
                        }
                    }
                }
                else if(this.getPreviousSquare().getPieceOnSquare().getPlayer() != this.currentMove){
                    if(this.getSelectedSquare().getPieceOnSquare() == null){
                        //do nothing
                    }
                    else if(this.getSelectedSquare().getPieceOnSquare().getPlayer() == this.currentMove){
                        this.getBoard().recolourBoardSquares();
                        this.showPossibleMoves(this.getSelectedSquare());
                    }
                    else if(this.getSelectedSquare().getPieceOnSquare().getPlayer() != this.currentMove){
                        //do nothing
                    }
                }
                
            }
            
        }
    }
    
    private void showPossibleMoves(Square sq){
        this.getBoard().displayPossibleMoves(sq.getPieceOnSquare().findPossibleMoves(this.getSquares()));
        this.getBoard().setSelectedSquareColour(sq);
    }
    
    private void makeMove(){
        this.getSquares()[this.getSelectedSquare().getXLoc()][this.getSelectedSquare().getYLoc()].setPieceOnSquare(this.getPreviousSquare().getPieceOnSquare());
        this.getSquares()[this.getPreviousSquare().getXLoc()][this.getPreviousSquare().getYLoc()].removePieceOnSquare();
        this.getBoard().recolourBoardSquares();
        this.getSelectedSquare().getPieceOnSquare().moveMade();
        this.changeMove();
    }            

    private void startGame(){
        this.currentMove = this.white;
//        while (gameOver != true){
//            try{
//                TimeUnit.SECONDS.sleep(10);
//            }
//            catch (Exception e){
//                
//            }
//            if (this.currentMove == this.white){
//                this.currentMove = this.black;
//                System.out.println("blacks move");
//                
//            }
//            else if (this.currentMove == this.black){
//                this.currentMove = this.white;
//                System.out.println("whites move");
//            }
//        }
    }
    
    private void changeMove(){
        if (this.getCurrentMove() == this.white){
            this.setCurrentMove(this.black);
        }
        else{
            this.setCurrentMove(this.white);
        }
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

    public Player getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(Player currentMove) {
        this.currentMove = currentMove;
    }
    
    
    
}
