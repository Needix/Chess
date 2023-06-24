package de.needix.code.model.pieces.major;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.needix.code.controller.MainController;
import de.needix.code.model.Board;
import de.needix.code.model.pieces.Piece;

public class Bishop extends Piece {

    @Override
    public String getDisplayCharacter() {
        switch (getTeam()) {
            case WHITE:
                return "♗";
            case BLACK:
                return "♝";

            default:
                return "";
        }
    }

    @Override
    public List<Point> getValidMoves(Board currentBoard, Point currentPosition) {

        List<Point> validMoves = new ArrayList<>();

        // check up and right
        int newX = currentPosition.x + 1;
        int newY = currentPosition.y + 1;
        while (newX < MainController.BOARD_SIZE && newY < MainController.BOARD_SIZE) {

            Point checkPoint = new Point(newX, newY);
            Piece checkPiece = currentBoard.getPiece(checkPoint);
            if (!currentBoard.isInBounds(checkPoint)) {
                break;
            }
            if (!checkPiece.isValidPiece()) {
                validMoves.add(checkPoint);
            }
            if (checkPiece.isValidPiece() && checkPiece.getTeam() != this.getTeam()) {
                validMoves.add(checkPoint);
                break;
            }
            if (checkPiece.isValidPiece() && checkPiece.getTeam() == this.getTeam()) {
                break;
            }
            newX++;
            newY++;
        }

        // check up and left
        newX = currentPosition.x - 1;
        newY = currentPosition.y + 1;
        while (newX >= 0  && newY < MainController.BOARD_SIZE) {
            Point checkPoint = new Point(newX, newY);
            Piece checkPiece = currentBoard.getPiece(checkPoint);
            if (!currentBoard.isInBounds(checkPoint)) {
                break;
            }
            if (!checkPiece.isValidPiece()) {
                validMoves.add(checkPoint);
            }
            if (checkPiece.isValidPiece() && checkPiece.getTeam() != this.getTeam()) {
                validMoves.add(checkPoint);
                break;
            }
            if (checkPiece.isValidPiece() && checkPiece.getTeam() == this.getTeam()) {
                break;
            }
            newX--;
            newY++;
        }

        // check down and right
        newX = currentPosition.x + 1;
        newY = currentPosition.y - 1;
        while (newX < MainController.BOARD_SIZE  && newY >= 0) {
            
            Point checkPoint = new Point(newX, newY);
            Piece checkPiece = currentBoard.getPiece(checkPoint);
            if (!currentBoard.isInBounds(checkPoint)) {
                break;
            }
            if (!checkPiece.isValidPiece()) {
                validMoves.add(checkPoint);
            }
            if (checkPiece.isValidPiece() && checkPiece.getTeam() != this.getTeam()) {
                validMoves.add(checkPoint);
                break;
            }
            if (checkPiece.isValidPiece() && checkPiece.getTeam() == this.getTeam()) {
                break;
            }
            newX++;
            newY--;
        }

        // check down and left
        newX = currentPosition.x - 1;
        newY = currentPosition.y - 1;
        while (newX >= 0  && newY >= 0) {
            
            Point checkPoint = new Point(newX, newY);
            Piece checkPiece = currentBoard.getPiece(checkPoint);
            if (!currentBoard.isInBounds(checkPoint)) {
                break;
            }
            if (!checkPiece.isValidPiece()) {
                validMoves.add(checkPoint);
            }
            if (checkPiece.isValidPiece() && checkPiece.getTeam() != this.getTeam()) {
                validMoves.add(checkPoint);
                break;
            }
            if (checkPiece.isValidPiece() && checkPiece.getTeam() == this.getTeam()) {
                break;
            }
            newX--;
            newY--;
        }

        return validMoves;
    }
}
