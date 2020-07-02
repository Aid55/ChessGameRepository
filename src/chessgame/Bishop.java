/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author atbat
 */
public class Bishop extends Piece{
    
    public static String whiteImg = "images/WhiteBishop.png";
    public static String blackImg = "images/BlackBishop.png";
    private ArrayList<Square> possibleMoves = new ArrayList<>();
        
    public Bishop(Player player){
        super(player);
        this.loadImage(player);
    }

    private void loadImage(Player player) {
        if (player.getPieceColour() == "White"){
            try {
                Image img = ImageIO.read(getClass().getResourceAsStream(
                        whiteImg));
                this.setPieceImage(new ImageIcon(img));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (player.getPieceColour() == "Black"){
            try {
                Image img = ImageIO.read(getClass().getResourceAsStream(
                        blackImg));
                this.setPieceImage(new ImageIcon(img));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Square> findPossibleMoves(Square[][] squares) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Square sq = this.getSquare();
        this.getPossibleMoves().clear();
        Square sqToCheck = null;
        int tempY;
        //down and right diagonal
        tempY = sq.getYLoc();
        for (int x = sq.getXLoc() + 1; x < Board.boardWidth; x++){
            if (tempY + 1 < Board.boardHeight){
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
            if (tempY + 1 < Board.boardHeight){
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
        for (int x = sq.getXLoc() + 1; x < Board.boardWidth; x++){
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
                possibleMoves.add(sq);
                return false;
            }
            
        }
        else{
            possibleMoves.add(sq);
            return true;
        }
    }
    
    public ArrayList<Square> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(ArrayList<Square> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }
}
