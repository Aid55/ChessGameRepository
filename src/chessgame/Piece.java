/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import javax.swing.ImageIcon;

/**
 *
 * @author atbat
 */
public abstract class Piece {
    
    public static String whiteImg;
    public static String blackImg;
    private Player player;

    private ImageIcon pieceImage;
    
    public Piece(Player player){ //add ImageIcon and player arguments
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
    
}
