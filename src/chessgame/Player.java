/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

/**
 *
 * @author atbat
 */
public class Player {
    
    private String pieceColour;

    public Player(String pieceColour) {
        this.pieceColour = pieceColour;
    }
    
//    public void makeMove(){
//        System.out.println("");
//    }

    public String getPieceColour() {
        return pieceColour;
    }

    public void setPieceColour(String pieceColour) {
        this.pieceColour = pieceColour;
    }
    

    @Override
    public String toString() {
        return "Player{" + "pieceColour=" + pieceColour + '}';
    }
    
    
    
}


