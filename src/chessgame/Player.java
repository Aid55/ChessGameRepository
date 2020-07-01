/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

/**
 *
 * @author atbat
 */
public class Player {
    
    private String pieceColour;
    private Square[][] squares;

    public Player(String pieceColour, Square[][] squares) {
        this.pieceColour = pieceColour;
        this.squares = squares;
        this.placePieces();
    }
    
    private void placePieces(){
        if (this.getPieceColour().equals("White")){
            this.squares[0][6].setPieceOnSquare(new Pawn(this));
            this.squares[1][6].setPieceOnSquare(new Pawn(this));
            this.squares[2][2].setPieceOnSquare(new Pawn(this));
            this.squares[3][6].setPieceOnSquare(new Pawn(this));
            this.squares[4][6].setPieceOnSquare(new Pawn(this));
            this.squares[5][6].setPieceOnSquare(new Pawn(this));
            this.squares[6][6].setPieceOnSquare(new Pawn(this));
            this.squares[7][6].setPieceOnSquare(new Pawn(this));
            this.squares[3][7].setPieceOnSquare(new King(this));
            this.squares[4][7].setPieceOnSquare(new Queen(this));
            this.squares[0][7].setPieceOnSquare(new Rook(this));
            this.squares[7][7].setPieceOnSquare(new Rook(this));
            this.squares[2][7].setPieceOnSquare(new Bishop(this));
            this.squares[5][7].setPieceOnSquare(new Bishop(this));
            this.squares[1][7].setPieceOnSquare(new Knight(this));
            this.squares[6][7].setPieceOnSquare(new Knight(this));
        }
        else if (this.getPieceColour().equals("Black")){
            this.squares[0][1].setPieceOnSquare(new Pawn(this));
            this.squares[1][1].setPieceOnSquare(new Pawn(this));
            this.squares[2][1].setPieceOnSquare(new Pawn(this));
            this.squares[3][1].setPieceOnSquare(new Pawn(this));
            this.squares[4][5].setPieceOnSquare(new Pawn(this));//reset y
            this.squares[5][1].setPieceOnSquare(new Pawn(this));
            this.squares[6][1].setPieceOnSquare(new Pawn(this));
            this.squares[7][1].setPieceOnSquare(new Pawn(this));
            this.squares[4][0].setPieceOnSquare(new King(this));
            this.squares[3][0].setPieceOnSquare(new Queen(this));
            this.squares[0][0].setPieceOnSquare(new Rook(this));//reset y
            this.squares[7][0].setPieceOnSquare(new Rook(this));
            this.squares[2][0].setPieceOnSquare(new Bishop(this));
            this.squares[5][0].setPieceOnSquare(new Bishop(this));
            this.squares[1][0].setPieceOnSquare(new Knight(this));
            this.squares[6][0].setPieceOnSquare(new Knight(this));
        }
    }
    
    public void makeMove(){
        System.out.println("It's " + pieceColour + "'s move!");
    }

    public String getPieceColour() {
        return pieceColour;
    }

    public void setPieceColour(String pieceColour) {
        this.pieceColour = pieceColour;
    }

    @Override
    public String toString() {
        return "Player{" + "pieceColour=" + pieceColour + '}';
    }
    
    
    
}


