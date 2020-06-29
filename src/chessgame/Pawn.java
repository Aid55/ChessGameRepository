/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author atbat
 */
public class Pawn extends Piece{
    
    public static String whiteImg = "images/WhitePawn.png";
    public static String blackImg = "images/BlackPawn.png";
    private boolean firstMove = true;
    private ArrayList<Integer[]> possibleMoves = new ArrayList<>();
        
    public Pawn(Player player){
        super(player);
        this.loadImage(player);
    }

    private void loadImage(Player player) {
        if (player.getPieceColour() == "White"){
            try {
                Image img = ImageIO.read(getClass().getResourceAsStream(
                        whiteImg));
                this.setPieceImage(new ImageIcon(img));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (player.getPieceColour() == "Black"){
            try {
                Image img = ImageIO.read(getClass().getResourceAsStream(
                        blackImg));
                this.setPieceImage(new ImageIcon(img));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public ArrayList<Integer[]> findPossibleMoves(Square[][] squares) {
        Square sq = this.getSquare();
        sq.setColour(Color.ORANGE);
        this.getPossibleMoves().clear();
        if (this.getPlayer().getPieceColour() == "White"){
            // check for single square move up
            if (sq.getYLoc() - 1 >= 0 && squares[sq.getXLoc()][sq.getYLoc() - 1].getPieceOnSquare() == null){
                possibleMoves.add(new Integer[]{sq.getXLoc(), sq.getYLoc() - 1});
            }
            // check for double square move up
            if (sq.getYLoc() - 2 >= 0 && squares[sq.getXLoc()][sq.getYLoc() - 1].getPieceOnSquare() == null 
                    && squares[sq.getXLoc()][sq.getYLoc() - 2].getPieceOnSquare() == null
                    && this.isFirstMove() == true){
                possibleMoves.add(new Integer[]{sq.getXLoc(), sq.getYLoc() - 2});
            }
            // check for left diagonal capture
            if (sq.getYLoc() - 1 >= 0 && sq.getXLoc() - 1 >= 0 && squares[sq.getXLoc() - 1][sq.getYLoc() - 1].getPieceOnSquare() != null){
                possibleMoves.add(new Integer[]{sq.getXLoc() - 1, sq.getYLoc() - 1});
            }
            // check for right diagonal capture
            if (sq.getYLoc() - 1 >= 0 && sq.getXLoc() + 1 <= 7 && squares[sq.getXLoc() + 1][sq.getYLoc() - 1].getPieceOnSquare() != null){
                possibleMoves.add(new Integer[]{sq.getXLoc() + 1, sq.getYLoc() - 1});
            }
        }
        else if (this.getPlayer().getPieceColour() == "Black"){
            // check for single square move down
            if (sq.getYLoc() + 1 <= 7 && squares[sq.getXLoc()][sq.getYLoc() + 1].getPieceOnSquare() == null){
                possibleMoves.add(new Integer[]{sq.getXLoc(), sq.getYLoc() + 1});
            }
            // check for double square move down
            if (sq.getYLoc() + 2 <= 7 && squares[sq.getXLoc()][sq.getYLoc() + 1].getPieceOnSquare() == null 
                    && squares[sq.getXLoc()][sq.getYLoc() + 2].getPieceOnSquare() == null
                    && this.isFirstMove() == true){
                possibleMoves.add(new Integer[]{sq.getXLoc(), sq.getYLoc() + 2});
            }
            // check for left diagonal capture
            if (sq.getYLoc() + 1 <= 7 && sq.getXLoc() - 1 >= 0 && squares[sq.getXLoc() - 1][sq.getYLoc() + 1].getPieceOnSquare() != null){
                possibleMoves.add(new Integer[]{sq.getXLoc() - 1, sq.getYLoc() + 1});
            }
            // check for right diagonal capture
            if (sq.getYLoc() + 1 <= 7 && sq.getXLoc() + 1 <= 7 && squares[sq.getXLoc() + 1][sq.getYLoc() + 1].getPieceOnSquare() != null){
                possibleMoves.add(new Integer[]{sq.getXLoc() + 1, sq.getYLoc() + 1});
            }
        }
        this.setFirstMove(false);//to be moved to makeMove method when created
        return this.getPossibleMoves();
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public ArrayList<Integer[]> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(ArrayList<Integer[]> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }
        
}
