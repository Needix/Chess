package de.needix.code.model.pieces.major;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import de.needix.code.controller.MainController;
import de.needix.code.model.Board;
import de.needix.code.model.pieces.Piece;

public class Rook extends Piece {


    @Override
    public String getDisplayCharacter() {
        switch (getTeam()) {
            case WHITE:
                return "♖";
            case BLACK:
                return "♜";
        
            default:
                return "";
        }
    }

    @Override
    public List<Point> getValidMoves(Board currentBoard, Point currentPosition) {
        List<Point> validMoves = new ArrayList<>();

        //X-axis - right
        for (int i = currentPosition.x; i < MainController.BOARD_SIZE; i++) {
            Point check = new Point(i, currentPosition.y);
            if(currentBoard.isInBounds(currentPosition)){
                Piece blockingPiece = currentBoard.getPiece(currentPosition);
                if(!blockingPiece.isValidPiece()){
                    validMoves.add(check);
                } else{
                    break;
                }
            }
        }
        //X-axis - left
        for (int i = currentPosition.x; i >= 0; i--) {
            Point check = new Point(i, currentPosition.y);
            if(currentBoard.isInBounds(currentPosition)){
                Piece blockingPiece = currentBoard.getPiece(currentPosition);
                if(!blockingPiece.isValidPiece()){
                    validMoves.add(check);
                } else{
                    break;
                }
            }
        }

        //Y-axis - up
        for (int i = currentPosition.x; i < MainController.BOARD_SIZE; i++) {
            Point check = new Point(currentPosition.x, i);
            if(currentBoard.isInBounds(currentPosition)){
                Piece blockingPiece = currentBoard.getPiece(currentPosition);
                if(!blockingPiece.isValidPiece()){
                    validMoves.add(check);
                } else{
                    break;
                }
            }
        }
        //Y-axis - down
        for (int i = currentPosition.x; i >= 0; i--) {
            Point check = new Point(currentPosition.x, i);
            if(currentBoard.isInBounds(currentPosition)){
                Piece blockingPiece = currentBoard.getPiece(currentPosition);
                if(!blockingPiece.isValidPiece()){
                    validMoves.add(check);
                } else{
                    break;
                }
            }
        }

        return validMoves;
    }

}
