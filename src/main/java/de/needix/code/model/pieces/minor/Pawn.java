package de.needix.code.model.pieces.minor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import de.needix.code.controller.MainController;
import de.needix.code.model.Board;
import de.needix.code.model.pieces.Piece;

public class Pawn extends Piece {

    @Override
    public String getDisplayCharacter() {
        switch (getTeam()) {
            case WHITE:
                return "♙";
            case BLACK:
                return "♟";
            default:
                return "";
        }
    }

    @Override
    public List<Point> getValidMoves(Board currentBoard) {

        Point position = this.getPos();
        List<Point> validMoves = new ArrayList<>();

        switch (getTeam()) {
            case WHITE:

                int newX = position.x + 1;
                int newYLeft = position.y - 1;
                int newYRight = position.y + 1;

                Point posForward = new Point(newX, position.y);
                Point posForwardLeft = new Point(newX, newYLeft);
                Point posForwardRight = new Point(newX, newYRight);

                if (currentBoard.isInBounds(posForward)) {
                    Piece frontPiece = currentBoard.getPiece(newX, position.y);
                    if (!frontPiece.isValidPiece()) {
                        validMoves.add(new Point(newX, position.y));
                    }
                } else if (currentBoard.isInBounds(posForwardLeft)) {
                    Piece frontLeftPiece = currentBoard.getPiece(newX, newYLeft);
                    if (frontLeftPiece.isValidPiece() && frontLeftPiece.getTeam() != this.getTeam()) {
                        validMoves.add(new Point(newX, newYLeft));
                    }
                } else if (currentBoard.isInBounds(posForwardRight)) {
                    Piece frontRightPiece = currentBoard.getPiece(newX, newYRight);
                    if (frontRightPiece.isValidPiece() && frontRightPiece.getTeam() != this.getTeam()) {
                        validMoves.add(new Point(newX, newYRight));
                    }
                }

                if (newX == MainController.BOARD_SIZE - 1) {
                    // Upgrade oder so, keine ahnung, gib dem pawn einfach ne Bazuka
                }

                return validMoves;

            case BLACK:

                break;

            default:
                break;
        }

    }

}
