package de.needix.code.controller;

import java.awt.Point;
import java.util.List;
import javax.swing.WindowConstants;
import de.needix.code.gui.Window;
import de.needix.code.model.Board;
import de.needix.code.model.EmptyPiece;
import de.needix.code.model.pieces.Piece;
import de.needix.code.model.pieces.Piece.Team;

public class MainController {
    public static final int BOARD_SIZE = 8;

    private Window GUI;
    private Board board;

    private Piece selectedPiece = new EmptyPiece();
    private boolean moveTeam = false; // If boolean is false --> White --> else Black

    public MainController() {
        GUI = new Window(this);
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GUI.setVisible(true);
        GUI.setSize(800, 800);

        board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public Piece movePiece(Piece selectedPiece, Point point) {
        List<Point> validMoves = selectedPiece.getValidMoves(board, board.getPosition(selectedPiece));

        if (!validMoves.contains(point)) {
            return selectedPiece;
        }

        board.movePiece(selectedPiece, point);

        if(selectedPiece.getTeam() == Team.WHITE){
            moveTeam = true;
        } else if(selectedPiece.getTeam()==Team.BLACK){
            moveTeam = false;
        }

        return new EmptyPiece();
    }

    public Piece selectPiece(int xCoord, int yCoord){
        
        if (!selectedPiece.isValidPiece()) {
            selectedPiece = getBoard().getPiece(xCoord, yCoord);
        } else {
            Piece oldPiece = selectedPiece;
            selectedPiece =
                    movePiece(selectedPiece, new Point(xCoord, yCoord));
            if (oldPiece == selectedPiece) {
                selectedPiece = new EmptyPiece();
            }
        } 

        // Todo: only change on move not on select!
        if(selectedPiece.getTeam() == Team.WHITE && !moveTeam){
            
            return selectedPiece;
        } else if(selectedPiece.getTeam() == Team.BLACK && moveTeam){
            
            return selectedPiece;
        } else{
            selectedPiece = new EmptyPiece();
            return selectedPiece;
        }
    }
}
