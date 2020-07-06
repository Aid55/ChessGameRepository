/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * A class representing a game
 */
public class Game implements ActionListener {
    
    private Board board;
    private Square[][] squares;
    private Player white;
    private Player black;
    private Square selectedSquare;
    private Square previousSquare;
    private Player playerTurn;
    private Player otherPlayer;
    
    /**
     * Creates a Game object with a Board object, a 2d Array of Square objects, 
     * and two Player objects
     * @param board Board object
     * @param squares 2D Array of Square objects
     * @param white Player object
     * @param black Player object
     */
    public Game(Board board, Square[][] squares, Player white, Player black){
        this.board = board;
        this.squares = squares;
        this.white = white;
        this.black = black;
        this.playerTurn = white;
        this.otherPlayer = black;
        this.addActionListeners();
//        this.startGame();
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
            //if first click
            if (this.getPreviousSquare() == null){
                this.setPreviousSquare(newSq);
            }
            this.checkSquaresForMoves(this.getPreviousSquare(), this.getSelectedSquare());            
        }
    }
    
    private void checkSquaresForMoves(Square prevSq, Square newSq){
        //if same piece
        if (newSq == prevSq){
            if(newSq.getPieceOnSquare() == null){
                //do nothing
            }
            else if(newSq.getPieceOnSquare().getPlayer() == this.playerTurn){
                this.showPossibleMoves(newSq);
            }
            else if(newSq.getPieceOnSquare().getPlayer() != this.playerTurn){
                //do nothing
            }
        }
        //if not same piece
        else if(newSq != prevSq){
            //if nothing on old square
            if(prevSq.getPieceOnSquare() == null){
                if(newSq.getPieceOnSquare() == null){
                    //do nothing
                }
                else if(newSq.getPieceOnSquare().getPlayer() == this.playerTurn){
                    this.showPossibleMoves(newSq);
                }
                else if(newSq.getPieceOnSquare().getPlayer() != this.playerTurn){
                    //do nothing
                }
            }
            //if same colour piece on old square
            else if(prevSq.getPieceOnSquare().getPlayer() == this.playerTurn){
                if(newSq.getPieceOnSquare() == null){
                    if(prevSq.getPieceOnSquare().getPossibleMoves().contains(newSq)){
                        this.makeMove(this.getPreviousSquare(), this.getSelectedSquare());
                    }
                    else{
                        this.getBoard().recolourBoardSquares();
                    }
                }
                else if(newSq.getPieceOnSquare().getPlayer() == this.playerTurn){
                    this.showPossibleMoves(newSq);
                }
                else if(newSq.getPieceOnSquare().getPlayer() != this.playerTurn){
                    if(prevSq.getPieceOnSquare().getPossibleMoves().contains(newSq)){
                        this.makeMove(this.getPreviousSquare(), this.getSelectedSquare());
                    }
                    else{
                        this.getBoard().recolourBoardSquares();
                    }
                }
            }
            //if other colour piece on old square
            else if(prevSq.getPieceOnSquare().getPlayer() != this.playerTurn){
                if(newSq.getPieceOnSquare() == null){
                    //do nothing
                }
                else if(newSq.getPieceOnSquare().getPlayer() == this.playerTurn){
                    this.showPossibleMoves(newSq);
                }
                else if(newSq.getPieceOnSquare().getPlayer() != this.playerTurn){
                    //do nothing
                }
            }
        }
    }
    
    private void showPossibleMoves(Square sq){
        this.getBoard().displayPossibleMoves(sq.getPieceOnSquare().findPossibleMoves(this.getSquares()));
        this.getBoard().setSelectedSquareColour(sq);
    }
    
    private void makeMove(Square prevSq, Square newSq){
        this.getSquares()[newSq.getXLoc()][newSq.getYLoc()].setPieceOnSquare(prevSq.getPieceOnSquare());
        this.getSquares()[prevSq.getXLoc()][prevSq.getYLoc()].removePieceOnSquare();
        this.getBoard().recolourBoardSquares();
        //If Pawn, check for double square first moved and enPassant capture
        if (newSq.getPieceOnSquare() instanceof Pawn){
            Pawn tempPawn = (Pawn)newSq.getPieceOnSquare();
            if (tempPawn.isFirstMove()){
                tempPawn.checkFirstMove();
            }
            this.enPassantCheck(tempPawn, newSq, prevSq);
            this.changePlayerTurn();
        }
        //Trigger logic for each piece on board after each move
        for(Piece p : this.white.getPieces()){
            p.moveMade(this.getSelectedSquare().getPieceOnSquare());
        }
        for(Piece p : this.black.getPieces()){
            p.moveMade(this.getSelectedSquare().getPieceOnSquare());
        }
    }
    
    private void enPassantCheck(Pawn tempPawn, Square newSq, Square prevSq){
        try{
            Square sqToCheck = squares[prevSq.getXLoc() - 1][prevSq.getYLoc()];
            if (sqToCheck.getPieceOnSquare() instanceof Pawn && sqToCheck.getPieceOnSquare().getPlayer() != newSq.getPieceOnSquare().getPlayer()){
                tempPawn = (Pawn)sqToCheck.getPieceOnSquare();
                if(tempPawn.isEnPassable()){
                    sqToCheck.removePieceOnSquare();
                }
            }
        }
        catch(Exception e){
            System.out.println("sqToCheck outside of boardWith boundary");
        }
        try{
            Square sqToCheck = squares[prevSq.getXLoc() + 1][prevSq.getYLoc()];
            if (sqToCheck.getPieceOnSquare() instanceof Pawn && sqToCheck.getPieceOnSquare().getPlayer() != newSq.getPieceOnSquare().getPlayer()){
                tempPawn = (Pawn)sqToCheck.getPieceOnSquare();
                if(tempPawn.isEnPassable()){
                    sqToCheck.removePieceOnSquare();
                }
            } 
        }
        catch(Exception e){
            System.out.println("sqToCheck outside of boardWith boundary");
        }     
    }    

    private void startGame(){
//        this.playerTurn = this.white;
//        while (gameOver != true){
//            try{
//                TimeUnit.SECONDS.sleep(10);
//            }
//            catch (Exception e){
//                
//            }
//            if (this.playerTurn == this.white){
//                this.playerTurn = this.black;
//                System.out.println("blacks move");
//                
//            }
//            else if (this.playerTurn == this.black){
//                this.playerTurn = this.white;
//                System.out.println("whites move");
//            }
//        }
    }
    
    private void changePlayerTurn(){
        if (this.getPlayerTurn() == this.white){
            this.setPlayerTurn(this.black);
            this.setOtherPlayer(this.white);
        }
        else{
            this.setPlayerTurn(this.white);
            this.setOtherPlayer(this.black);
        }
    }
    
    /**
     * Returns the board variable of this object
     * @return board Board object
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Sets the board variable of this object
     * @param board Board object
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Returns the squares variable of this object
     * @return squares 2D Array of Square objects
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Sets the squares variable of this object
     * @param squares 2D Array of Square objects
     */
    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * Returns the previousSquare variable of this object
     * @return previousSquare Square object
     */
    public Square getPreviousSquare() {
        return previousSquare;
    }

    /**
     * Sets the previousSquare variable of this object
     * @param previousSquare Square object
     */
    public void setPreviousSquare(Square previousSquare) {
        this.previousSquare = previousSquare;
    }

    /**
     * Returns the selectedSquare variable of this object
     * @return selectedSquare Square object
     */
    public Square getSelectedSquare() {
        return selectedSquare;
    }

    /**
     * Sets the selectedSquare variable of this object
     * @param selectedSquare Square object
     */
    public void setSelectedSquare(Square selectedSquare) {
        this.selectedSquare = selectedSquare;
    }

    /**
     * Returns the playerTurn variable of this object
     * @return playerTurn Player object
     */
    public Player getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Sets the playerTurn variable of this object
     * @param playerTurn Player object
     */
    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }
    
}
