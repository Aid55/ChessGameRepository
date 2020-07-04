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
 *
 * @author atbat
 */
public class Board extends JPanel{

    /**
     *
     */
    public static final int BOARDWIDTH = 8;

    /**
     *
     */
    public static final int BOARDHEIGHT = 8;
    private Square[][] squares = new Square[BOARDWIDTH][BOARDHEIGHT];
    
    /**
     *
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
     *
     */
    public void recolourBoardSquares(){
        for (int y=0; y<BOARDHEIGHT; y++){
            for (int x=0; x<BOARDWIDTH; x++){
                this.squares[x][y].initColour();
            }
        }
    }
    
    /**
     *
     * @param possibleMoves
     */
    public void displayPossibleMoves(ArrayList<Square> possibleMoves){
        this.recolourBoardSquares();
        for (Square sq : possibleMoves){
            sq.setBackground(Color.yellow);
        }    
    }
    
    /**
     *
     * @param s
     */
    public void setSelectedSquareColour(Square s){
        s.setBackground(Color.ORANGE);
    }

    /**
     *
     * @return
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     *
     * @param squares
     */
    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }   
    
}
