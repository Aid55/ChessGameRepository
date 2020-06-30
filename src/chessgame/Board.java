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
        this.squares[5][0].setPieceOnSquare(new Bishop(this.blackPlayer));
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
    
    public void showPossibleMoves(ArrayList<Square> possibleMoves){
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
