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
 *
 * @author atbat
 */ public abstract class Piece {
    
    private String whiteImg;
    private String blackImg;
    private Player player;
    private Square square;
    private ImageIcon pieceImage;
    private ArrayList<Square> possibleMoves = new ArrayList<>();
    
    /**
     *
     * @param player
     */
    public Piece(Player player){
        this.player = player;
    }
    
    /**
     *
     * @param player
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
     *
     * @return
     */
    protected ImageIcon getPieceImage() {
        return pieceImage;
    }

    /**
     *
     * @param pieceImage
     */
    protected void setPieceImage(ImageIcon pieceImage) {
        this.pieceImage = pieceImage;
    }
    
    /**
     *
     * @return
     */
    protected Player getPlayer() {
        return player;
    }

    /**
     *
     * @param player
     */
    protected void setPlayer(Player player) {
        this.player = player;
    }

    /**
     *
     * @return
     */
    protected Square getSquare() {
        return square;
    }

    /**
     *
     * @param square
     */
    protected void setSquare(Square square) {
        this.square = square;
    }
    
    /**
     *
     * @return
     */
    protected ArrayList<Square> getPossibleMoves() {
        return possibleMoves;
    }

    /**
     *
     * @param possibleMoves
     */
    protected void setPossibleMoves(ArrayList<Square> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }
    
    /**
     *
     * @return
     */
    protected String getWhiteImg() {
        return whiteImg;
    }

    /**
     *
     * @param whiteImg
     */
    protected void setWhiteImg(String whiteImg) {
        this.whiteImg = whiteImg;
    }

    /**
     *
     * @return
     */
    protected String getBlackImg() {
        return blackImg;
    }

    /**
     *
     * @param blackImg
     */
    protected void setBlackImg(String blackImg) {
        this.blackImg = blackImg;
    }
    
    /**
     *
     * @param squares
     * @return
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
