/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.util.ArrayList;

/**
 * A class to represent a Pawn in chess
 */
public class Pawn extends Piece{
    
    private boolean firstMove = true;
    private boolean enPassable = false;
        
    /**
     * Creates a Pawn object for a Player
     * @param player Player object
     */
    public Pawn(Player player){
        super(player);
        super.setWhiteImg("images/WhitePawn.png");
        super.setBlackImg("images/BlackPawn.png");
        super.loadImage(player);
    }
    
    /**
     * Finds, checks and returns the possible moves for this object
     * @param squares A 2D array of Square objects
     * @return ArrayList of Square objects
     */
    @Override
    public ArrayList<Square> findPossibleMoves(Square[][] squares) {
        Square sq = this.getSquare();
        this.getPossibleMoves().clear();
        Square sqToCheck = null;
        if (this.getPlayer().getPieceColour().equals("White")){
            // check for single square move up
            if (sq.getYLoc() - 1 >= 0 && squares[sq.getXLoc()][sq.getYLoc() - 1].getPieceOnSquare() == null){
                sqToCheck = squares[sq.getXLoc()][sq.getYLoc() - 1];
                this.getPossibleMoves().add(sqToCheck);
            }
            // check for double square move up
            if (sq.getYLoc() - 2 >= 0 && squares[sq.getXLoc()][sq.getYLoc() - 1].getPieceOnSquare() == null 
                    && squares[sq.getXLoc()][sq.getYLoc() - 2].getPieceOnSquare() == null
                    && this.isFirstMove() == true){
                sqToCheck = squares[sq.getXLoc()][sq.getYLoc() - 2];
                this.getPossibleMoves().add(sqToCheck);
            }
            // check for left diagonal capture and left enPassable Pawn
            if (sq.getYLoc() - 1 >= 0 && sq.getXLoc() - 1 >= 0){
                sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() - 1];
                if (this.checkCapture(sqToCheck)){
                    this.getPossibleMoves().add(sqToCheck);
                }
                sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc()];
                if (this.checkEnPassableCapture(sqToCheck)){
                    this.getPossibleMoves().add(squares[sq.getXLoc() - 1][sq.getYLoc() - 1]);
                }
            }
            // check for right diagonal capture and right enPassable Pawn
            if (sq.getYLoc() - 1 >= 0 && sq.getXLoc() + 1 < Board.BOARDWIDTH){
                sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() - 1];
                if (this.checkCapture(sqToCheck)){
                    this.getPossibleMoves().add(sqToCheck);
                }
                sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc()];
                if (this.checkEnPassableCapture(sqToCheck)){
                    this.getPossibleMoves().add(squares[sq.getXLoc() + 1][sq.getYLoc() - 1]);
                }
            }
        }
        else if (this.getPlayer().getPieceColour().equals("Black")){
            // check for single square move down
            if (sq.getYLoc() + 1 < Board.BOARDHEIGHT && squares[sq.getXLoc()][sq.getYLoc() + 1].getPieceOnSquare() == null){
                sqToCheck = squares[sq.getXLoc()][sq.getYLoc() + 1];
                this.getPossibleMoves().add(sqToCheck);
            }
            // check for double square move down
            if (sq.getYLoc() + 2 < Board.BOARDHEIGHT && squares[sq.getXLoc()][sq.getYLoc() + 1].getPieceOnSquare() == null 
                    && squares[sq.getXLoc()][sq.getYLoc() + 2].getPieceOnSquare() == null
                    && this.isFirstMove() == true){
                sqToCheck = squares[sq.getXLoc()][sq.getYLoc() + 2];
                this.getPossibleMoves().add(sqToCheck);
            }
            // check for left diagonal capture and left enPassable Pawn
            if (sq.getYLoc() + 1 < Board.BOARDHEIGHT && sq.getXLoc() - 1 >= 0){
                sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() + 1];
                if (this.checkCapture(sqToCheck)){
                    this.getPossibleMoves().add(sqToCheck);
                }
                sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc()];
                if (this.checkEnPassableCapture(sqToCheck)){
                    this.getPossibleMoves().add(squares[sq.getXLoc() - 1][sq.getYLoc() + 1]);
                }
            }
            // check for right diagonal capture and right enPassable Pawn
            if (sq.getYLoc() + 1 < Board.BOARDHEIGHT && sq.getXLoc() + 1 < Board.BOARDWIDTH){
                sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() + 1];
                if (this.checkCapture(sqToCheck)){
                    this.getPossibleMoves().add(sqToCheck);
                }
                sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc()];
                if (this.checkEnPassableCapture(sqToCheck)){
                    this.getPossibleMoves().add(squares[sq.getXLoc() + 1][sq.getYLoc() + 1]);
                }
            }
        }
//        this.setFirstMove(false);//to be moved to makeMove method when created
        return this.getPossibleMoves();
    }
    
    private boolean checkCapture(Square sq){
        if(sq.getPieceOnSquare() == null){
            return false;
        }
        else if(sq.getPieceOnSquare().getPlayer() == this.getPlayer()){
            return false;
        }
        else{
            return true;
        }
    }
    
    private boolean checkEnPassableCapture(Square sq){
        if(sq.getPieceOnSquare() == null){
            return false;
        }
        else if(sq.getPieceOnSquare().getPlayer() == this.getPlayer()){
            return false;
        }
        else{
            if(sq.getPieceOnSquare() instanceof Pawn){
                Pawn tempPawn = (Pawn)sq.getPieceOnSquare();
                if (tempPawn.isEnPassable()){
                    return true;
                }
                else{
                   return false;
                }
            }
            return true;
        }
    }
    
    /**
     * Sets the firstMove variable to false when this is moved.
     */
    @Override
    public void moveMade(Piece movedPiece){
        if(movedPiece != this){
            if(this.isEnPassable()){
                this.setEnPassable(false);
            }
        }
    }
    
    public void checkFirstMove(){
        if(this.isFirstMove()){
            if(this.getSquare().getYLoc() == 3 || this.getSquare().getYLoc() == 4){
                this.setEnPassable(true);
            }
            this.setFirstMove(false);
        }
    }
    
    /**
     * Returns the firstMove variable for this object
     * @return firstMove boolean value
     */
    public boolean isFirstMove() {
        return firstMove;
    }

    /**
     * Sets the firstMove variable for this object
     * @param firstMove boolean value
     */
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public boolean isEnPassable() {
        return enPassable;
    }

    public void setEnPassable(boolean enPassable) {
        this.enPassable = enPassable;
    }
    
        
}
