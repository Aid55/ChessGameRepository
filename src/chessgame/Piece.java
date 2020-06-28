/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author atbat
 */
public abstract class Piece {
    
    public static String whiteImg;
    public static String blackImg;
    private Player player;
    private Square square;

    private ImageIcon pieceImage;
    
    public Piece(Player player){
        this.player = player;
    }

    public ImageIcon getPieceImage() {
        return pieceImage;
    }

    public void setPieceImage(ImageIcon pieceImage) {
        this.pieceImage = pieceImage;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
    
    public abstract ArrayList<Integer[]> possibleMoves();

    @Override
    public String toString() {
        return "Piece{" + "player=" + player.toString() + ", pieceImage=" + pieceImage.toString() + '}';
    }
    
    
    
}
