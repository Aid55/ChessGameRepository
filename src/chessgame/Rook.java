/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.util.ArrayList;

/**
 * A class to represent a Rook in chess
 */
public class Rook extends Piece{
        
    /**
     * Creates a Rook object for a Player
     * @param player Player object
     */
    public Rook(Player player){
        super(player);
        super.setWhiteImg("images/WhiteRook.png");
        super.setBlackImg("images/BlackRook.png");
        this.loadImage(player);
    }

    /**
     * Finds and returns the possible moves for this object
     * Checks each possible move to see if it is valid.
     * @param squares A 2D array of Square objects
     * @return ArrayList of Square objects
     */
    @Override
    public ArrayList<Square> findPossibleMoves(Square[][] squares) {
        Square sq = this.getSquare();
        this.getPossibleMoves().clear();
        Square sqToCheck = null;
        for(int y = sq.getYLoc() + 1; y < Board.BOARDHEIGHT; y++){
            sqToCheck = squares[sq.getXLoc()][y];
            if(!this.checkSquare(sqToCheck)){
                break;
            }
        }
        for(int y = sq.getYLoc() - 1; y >= 0; y--){
            sqToCheck = squares[sq.getXLoc()][y];
            if(!this.checkSquare(sqToCheck)){
                break;
            }
        }
        for(int x = sq.getXLoc() + 1; x < Board.BOARDWIDTH; x++){
            sqToCheck = squares[x][sq.getYLoc()];
            if(!this.checkSquare(sqToCheck)){
                break;
            }
        }
        for(int x = sq.getXLoc() - 1; x >= 0; x--){
            sqToCheck = squares[x][sq.getYLoc()];
            if(!this.checkSquare(sqToCheck)){
                break;
            }
        }
        
        return this.getPossibleMoves();
    }
    
    private boolean checkSquare(Square sq){
        if (sq.getPieceOnSquare() != null){
            if (sq.getPieceOnSquare().getPlayer() == this.getPlayer()){
                return false;
            }
            else{
                this.getPossibleMoves().add(sq);
                return false;
            }
            
        }
        else{
            this.getPossibleMoves().add(sq);
            return true;
        }
    }

    /**
     * 
     */
    public void moveMade(Piece movedPiece){
        
    }
    
}
