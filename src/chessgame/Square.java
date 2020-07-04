/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author atbat
 */
public class Square extends JButton{
    private int xLoc;
    private int yLoc;
    private Piece pieceOnSquare;
    
    /**
     *
     * @param x
     * @param y
     */
    public Square(int x, int y){
//        super(String.valueOf(x) + ", " + String.valueOf(y));
        super();
        this.xLoc = x;
        this.yLoc = y;
        super.setOpaque(true);
    }
    
    /**
     *
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
     *
     * @return
     */
    public int getXLoc() {
        return this.xLoc;
    }

    /**
     *
     * @param x
     */
    public void setXLoc(int x) {
        this.xLoc = x;
    }

    /**
     *
     * @return
     */
    public int getYLoc() {
        return this.yLoc;
    }

    /**
     *
     * @param y
     */
    public void setYLoc(int y) {
        this.yLoc = y;
    }
    
    /**
     *
     * @return
     */
    public Piece getPieceOnSquare() {
        return pieceOnSquare;
    }

    /**
     *
     * @param pieceOnSquare
     */
    public void setPieceOnSquare(Piece pieceOnSquare) {
        this.pieceOnSquare = pieceOnSquare;
        pieceOnSquare.setSquare(this);
        this.setIcon(this.pieceOnSquare.getPieceImage());
    }
    
    /**
     *
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
