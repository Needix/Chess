package de.needix.code.model.pieces.major;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import de.needix.code.model.Board;
import de.needix.code.model.pieces.Piece;

public class King extends Piece {

    @Override
    public String getDisplayCharacter() {
        switch (getTeam()) {
            case WHITE:
                return "♔";

            case BLACK:
                return "♚";

            default:
                return "";
        }
    }

    @Override
    public List<Point> getValidMoves(Board currentBoard, Point currentPosition) {
        List<Point> validMoves = new ArrayList<>();

        // TODO: check check
        // TODO: check if enemy-piece is protected

        for (int y = -1; y < 2; y++) {
            for (int x = -1; x < 2; x++) {
                int newX = currentPosition.x + x;
                int newY = currentPosition.y + y;

                if (newX < 0 && newX > 7) {
                    continue;
                }
                if (newY < 0 && newY > 7) {
                    continue;
                }

                Piece piece = currentBoard.getPiece(newX, newY);
                if (piece.isValidPiece() == false || piece.getTeam() == this.getTeam()) {
                    continue;
                }

                validMoves.add(new Point(newX, newY));
            }
        }

        // Remove position piece is on from valid moves
        for (Point point : validMoves) {
            if (point.equals(currentPosition)) {
                validMoves.remove(point);
            }
        }
        return validMoves;
    }

}
