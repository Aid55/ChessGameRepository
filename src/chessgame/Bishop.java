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
public class Bishop extends Piece{
        
    public Bishop(Player player){
        super(player);
        super.setWhiteImg("images/WhiteBishop.png");
        super.setBlackImg("images/BlackBishop.png");
        this.loadImage(player);
    }

    @Override
    public ArrayList<Square> findPossibleMoves(Square[][] squares) {
        Square sq = this.getSquare();
        this.getPossibleMoves().clear();
        Square sqToCheck = null;
        int tempY;
        //down and right diagonal
        tempY = sq.getYLoc();
        for (int x = sq.getXLoc() + 1; x < Board.BOARDWIDTH; x++){
            if (tempY + 1 < Board.BOARDHEIGHT){
                tempY++;
                sqToCheck = squares[x][tempY];
                if(!this.checkSquare(sqToCheck)){
                    break;
                }
            }
            else{
                break;
            }
        }
        //down and left diagonal
        tempY = sq.getYLoc();
        for (int x = sq.getXLoc() - 1; x >= 0; x--){
            if (tempY + 1 < Board.BOARDHEIGHT){
                tempY++;
                sqToCheck = squares[x][tempY];
                if(!this.checkSquare(sqToCheck)){
                    break;
                }
            }
            else{
                break;
            }
        }
        //up and left diagonal
        tempY = sq.getYLoc();
        for (int x = sq.getXLoc() - 1; x >= 0; x--){
            if (tempY - 1 >= 0){
                tempY--;
                sqToCheck = squares[x][tempY];
                if(!this.checkSquare(sqToCheck)){
                    break;
                }                
            }
            else{
                break;
            }
        }
        //up and right diagonal
        tempY = sq.getYLoc();
        for (int x = sq.getXLoc() + 1; x < Board.BOARDWIDTH; x++){
            if (tempY - 1 >= 0){
                tempY--;
                sqToCheck = squares[x][tempY];
                if(!this.checkSquare(sqToCheck)){
                    break;
                }
            }
            else{
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

}
