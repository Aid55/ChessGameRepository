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
    public final int boardWidth = 8;
    public final int boardHeight = 8;
    private Square[][] squares = new Square[boardWidth][boardHeight];
    
    
    public Board(){
        this.createBoard();
        this.setVisible(true);
    }
    
    private void createBoard(){
        this.setLayout(new GridLayout(boardWidth,boardHeight));
        for (int y=0; y<boardHeight; y++){
            for (int x=0; x<boardWidth; x++){
                this.squares[x][y] = new Square(x, y);
                this.add(squares[x][y]);
            }
        }
        
    }
    
    public void recolourBoard(){
        for (int y=0; y<boardHeight; y++){
            for (int x=0; x<boardWidth; x++){
                this.squares[x][y].initColour();
            }
        }
    }
    
    public void displayPossibleMoves(ArrayList<Square> possibleMoves){
        this.recolourBoard();
        for (Square sq : possibleMoves){
            sq.setColour(Color.yellow);
        }    
    }
    
    public void setSelectedSquareColour(Square s){
        s.setColour(Color.ORANGE);
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }   
    
}
