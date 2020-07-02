/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.util.ArrayList;

/**
 *
 * @author atbat
 */
public class Pawn extends Piece{
    
    private boolean firstMove = true;
        
    public Pawn(Player player){
        super(player);
        super.setWhiteImg("images/WhitePawn.png");
        super.setBlackImg("images/BlackPawn.png");
        super.loadImage(player);
    }
    
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
            // check for left diagonal capture
            if (sq.getYLoc() - 1 >= 0 && sq.getXLoc() - 1 >= 0){
                sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() - 1];
                if (this.checkCapture(sqToCheck)){
                    this.getPossibleMoves().add(sqToCheck);
                }
            }
            // check for right diagonal capture
            if (sq.getYLoc() - 1 >= 0 && sq.getXLoc() + 1 < Board.BOARDWIDTH && squares[sq.getXLoc() + 1][sq.getYLoc() - 1].getPieceOnSquare() != null){
                sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() - 1];
                if (this.checkCapture(sqToCheck)){
                    this.getPossibleMoves().add(sqToCheck);
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
            // check for left diagonal capture
            if (sq.getYLoc() + 1 < Board.BOARDHEIGHT && sq.getXLoc() - 1 >= 0 && squares[sq.getXLoc() - 1][sq.getYLoc() + 1].getPieceOnSquare() != null){
                sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() + 1];
                if (this.checkCapture(sqToCheck)){
                    this.getPossibleMoves().add(sqToCheck);
                }
            }
            // check for right diagonal capture
            if (sq.getYLoc() + 1 < Board.BOARDHEIGHT && sq.getXLoc() + 1 < Board.BOARDWIDTH && squares[sq.getXLoc() + 1][sq.getYLoc() + 1].getPieceOnSquare() != null){
                sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() + 1];
                if (this.checkCapture(sqToCheck)){
                    this.getPossibleMoves().add(sqToCheck);
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

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
        
}
