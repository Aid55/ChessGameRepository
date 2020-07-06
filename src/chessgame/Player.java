/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.util.ArrayList;

/**
 * A class representing a chess Player
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
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Creates a Player object
     * @param pieceColour String representing a colour
     * @param squares 2D array of Square objects
     */
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
            this.pieces.add(aPawn);
            this.pieces.add(bPawn);
            this.pieces.add(cPawn);
            this.pieces.add(dPawn); 
            this.pieces.add(ePawn);
            this.pieces.add(fPawn);
            this.pieces.add(gPawn);
            this.pieces.add(hPawn);
            this.pieces.add(king);
            this.pieces.add(queen);
            this.pieces.add(kingSideRook); 
            this.pieces.add(queenSideRook);
            this.pieces.add(lightSqBishop);
            this.pieces.add(darkSqBishop);
            this.pieces.add(queenSideKnight); 
            this.pieces.add(kingSideKnight);
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
            this.pieces.add(aPawn);
            this.pieces.add(bPawn);
            this.pieces.add(cPawn);
            this.pieces.add(dPawn); 
            this.pieces.add(ePawn);
            this.pieces.add(fPawn);
            this.pieces.add(gPawn);
            this.pieces.add(hPawn);
            this.pieces.add(king);
            this.pieces.add(queen);
            this.pieces.add(kingSideRook); 
            this.pieces.add(queenSideRook);
            this.pieces.add(lightSqBishop);
            this.pieces.add(darkSqBishop);
            this.pieces.add(queenSideKnight); 
            this.pieces.add(kingSideKnight);
        }
    }

    /**
     * Returns the pieceColour variable of this object
     * @return pieceColour String object
     */
    public String getPieceColour() {
        return pieceColour;
    }

    /**
     * Sets the pieceColour variable of this object
     * @param pieceColour String object
     */
    public void setPieceColour(String pieceColour) {
        this.pieceColour = pieceColour;
    }

    /**
     * Returns the pieces variable of this object
     * @return pieces ArrayList of Piece objects
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * Sets the pieces variable of this object
     * @param pieces ArrayList of Piece objects
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
    
    public void addPiece(Piece p){
        this.pieces.add(p);
        System.out.println("New piece added");
    }
    
    public void removePiece(Piece p){
        for (Piece x : this.pieces){
            if(x == p){
                this.pieces.remove(x);
                System.out.println("Old piece found and removed");
                break;

            }
        }
        for(Piece i:this.pieces){
            System.out.println("" + i.getClass());
        }
    }

    /**
     * Returns the aPawn variable of this object
     * @return aPawn Pawn Object
     */
    public Pawn getaPawn() {
        return aPawn;
    }

    /**
     * Sets the aPawn variable of this object
     * @param aPawn Pawn object
     */
    public void setaPawn(Pawn aPawn) {
        this.aPawn = aPawn;
    }

    /**
     * Returns the bPawn variable of this object
     * @return bPawn Pawn object
     */
    public Pawn getbPawn() {
        return bPawn;
    }

    /**
     * Sets the bPawn variable of this object
     * @param bPawn Pawn object
     */
    public void setbPawn(Pawn bPawn) {
        this.bPawn = bPawn;
    }

    /**
     * Returns the cPawn variable of this object
     * @return cPawn Pawn object
     */
    public Pawn getcPawn() {
        return cPawn;
    }

    /**
     * Sets the cPawn variable of this object
     * @param cPawn Pawn object
     */
    public void setcPawn(Pawn cPawn) {
        this.cPawn = cPawn;
    }

    /**
     * Returns the dPawn variable of this object
     * @return dPawn Pawn object
     */
    public Pawn getdPawn() {
        return dPawn;
    }

    /**
     * Sets the dPawn variable of this object
     * @param dPawn Pawn object
     */
    public void setdPawn(Pawn dPawn) {
        this.dPawn = dPawn;
    }

    /**
     * Returns the ePawn variable of this object
     * @return ePawn Pawn object
     */
    public Pawn getePawn() {
        return ePawn;
    }

    /**
     * Sets the ePawn variable of this object
     * @param ePawn Pawn object
     */
    public void setePawn(Pawn ePawn) {
        this.ePawn = ePawn;
    }

    /**
     * Returns the fPawn variable of this object
     * @return fPawn Pawn object
     */
    public Pawn getfPawn() {
        return fPawn;
    }

    /**
     * Sets the fPawn variable of this object
     * @param fPawn Pawn object
     */
    public void setfPawn(Pawn fPawn) {
        this.fPawn = fPawn;
    }

    /**
     * Returns the gPawn variable of this object
     * @return gPawn Pawn object
     */
    public Pawn getgPawn() {
        return gPawn;
    }

    /**
     * Sets the gPawn variable of this object
     * @param gPawn Pawn object
     */
    public void setgPawn(Pawn gPawn) {
        this.gPawn = gPawn;
    }

    /**
     * Returns the hPawn variable of this object
     * @return hPawn Pawn object
     */
    public Pawn gethPawn() {
        return hPawn;
    }

    /**
     * Sets the hPawn variable of this object
     * @param hPawn Pawn object
     */
    public void sethPawn(Pawn hPawn) {
        this.hPawn = hPawn;
    }

    /**
     * Returns the kingSideKnight variable of this object
     * @return kingSideKnight Knight object
     */
    public Knight getKingSideKnight() {
        return kingSideKnight;
    }

    /**
     * Sets the kingSideKnight variable of this object
     * @param kingSideKnight Knight object
     */
    public void setKingSideKnight(Knight kingSideKnight) {
        this.kingSideKnight = kingSideKnight;
    }

    /**
     * Returns the queenSideKnight variable of this object
     * @return queenSideKnight Knight object
     */
    public Knight getQueenSideKnight() {
        return queenSideKnight;
    }

    /**
     * Sets the queenSideKnight variable of this object
     * @param queenSideKnight Knight object
     */
    public void setQueenSideKnight(Knight queenSideKnight) {
        this.queenSideKnight = queenSideKnight;
    }

    /**
     * Returns the darkSqBishop variable of this object
     * @return darkSqBishop Bishop object
     */
    public Bishop getDarkSqBishop() {
        return darkSqBishop;
    }

    /**
     * Sets the darkSqBishop variable of this object
     * @param darkSqBishop Bishop object
     */
    public void setDarkSqBishop(Bishop darkSqBishop) {
        this.darkSqBishop = darkSqBishop;
    }

    /**
     * Returns the lightSqBishop variable of this object
     * @return lightSqBishop Bishop object
     */
    public Bishop getLightSqBishop() {
        return lightSqBishop;
    }

    /**
     * Sets the lightSqBishop variable of this object
     * @param lightSqBishop Bishop object
     */
    public void setLightSqBishop(Bishop lightSqBishop) {
        this.lightSqBishop = lightSqBishop;
    }

    /**
     * Returns the kingSideRook variable of this object
     * @return kingSideRook Rook object
     */
    public Rook getKingSideRook() {
        return kingSideRook;
    }

    /**
     * Sets the kingSideRook variable of this object
     * @param kingSideRook Rook object
     */
    public void setKingSideRook(Rook kingSideRook) {
        this.kingSideRook = kingSideRook;
    }

    /**
     * Returns the queenSideRook variable of this object
     * @return queenSideRook Rook object
     */
    public Rook getQueenSideRook() {
        return queenSideRook;
    }

    /**
     * Sets the queenSideRook variable of this object
     * @param queenSideRook Rook object
     */
    public void setQueenSideRook(Rook queenSideRook) {
        this.queenSideRook = queenSideRook;
    }

    /**
     * Returns the king variable of this object
     * @return king King object
     */
    public King getKing() {
        return king;
    }

    /**
     * Sets the king variable of this object
     * @param king King object
     */
    public void setKing(King king) {
        this.king = king;
    }

    /**
     * Returns the queen variable of this object
     * @return queen Queen object
     */
    public Queen getQueen() {
        return queen;
    }

    /**
     * Returns the queen variable of this object
     * @param queen Queen object
     */
    public void setQueen(Queen queen) {
        this.queen = queen;
    }

    @Override
    public String toString() {
        return "Player{" + "pieceColour=" + pieceColour + '}';
    }
    
    
    
}


