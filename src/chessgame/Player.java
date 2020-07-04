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
    private King king;
    private Queen queen;
    private Rook kingSideRook;
    private Rook queenSideRook;
    private Bishop darkSqBishop;
    private Bishop lightSqBishop;
    private Knight kingSideKnight;
    private Knight queenSideKnight;
    private Pawn aPawn;
    private Pawn bPawn;
    private Pawn cPawn;
    private Pawn dPawn;
    private Pawn ePawn;
    private Pawn fPawn;
    private Pawn gPawn;
    private Pawn hPawn;
    private Piece[] pieces;

    public Player(String pieceColour, Square[][] squares) {
        this.pieceColour = pieceColour;
        this.squares = squares;
        this.createPieces();
        this.placePieces();
    }
    
    private void createPieces(){
        this.king = new King(this);
        queen = new Queen(this);
        kingSideRook = new Rook(this);
        queenSideRook = new Rook(this);
        darkSqBishop = new Bishop(this);
        lightSqBishop = new Bishop(this);
        kingSideKnight = new Knight(this);
        queenSideKnight = new Knight(this);
        aPawn = new Pawn(this);
        bPawn = new Pawn(this);
        cPawn = new Pawn(this);
        dPawn = new Pawn(this);
        ePawn = new Pawn(this);
        fPawn = new Pawn(this);
        gPawn = new Pawn(this);
        hPawn = new Pawn(this);
    }
    
    private void placePieces(){
        if (this.getPieceColour().equals("White")){
            this.squares[0][6].setPieceOnSquare(aPawn);
            this.squares[1][6].setPieceOnSquare(bPawn);
            this.squares[2][6].setPieceOnSquare(cPawn);
            this.squares[3][6].setPieceOnSquare(dPawn);
            this.squares[4][6].setPieceOnSquare(ePawn);
            this.squares[5][6].setPieceOnSquare(fPawn);
            this.squares[6][6].setPieceOnSquare(gPawn);
            this.squares[7][6].setPieceOnSquare(hPawn);
            this.squares[4][7].setPieceOnSquare(king);
            this.squares[3][7].setPieceOnSquare(queen);
            this.squares[0][7].setPieceOnSquare(queenSideRook);
            this.squares[7][7].setPieceOnSquare(kingSideRook);
            this.squares[2][7].setPieceOnSquare(lightSqBishop);
            this.squares[5][7].setPieceOnSquare(darkSqBishop);
            this.squares[1][7].setPieceOnSquare(queenSideKnight);
            this.squares[6][7].setPieceOnSquare(kingSideKnight);
            this.pieces = new Piece[]{aPawn, bPawn, cPawn, dPawn, ePawn, fPawn, gPawn, hPawn, king, queen, kingSideRook, 
                queenSideRook, lightSqBishop, darkSqBishop, queenSideKnight, kingSideKnight};
        }
        else if (this.getPieceColour().equals("Black")){
            this.squares[0][1].setPieceOnSquare(aPawn);
            this.squares[1][1].setPieceOnSquare(bPawn);
            this.squares[2][1].setPieceOnSquare(cPawn);
            this.squares[3][1].setPieceOnSquare(dPawn);
            this.squares[4][1].setPieceOnSquare(ePawn);
            this.squares[5][1].setPieceOnSquare(fPawn);
            this.squares[6][1].setPieceOnSquare(gPawn);
            this.squares[7][1].setPieceOnSquare(hPawn);
            this.squares[4][0].setPieceOnSquare(king);
            this.squares[3][0].setPieceOnSquare(queen);
            this.squares[0][0].setPieceOnSquare(kingSideRook);
            this.squares[7][0].setPieceOnSquare(queenSideRook);
            this.squares[2][0].setPieceOnSquare(lightSqBishop);
            this.squares[5][0].setPieceOnSquare(darkSqBishop);
            this.squares[1][0].setPieceOnSquare(kingSideKnight);
            this.squares[6][0].setPieceOnSquare(queenSideKnight);
            this.pieces = new Piece[]{aPawn, bPawn, cPawn, dPawn, ePawn, fPawn, gPawn, hPawn, king, queen, kingSideRook, 
                queenSideRook, lightSqBishop, darkSqBishop, queenSideKnight, kingSideKnight};
        }
    }

    public String getPieceColour() {
        return pieceColour;
    }

    public void setPieceColour(String pieceColour) {
        this.pieceColour = pieceColour;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }

    public Pawn getaPawn() {
        return aPawn;
    }

    public void setaPawn(Pawn aPawn) {
        this.aPawn = aPawn;
    }

    public Pawn getbPawn() {
        return bPawn;
    }

    public void setbPawn(Pawn bPawn) {
        this.bPawn = bPawn;
    }

    public Pawn getcPawn() {
        return cPawn;
    }

    public void setcPawn(Pawn cPawn) {
        this.cPawn = cPawn;
    }

    public Pawn getdPawn() {
        return dPawn;
    }

    public void setdPawn(Pawn dPawn) {
        this.dPawn = dPawn;
    }

    public Pawn getePawn() {
        return ePawn;
    }

    public void setePawn(Pawn ePawn) {
        this.ePawn = ePawn;
    }

    public Pawn getfPawn() {
        return fPawn;
    }

    public void setfPawn(Pawn fPawn) {
        this.fPawn = fPawn;
    }

    public Pawn getgPawn() {
        return gPawn;
    }

    public void setgPawn(Pawn gPawn) {
        this.gPawn = gPawn;
    }

    public Pawn gethPawn() {
        return hPawn;
    }

    public void sethPawn(Pawn hPawn) {
        this.hPawn = hPawn;
    }

    public Knight getKingSideKnight() {
        return kingSideKnight;
    }

    public void setKingSideKnight(Knight kingSideKnight) {
        this.kingSideKnight = kingSideKnight;
    }

    public Knight getQueenSideKnight() {
        return queenSideKnight;
    }

    public void setQueenSideKnight(Knight queenSideKnight) {
        this.queenSideKnight = queenSideKnight;
    }

    public Bishop getDarkSqBishop() {
        return darkSqBishop;
    }

    public void setDarkSqBishop(Bishop darkSqBishop) {
        this.darkSqBishop = darkSqBishop;
    }

    public Bishop getLightSqBishop() {
        return lightSqBishop;
    }

    public void setLightSqBishop(Bishop lightSqBishop) {
        this.lightSqBishop = lightSqBishop;
    }

    public Rook getKingSideRook() {
        return kingSideRook;
    }

    public void setKingSideRook(Rook kingSideRook) {
        this.kingSideRook = kingSideRook;
    }

    public Rook getQueenSideRook() {
        return queenSideRook;
    }

    public void setQueenSideRook(Rook queenSideRook) {
        this.queenSideRook = queenSideRook;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Queen getQueen() {
        return queen;
    }

    public void setQueen(Queen queen) {
        this.queen = queen;
    }

    @Override
    public String toString() {
        return "Player{" + "pieceColour=" + pieceColour + '}';
    }
    
    
    
}


