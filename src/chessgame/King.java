/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.util.ArrayList;

/**
 * A class to represent a King in chess
 */
public class King extends Piece{
        
    /**
     * Creates a Piece object for a Player
     * @param player Player object
     */
    public King(Player player){
        super(player);
        super.setWhiteImg("images/WhiteKing.png");
        super.setBlackImg("images/BlackKing.png");
        this.loadImage(player);
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
        // 1 up 1 left
        if (sq.getXLoc() - 1 >= 0 && sq.getYLoc() - 1 >= 0){
            sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() - 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 up 1 right
        if (sq.getXLoc() + 1 < Board.BOARDWIDTH && sq.getYLoc() - 1 >= 0){ 
            sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() - 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 up        
        if (sq.getYLoc() - 1 >= 0){
            sqToCheck = squares[sq.getXLoc()][sq.getYLoc() - 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 right
        if (sq.getXLoc() + 1 < Board.BOARDWIDTH){
            sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc()];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 left
        if (sq.getXLoc() - 1 >= 0){
            sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc()];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 down 1 right
        if (sq.getXLoc() + 1 < Board.BOARDWIDTH && sq.getYLoc() + 1 < Board.BOARDHEIGHT){
            sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() + 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 down 1 left
        if (sq.getXLoc() - 1 >= 0 && sq.getYLoc() + 1 < Board.BOARDHEIGHT){
            sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() + 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 down
        if (sq.getYLoc() + 1 < Board.BOARDHEIGHT){
            sqToCheck = squares[sq.getXLoc()][sq.getYLoc() + 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        return this.getPossibleMoves();
    }

    /**
     *
     */
    public void moveMade(){
        
    }
    
}
