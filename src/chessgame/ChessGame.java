/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author atbat
 */
public class ChessGame extends JFrame{
    
    public ChessGame(){
        super();
        super.setTitle("Chess Game by Aidan");
        
        super.setLayout(new FlowLayout());
        
        ScorePanel scorePanel = new ScorePanel();
        scorePanel.setPreferredSize(new Dimension(200,800));
        super.add(scorePanel);
        
        Board board = new Board();
        board.setPreferredSize(new Dimension(800,800));
        super.add(board);
        
        Player whitePlayer = new Player("White", board.getSquares());
        Player blackPlayer = new Player("Black", board.getSquares());
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        super.setPreferredSize(new Dimension(1200,800));
        super.pack();
        super.setVisible(true);
        
        Game game = new Game(board, board.getSquares(), whitePlayer, blackPlayer);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ChessGame();
        
        
    }
    
}
