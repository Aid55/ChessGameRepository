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
    private Square selectedSquare;
    private Square previousSquare;
    
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
        this.squares[4][5].setPieceOnSquare(new Pawn(this.blackPlayer));//reset y
        this.squares[5][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[6][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[7][1].setPieceOnSquare(new Pawn(this.blackPlayer));
        this.squares[4][0].setPieceOnSquare(new King(this.blackPlayer));
        this.squares[3][0].setPieceOnSquare(new Queen(this.blackPlayer));
        this.squares[0][0].setPieceOnSquare(new Rook(this.blackPlayer));//reset y
        this.squares[7][0].setPieceOnSquare(new Rook(this.blackPlayer));
        this.squares[2][0].setPieceOnSquare(new Bishop(this.blackPlayer));
        this.squares[5][5].setPieceOnSquare(new Bishop(this.blackPlayer));
        this.squares[1][0].setPieceOnSquare(new Knight(this.blackPlayer));
        this.squares[6][0].setPieceOnSquare(new Knight(this.blackPlayer));
        
        this.squares[0][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[1][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[2][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[3][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[4][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[5][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[6][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[7][6].setPieceOnSquare(new Pawn(this.whitePlayer));
        this.squares[3][7].setPieceOnSquare(new King(this.whitePlayer));
        this.squares[4][7].setPieceOnSquare(new Queen(this.whitePlayer));
        this.squares[0][7].setPieceOnSquare(new Rook(this.whitePlayer));
        this.squares[7][7].setPieceOnSquare(new Rook(this.whitePlayer));
        this.squares[2][7].setPieceOnSquare(new Bishop(this.whitePlayer));
        this.squares[5][7].setPieceOnSquare(new Bishop(this.whitePlayer));
        this.squares[1][7].setPieceOnSquare(new Knight(this.whitePlayer));
        this.squares[6][7].setPieceOnSquare(new Knight(this.whitePlayer));
        
    }
    
    public void recolourBoard(){
        for (int y=0; y<boardHeight; y++){
            for (int x=0; x<boardWidth; x++){
                this.squares[x][y].initColour();
            }
        }
    }
    
    public void actionPerformed(ActionEvent anEvent){
        this.setPreviousSquare(this.getSelectedSquare());
        this.setSelectedSquare((Square) anEvent.getSource());
        if (this.getSelectedSquare().getPieceOnSquare() != null){
            this.recolourBoard();
            for (Integer[] loc : this.getSelectedSquare().getPieceOnSquare().findPossibleMoves(this.getSquares())){
                this.getSquares()[loc[0]][loc[1]].setColour(Color.yellow);
            }
        }
//        if (this.selectedSquare.getColour() == Color.GRAY){
//            this.selectedSquare.setColour(Color.WHITE);
//        }
//        else{
//            this.selectedSquare.setColour(Color.GRAY);
//        }
//        if (this.selectedSquare.getPieceOnSquare() != null){
//            System.out.println(this.selectedSquare.getPieceOnSquare().toString());
//        }
//        else{
//            System.out.println("Nothing on this square");
//        }
    }
    
    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Square getSelectedSquare() {
        return selectedSquare;
    }

    public void setSelectedSquare(Square selectedSquare) {
        this.selectedSquare = selectedSquare;
    }

    public Square getPreviousSquare() {
        return previousSquare;
    }

    public void setPreviousSquare(Square previousSquare) {
        this.previousSquare = previousSquare;
    }
    
    
}
