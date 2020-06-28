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
    
    private Player whitePlayer;
    private Player blackPlayer;
    
    public Board(Player white, Player black){
        this.whitePlayer = white;
        this.blackPlayer = black;
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
        this.squares[0][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[1][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[2][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[3][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[4][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[5][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[6][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[7][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[0][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[1][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[2][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[3][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[4][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[5][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[6][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[7][6].setPieceOnSquare(new Pawn(this.whitePlayer));
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
