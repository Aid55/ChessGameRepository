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
        
        Board board = new Board();
        Player whitePlayer = new Player("White", board.getSquares());
        Player blackPlayer = new Player("Black", board.getSquares());
        super.setTitle("Chess Game by Aidan");
        super.add(board);
        board.setBackground(Color.red); //remove in future
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setPreferredSize(new Dimension(800,800));
        super.pack();
        super.setVisible(true);
        
        Game game = new Game(board, board.getSquares(), whitePlayer, blackPlayer);
        System.out.println("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ChessGame();
        
        
    }
    
}
