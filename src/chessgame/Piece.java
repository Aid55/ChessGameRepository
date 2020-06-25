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
    private int xLoc;
    private int yLoc;
    private ImageIcon pieceImage;
    
    public Piece(int x, int y){ //add ImageIcon and player arguments
        this.xLoc = x;
        this.yLoc = y;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public ImageIcon getPieceImage() {
        return pieceImage;
    }

    public void setPieceImage(ImageIcon pieceImage) {
        this.pieceImage = pieceImage;
    }
    
}
