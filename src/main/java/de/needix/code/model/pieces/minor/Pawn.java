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
    public List<Point> getValidMoves(Board currentBoard, Point currentPosition) {
        List<Point> validMoves = new ArrayList<>();
        switch (getTeam()) {

            case WHITE:
                // one up
                int upY = currentPosition.y + 1;
                // one up - left
                int upXLeft = currentPosition.x - 1;
                // one up - right
                int upXRight = currentPosition.x + 1;

                Point forward = new Point(currentPosition.x, upY);
                Point forwardLeft = new Point(upXLeft, upY);
                Point forwardRight = new Point(upXRight, upY);

                validMoves = getPossibleMoves(currentBoard, currentPosition, forward, forwardLeft, forwardRight);

                if (upY == MainController.BOARD_SIZE - 1) {
                    // TODO Upgrade that bitch!
                }

                return validMoves;

            case BLACK:

                // one up
                int downY = currentPosition.y - 1;
                // one up - left
                int downXLeft = currentPosition.x - 1;
                // one up - right
                int downXRight = currentPosition.x + 1;

                Point forwardDown = new Point(currentPosition.x, downY);
                Point forwardLeftDown = new Point(downXLeft, downY);
                Point forwardRightDown = new Point(downXRight, downY);

                validMoves = getPossibleMoves(currentBoard, currentPosition, forwardDown, forwardLeftDown,
                        forwardRightDown);

                if (downY == 0) {
                    // TODO Upgrade that bitch!
                }

                return validMoves;

            default:
                break;
        }
        return validMoves;
    }

    private List<Point> getPossibleMoves(Board currentBoard, Point currentPosition, Point forward, Point forwardLeft,
            Point forwardRight) {
        List<Point> validMoves = new ArrayList<>();
        if (currentBoard.isInBounds(forward)) {
            Piece forwardPiece = currentBoard.getPiece(forward);
            if (!forwardPiece.isValidPiece()) {
                validMoves.add(forward);

                    switch (getTeam()) {
                        case WHITE:
                         if (currentPosition.y == 1) {
                            Point jumpPoint = new Point(currentPosition.x, currentPosition.y + 2);
                            Piece jumpPiece = currentBoard.getPiece(jumpPoint);
                            if (!jumpPiece.isValidPiece()) {
                                validMoves.add(jumpPoint);
                            }
                        }
                            break;
                        case BLACK:
                            if (currentPosition.y == 6) {
                            Point jumpPoint = new Point(currentPosition.x, currentPosition.y - 2);
                            Piece jumpPiece = currentBoard.getPiece(jumpPoint);
                            if (!jumpPiece.isValidPiece()) {
                                validMoves.add(jumpPoint);
                            }
                        }
                        break;
                        default:
                            break;
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
        return validMoves;
    }
}
