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
    private boolean gameOver = false;
    private Square selectedSquare;
    private Square previousSquare;
    private Player currentMove;
    private boolean pieceSelected = false;
    
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
                this.squares[x][y].addActionListener(this);
            }
        }
    }
    
    public void actionPerformed(ActionEvent anEvent){
        Object source = anEvent.getSource();
        Square newSq = null;
        for (int y=0; y< this.getBoard().getBoardHeight(); y++){
            for (int x=0; x<this.getBoard().getBoardWidth(); x++){
                if (source == this.squares[x][y]){
                    newSq = this.squares[x][y];
                }
            }
        }
        if (newSq != null){ //if new Square was found in the 2D array
            this.setPreviousSquare(this.getSelectedSquare());
            this.setSelectedSquare(newSq);
            //if new square has a piece on it
            if (this.getSelectedSquare().getPieceOnSquare() != null){ 
                System.out.println("" + this.getPreviousSquare() + ", " + this.getSelectedSquare());
                //if new square is a piece of the same colour as the player who's turn it is AND the new square is different to the old square
                if (this.getSelectedSquare().getPieceOnSquare().getPlayer() == this.getCurrentMove() 
                        && this.getPreviousSquare() != this.getSelectedSquare()){ 
                    //if there's no piece currently selected
                    if (!pieceSelected){
                        this.pieceSelected = true;
                        this.showPossibleMoves();
                    }
                    //if a piece is currently selected (of the same colour)
                    else if (pieceSelected){
                        this.showPossibleMoves();
                    }
                }
               
                // if selected sq is a new square that has a piece which is NOT the same colour as the player who's turn it is
                if (this.getSelectedSquare().getPieceOnSquare().getPlayer() != this.getCurrentMove() 
                        && this.getPreviousSquare() != this.getSelectedSquare()){
                    this.pieceSelected = false;
                    //no previous square (likely first square clicked)
                    if(this.getPreviousSquare() == null){
                        System.out.println("No previous square selected");
                    }
                    //if prev piece is same colour as the player who's turn it is
                    else if (this.getPreviousSquare().getPieceOnSquare().getPlayer() == this.getCurrentMove()){
                        if(this.getPreviousSquare().getPieceOnSquare().getPossibleMoves().contains(this.getSelectedSquare())){
                            System.out.println("This is a capture");
                            this.getSquares()[this.getSelectedSquare().getXLoc()][this.getSelectedSquare().getYLoc()].setPieceOnSquare(this.getPreviousSquare().getPieceOnSquare());
                            this.getSquares()[this.getPreviousSquare().getXLoc()][this.getPreviousSquare().getYLoc()].removePieceOnSquare();
                            this.setPreviousSquare(null);
                            this.getBoard().recolourBoard();
                            this.changeMove();
                        }
                    }
                }
                
                
            }
            //if there isn't a piece on the square and a piece was on the previous square
            else if(this.getSelectedSquare().getPieceOnSquare() == null && pieceSelected){
                System.out.println("This Square has no Piece"); 
                this.pieceSelected = false;
                //if new empty square is a possbile move for the previous piece, move there
                if (this.getPreviousSquare().getPieceOnSquare().getPossibleMoves().contains(this.getSelectedSquare())){
                    System.out.println("This is a possible move");
                    this.getSquares()[this.getSelectedSquare().getXLoc()][this.getSelectedSquare().getYLoc()].setPieceOnSquare(this.getPreviousSquare().getPieceOnSquare());
                    this.getSquares()[this.getPreviousSquare().getXLoc()][this.getPreviousSquare().getYLoc()].removePieceOnSquare();
                    this.setPreviousSquare(null);
                    this.getBoard().recolourBoard();
                    this.changeMove();
                }
                //else remove possible moves from board
                else{
                    System.out.println("This is not a possible move");
                    this.getBoard().recolourBoard();
                }
            }

            else{
                System.out.println("No piece on prev or current square");
            }
        }

        else{
            System.out.println("This Square was not found");
        }
    }
    
    private void showPossibleMoves(){
        this.getBoard().displayPossibleMoves(this.getSelectedSquare().getPieceOnSquare().findPossibleMoves(this.getSquares()));
        this.getBoard().setSelectedSquareColour(this.getSelectedSquare());
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
