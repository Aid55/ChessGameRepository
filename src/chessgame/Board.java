/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * A class to represent a chess board
 */
public class Board extends JPanel{

    /**
     * Width of the chess board in squares
     */
    public static final int BOARDWIDTH = 8;

    /**
     * Height of the chess board in squares
     */
    public static final int BOARDHEIGHT = 8;
    private Square[][] squares = new Square[BOARDWIDTH][BOARDHEIGHT];
    
    /**
     * Creates a Board object
     */
    public Board(){
        this.createBoard();
        super.setVisible(true);
    }
    
    private void createBoard(){
        this.setLayout(new GridLayout(BOARDWIDTH,BOARDHEIGHT));
        for (int y=0; y<BOARDHEIGHT; y++){
            for (int x=0; x<BOARDWIDTH; x++){
                this.squares[x][y] = new Square(x, y);
                this.add(squares[x][y]);
            }
        }
        this.recolourBoardSquares();
        
    }
    
    /**
     * Recolours board squares
     */
    public void recolourBoardSquares(){
        for (int y=0; y<BOARDHEIGHT; y++){
            for (int x=0; x<BOARDWIDTH; x++){
                this.squares[x][y].initColour();
            }
        }
    }
    
    /**
     * Highlights possible moves on board in a set colour based on the parameter
     * @param possibleMoves ArrayList of Square objects
     */
    public void displayPossibleMoves(ArrayList<Square> possibleMoves){
        this.recolourBoardSquares();
        for (Square sq : possibleMoves){
            sq.setBackground(Color.yellow);
        }    
    }
    
    /**
     * Changes the colour of a board square
     * @param s Square object
     */
    public void setSelectedSquareColour(Square s, Color c){
        s.setBackground(c);
    }

    /**
     * Returns the squares variable of this object
     * @return squares 2D Array of Square objects
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Sets the squares variable of this object
     * @param squares 2D Array of Square objects
     */
    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }   
    
}
