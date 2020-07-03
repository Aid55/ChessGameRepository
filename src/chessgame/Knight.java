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
public class Knight extends Piece{
        
    public Knight(Player player){
        super(player);
        super.setWhiteImg("images/WhiteKnight.png");
        super.setBlackImg("images/BlackKnight.png");
        this.loadImage(player);
    }

    @Override
    public ArrayList<Square> findPossibleMoves(Square[][] squares) {
        Square sq = this.getSquare();
        this.getPossibleMoves().clear();
        Square sqToCheck = null;
        // 1 up 2 left
        if (sq.getXLoc() - 2 >= 0 && sq.getYLoc() - 1 >= 0){
            sqToCheck = squares[sq.getXLoc() - 2][sq.getYLoc() - 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 up 2 right
        if (sq.getXLoc() + 2 < Board.BOARDWIDTH && sq.getYLoc() - 1 >= 0){ 
            sqToCheck = squares[sq.getXLoc() + 2][sq.getYLoc() - 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 2 up 1 left
        if (sq.getXLoc() - 1 >= 0 && sq.getYLoc() - 2 >= 0){
            sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() - 2];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 2 up 1 right
        if (sq.getXLoc() + 1 < Board.BOARDWIDTH && sq.getYLoc() - 2 >= 0){
            sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() - 2];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 down 2 left
        if (sq.getXLoc() - 2 >= 0 && sq.getYLoc() + 1 < Board.BOARDHEIGHT){
            sqToCheck = squares[sq.getXLoc() - 2][sq.getYLoc() + 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 1 down 2 right
        if (sq.getXLoc() + 2 < Board.BOARDWIDTH && sq.getYLoc() + 1 < Board.BOARDHEIGHT){
            sqToCheck = squares[sq.getXLoc() + 2][sq.getYLoc() + 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 2 down 1 left
        if (sq.getXLoc() - 1 >= 0 && sq.getYLoc() + 2 < Board.BOARDHEIGHT){
            sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() + 2];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        // 2 down 1 right
        if (sq.getXLoc() + 1 < Board.BOARDWIDTH && sq.getYLoc() + 2 < Board.BOARDHEIGHT){
            sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() + 2];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                this.getPossibleMoves().add(sqToCheck);
            }
        }
        return this.getPossibleMoves();
    }

    public void moveMade(){
        
    }
    
}
