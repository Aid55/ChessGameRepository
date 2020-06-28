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
 */
public class Pawn extends Piece{
    
    public static String whiteImg = "images/WhitePawn.png";
    public static String blackImg = "images/BlackPawn.png";
        
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
    public ArrayList<Integer[]> possibleMoves() {
        ArrayList<Integer[]> moves = new ArrayList<>();
        if(this.getPlayer().getPieceColour() == "White"){
            moves.add(new Integer[]{this.getSquare().getXLoc(), this.getSquare().getYLoc() - 1});
            moves.add(new Integer[]{this.getSquare().getXLoc(), this.getSquare().getYLoc() - 2});
        }
        else if (this.getPlayer().getPieceColour() == "Black"){
            moves.add(new Integer[]{this.getSquare().getXLoc(), this.getSquare().getYLoc() + 1});
            moves.add(new Integer[]{this.getSquare().getXLoc(), this.getSquare().getYLoc() + 2});
        }
        return moves;
    }
    
}
