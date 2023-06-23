package de.needix.code.model.pieces.minor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public List<Point> getValidMoves(Board currentBoard, Point currentPosition) {
        List<Point> validMoves = new ArrayList<>();

        switch (getTeam()) {
            case WHITE:
                // one up
                int newY = currentPosition.y + 1;
                // one up - left
                int newXLeft = currentPosition.x - 1;
                // one up - right
                int newXRight = currentPosition.x + 1;

                Point forward = new Point(currentPosition.x, newY);
                Point forwardLeft = new Point(newXLeft, newY);
                Point forwardRight = new Point(newXRight, newY);

                if (currentBoard.isInBounds(forward)) {
                    Piece forwardPiece = currentBoard.getPiece(forward);
                    if (!forwardPiece.isValidPiece()) {
                        validMoves.add(forward);

                        if (currentPosition.y == 1) {

                            Point jumpPoint = new Point(currentPosition.x, currentPosition.y + 2);
                            Piece jumpPiece = currentBoard.getPiece(jumpPoint);
                            if (!jumpPiece.isValidPiece()) {
                                validMoves.add(jumpPoint);
                            }
                        }
                    }
                }

                if (currentBoard.isInBounds(forwardLeft)) {
                    Piece forwardLeftPiece = currentBoard.getPiece(forwardLeft);
                    if (forwardLeftPiece.isValidPiece() && forwardLeftPiece.getTeam() != this.getTeam()) {
                        validMoves.add(forwardLeft);
                    }
                }

                if (currentBoard.isInBounds(forwardRight)) {
                    Piece forwardRightPiece = currentBoard.getPiece(forwardRight);
                    if (forwardRightPiece.isValidPiece() && forwardRightPiece.getTeam() != this.getTeam()) {
                        validMoves.add(forwardRight);
                    }
                }

                if(newY == MainController.BOARD_SIZE -1 ){
                    //TODO Upgrade that bitch!
                }

                return validMoves;

            case BLACK:

                break;

            default:
                break;
        }
        return validMoves;
    }
}
