/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Abstract class for chess pieces, to be inherited by chess piece classes
 */ 
public abstract class Piece {
    
    private String whiteImg;
    private String blackImg;
    private Player player;
    private Square square;
    private ImageIcon pieceImage;
    private ArrayList<Square> possibleMoves = new ArrayList<>();
    
    /**
     * Creates a Piece object for a Player
     * @param player Player object
     */
    public Piece(Player player){
        this.player = player;
    }
    
    /**
     * Loads an ImageIcon object for this based on the player colour
     * @param player Player object
     */
    protected void loadImage(Player player) {
        if (whiteImg != null && blackImg != null){
            switch (player.getPieceColour()) {
                case "White":
                    try {
                        Image img = ImageIO.read(getClass().getResourceAsStream(
                                whiteImg));
                        this.setPieceImage(new ImageIcon(img));
                    } catch (IOException e) {
                        System.out.println(e);
                    }   break;
                case "Black":
                    try {
                        Image img = ImageIO.read(getClass().getResourceAsStream(
                                blackImg));
                        this.setPieceImage(new ImageIcon(img));
                    } catch (IOException e) {
                        System.out.println(e);
                    }   break;
                default:
                    System.out.println("No Image found for " + player.getPieceColour());
                    break;
            }
        }
        
    }

    /**
     * Returns the pieceImage variable of this object
     * @return pieceImage ImageIcon object
     */
    protected ImageIcon getPieceImage() {
        return pieceImage;
    }

    /**
     * Sets the pieceImage variable of this object
     * @param pieceImage ImageIcon object
     */
    protected void setPieceImage(ImageIcon pieceImage) {
        this.pieceImage = pieceImage;
    }
    
    /**
     * Returns the player variable of this object
     * @return player Player object
     */
    protected Player getPlayer() {
        return player;
    }

    /**
     * Sets the player variable of this object
     * @param player Player object
     */
    protected void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Returns the square variable of this object
     * @return square Square object
     */
    protected Square getSquare() {
        return square;
    }

    /**
     * Sets the square variable of this object
     * @param square Square object
     */
    protected void setSquare(Square square) {
        this.square = square;
    }
    
    /**
     * Returns an ArrayList of Square objects
     * @return possibleMoves ArrayList of Square objects
     */
    protected ArrayList<Square> getPossibleMoves() {
        return possibleMoves;
    }

    /**
     * Sets the possibleMoves variable to an ArrayList of Square objects
     * @param possibleMoves ArrayList of Square objects
     */
    protected void setPossibleMoves(ArrayList<Square> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }
    
    /**
     * Returns the whiteImg variable of this object
     * @return whiteImg String object
     */
    protected String getWhiteImg() {
        return whiteImg;
    }

    /**
     * Sets the whiteImg variable of this object
     * @param whiteImg String object
     */
    protected void setWhiteImg(String whiteImg) {
        this.whiteImg = whiteImg;
    }

    /**
     * Returns the blackImg variable of this object
     * @return blackImg String variable
     */
    protected String getBlackImg() {
        return blackImg;
    }

    /**
     * Sets the blackImg variable of this object
     * @param blackImg String variable
     */
    protected void setBlackImg(String blackImg) {
        this.blackImg = blackImg;
    }
    
    /**
     * Finds, checks and returns the possible moves for this object
     * Abstract method
     * @param squares 2D array of Square objects
     * @return ArrayList of Square objects
     */
    protected abstract ArrayList<Square> findPossibleMoves(Square[][] squares);
    
    /**
     * 
     */
    protected abstract void moveMade();
    
    @Override
    public String toString() {
        return "Piece{" + "player=" + player.toString() + ", pieceImage=" + pieceImage.toString() + '}';
    }   
}
