/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author atbat
 */
public class Board extends JPanel implements ActionListener{
    public final int boardWidth = 8;
    public final int boardHeight = 8;
    private Square[][] squares = new Square[boardWidth][boardHeight];
    public Square selectedSquare;
    
    public Board(){
        this.createBoard();
        this.setVisible(true);
    }
    
    private void createBoard(){
        this.setLayout(new GridLayout(boardWidth,boardHeight));
        for (int y=0; y<boardHeight; y++){
            for (int x=0; x<boardWidth; x++){
                this.squares[x][y] = new Square(x, y);
                this.squares[x][y].addActionListener(this);
                this.add(squares[x][y]);
            }
        }
        this.addPieces();
        
    }
    
    private void addPieces(){
        this.squares[3][4].setPieceOnSquare(new Pawn(3, 4));
        
    }
    
    public void actionPerformed(ActionEvent e){
        this.selectedSquare = (Square) e.getSource();
        if (this.selectedSquare.getColour() == Color.GRAY){
            this.selectedSquare.setColour(Color.WHITE);
        }
        else{
            this.selectedSquare.setColour(Color.GRAY);
        }
    }
    
    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }
}
