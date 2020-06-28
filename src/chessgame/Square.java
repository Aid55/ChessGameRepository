/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author atbat
 */
public class Square extends JButton{
    private int x;
    private int y;
    private Piece pieceOnSquare;
    
    public Square(int x, int y){
        super(String.valueOf(x) + ", " + String.valueOf(y));
//        super();
        this.x = x;
        this.y = y;
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)){
            this.setColour(Color.GRAY);
        }
        else{
            this.setColour(Color.WHITE);
        }
        this.setOpaque(true);
    }

    public Color getColour() {
        return this.getBackground();
    }

    public void setColour(Color colour) {
        this.setBackground(colour);
    }
    
    public int getXLoc() {
        return x;
    }

    public void setXLoc(int x) {
        this.x = x;
    }

    public int getYLoc() {
        return y;
    }

    public void setYLoc(int y) {
        this.y = y;
    }
    
    public Piece getPieceOnSquare() {
        return pieceOnSquare;
    }

    public void setPieceOnSquare(Piece pieceOnSquare) {
        this.pieceOnSquare = pieceOnSquare;
        pieceOnSquare.setSquare(this);
        this.setIcon(this.pieceOnSquare.getPieceImage());
    }
    
    @Override
    public String toString() {
        return "Square{" + "x=" + x + ", y=" + y + '}';
    }
    
    
    
}
