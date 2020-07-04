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
public class Queen extends Piece{
        
    /**
     *
     * @param player
     */
    public Queen(Player player){
        super(player);
        super.setWhiteImg("images/WhiteQueen.png");
        super.setBlackImg("images/BlackQueen.png");
        this.loadImage(player);
    }

    /**
     *
     * @param squares
     * @return
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

    /**
     *
     */
    public void moveMade(){
        
    }
    
}
