package de.needix.code.controller;

import java.awt.Point;
import java.util.List;
import javax.swing.WindowConstants;
import de.needix.code.gui.Window;
import de.needix.code.model.Board;
import de.needix.code.model.EmptyPiece;
import de.needix.code.model.pieces.Piece;

public class MainController {
    public static final int BOARD_SIZE = 8;

    private Window GUI;
    private Board board;

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
        List<Point> validMoves =
                selectedPiece.getValidMoves(board, board.getPosition(selectedPiece));

        if (!validMoves.contains(point)) {
            return selectedPiece;
        }

        board.movePiece(selectedPiece, point);

        return new EmptyPiece();
    }
}
