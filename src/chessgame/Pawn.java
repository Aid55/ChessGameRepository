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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author atbat
 */
public class Pawn extends Piece{
        
    public Pawn(int x, int y){
        super(x, y);
        this.loadImage();
    }
    
//    private void loadImage(){
//        this.setPieceImage(new ImageIcon("images/WhitePawn.png"));
//    }
    public void loadImage() {
        displayImage(getImage());
    }

    private Image getImage() {
        try {
            return ImageIO.read(getClass().getResourceAsStream(
                    "images/WhitePawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void displayImage(Image image) {
        JLabel label = new JLabel(new ImageIcon(image));

        JPanel panel = new JPanel();
        panel.add(label);

        JScrollPane scrollPane = new JScrollPane(panel);
        JOptionPane.showMessageDialog(null, scrollPane);
    }   
    
}
