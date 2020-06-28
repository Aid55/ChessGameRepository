/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Image;
import java.io.IOException;
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

//    public void loadImage(Image image) {
//        JLabel label = new JLabel(new ImageIcon(image));
//
//        JPanel panel = new JPanel();
//        panel.add(label);
//
//        JScrollPane scrollPane = new JScrollPane(panel);
//        JOptionPane.showMessageDialog(null, scrollPane);
//    }   
    
}
