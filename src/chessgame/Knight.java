/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author atbat
 */
public class Knight extends Piece{
    
    public static String whiteImg = "images/WhiteKnight.png";
    public static String blackImg = "images/BlackKnight.png";
    private ArrayList<Square> possibleMoves = new ArrayList<>();
        
    public Knight(Player player){
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
        // 1 up 2 left
        if (sq.getXLoc() - 2 >= 0 && sq.getYLoc() - 1 >= 0){
            sqToCheck = squares[sq.getXLoc() - 2][sq.getYLoc() - 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                possibleMoves.add(sqToCheck);
            }
        }
        // 1 up 2 right
        if (sq.getXLoc() + 2 < Board.boardWidth && sq.getYLoc() - 1 >= 0){ 
            sqToCheck = squares[sq.getXLoc() + 2][sq.getYLoc() - 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                possibleMoves.add(sqToCheck);
            }
        }
        // 2 up 1 left
        
        if (sq.getXLoc() - 1 >= 0 && sq.getYLoc() - 2 >= 0){
            sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() - 2];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                possibleMoves.add(sqToCheck);
            }
            
        }
        // 2 up 1 right
        
        if (sq.getXLoc() + 1 < Board.boardWidth && sq.getYLoc() - 2 >= 0){
            sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() - 2];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                possibleMoves.add(sqToCheck);
            }
        }
        // 1 down 2 left
        
        if (sq.getXLoc() - 2 >= 0 && sq.getYLoc() + 1 < Board.boardHeight){
            sqToCheck = squares[sq.getXLoc() - 2][sq.getYLoc() + 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                possibleMoves.add(sqToCheck);
            }
        }
        // 1 down 2 right
        
        if (sq.getXLoc() + 2 < Board.boardWidth && sq.getYLoc() + 1 < Board.boardHeight){
            sqToCheck = squares[sq.getXLoc() + 2][sq.getYLoc() + 1];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                possibleMoves.add(sqToCheck);
            }
        }
        // 2 down 1 left
        
        if (sq.getXLoc() - 1 >= 0 && sq.getYLoc() + 2 < Board.boardHeight){
            sqToCheck = squares[sq.getXLoc() - 1][sq.getYLoc() + 2];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                possibleMoves.add(sqToCheck);
            }
        }
        // 2 down 1 right
        
        if (sq.getXLoc() + 1 < Board.boardWidth && sq.getYLoc() + 2 < Board.boardHeight){
            sqToCheck = squares[sq.getXLoc() + 1][sq.getYLoc() + 2];
            if(sqToCheck.getPieceOnSquare() == null || sqToCheck.getPieceOnSquare().getPlayer() != sq.getPieceOnSquare().getPlayer()){
                possibleMoves.add(sqToCheck);
            }
        }
        
        return this.getPossibleMoves();
    }
    
    public ArrayList<Square> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(ArrayList<Square> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }
    
}
