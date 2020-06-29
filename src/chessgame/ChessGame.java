/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author atbat
 */
public class ChessGame extends JFrame{
    
    public ChessGame(){
        super();
        Player whitePlayer = new Player("White");
        Player blackPlayer = new Player("Black");
        Board board = new Board(whitePlayer, blackPlayer);
        this.setTitle("Chess Game by Aidan");
        this.add(board);
        board.setBackground(Color.red); //remove in future
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,800));
        this.pack();
        this.setVisible(true);
        
        Game game = new Game(board, whitePlayer, blackPlayer);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ChessGame();
        
        
    }
    
}
