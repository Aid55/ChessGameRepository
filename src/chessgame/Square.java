/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import javax.swing.JButton;

/**
 * A Square represents a square on a chessboard
 */
public class Square extends JButton{
    private int xLoc;
    private int yLoc;
    private Piece pieceOnSquare;
    
    /**
     * Creates a Square object with X and Y coordinates
     * @param x X Coordinate
     * @param y Y Coordinate
     */
    public Square(int x, int y){
//        super(String.valueOf(x) + ", " + String.valueOf(y));
        super();
        this.xLoc = x;
        this.yLoc = y;
        super.setOpaque(true);
    }
    
    /**
     * Sets the Square's background colour depending on it's coordinates
     */
    public void initColour(){
        if ((this.getXLoc() % 2 == 0 && this.getYLoc() % 2 == 0) || (this.getXLoc() % 2 == 1 && this.getYLoc() % 2 == 1)){
            super.setBackground(Color.GRAY);
        }
        else{
            super.setBackground(Color.WHITE);
        }
    }
    
    /**
     * Returns the xLoc variable of this object
     * @return xLoc X coordinate
     */
    public int getXLoc() {
        return this.xLoc;
    }

    /**
     * Sets the xLoc variable of this object
     * @param x X coordinate
     */
    public void setXLoc(int x) {
        this.xLoc = x;
    }

    /**
     * Returns the yLoc variable of this object
     * @return yLoc Y coordinate
     */
    public int getYLoc() {
        return this.yLoc;
    }

    /**
     * Sets the yLoc variable of this object
     * @param y Y coordinate
     */
    public void setYLoc(int y) {
        this.yLoc = y;
    }
    
    /**
     * Returns the pieceOnSquare variable of this object
     * @return pieceOnSquare Piece object on this Square
     */
    public Piece getPieceOnSquare() {
        return pieceOnSquare;
    }

    /**
     * Sets the pieceOnSquare variable of this object
     * @param pieceOnSquare Piece object on this Square
     */
    public void setPieceOnSquare(Piece pieceOnSquare) {
        this.pieceOnSquare = pieceOnSquare;
        pieceOnSquare.setSquare(this);
        this.setIcon(this.pieceOnSquare.getPieceImage());
    }
    
    /**
     * Removes the Piece object from the pieceOnSquare variable
     */
    public void removePieceOnSquare(){
        this.pieceOnSquare = null;
        this.setIcon(null);
    }
    
    @Override
    public String toString() {
        return "Square{" + "x=" + xLoc + ", y=" + yLoc + '}';
    }  
}
