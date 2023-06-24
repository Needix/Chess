package de.needix.code.model.pieces.major;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import de.needix.code.model.Board;
import de.needix.code.model.pieces.Piece;

public class Knight extends Piece {

    @Override
    public String getDisplayCharacter() {
        switch (getTeam()) {
            case WHITE:
                return "♘";
            case BLACK:
                return "♞";
        
            default:
                return "";
        }
    }

    @Override
    public List<Point> getValidMoves(Board currentBoard, Point currentPosition) {
        
        List<Point> validMoves = new ArrayList<>();
        int newX;
        int newY;
        int up;
        int down;
        int left;
        int right;

        //up
        newY = currentPosition.y + 2;
        left = currentPosition.x - 1;
        right = currentPosition.x +1;
        
        validMoves.addAll(checkYAxis(currentBoard, left, right, newY));
        

        //down

        newY = currentPosition.y - 2;
        left = currentPosition.x - 1;
        right = currentPosition.x +1;
    
        validMoves.addAll(checkYAxis(currentBoard, left, right, newY));

        //left

        newX = currentPosition.x - 2;
        up = currentPosition.y + 1;
        down = currentPosition.y - 1;

        validMoves.addAll(checkXAxis(up, down, newX, currentBoard));

        //right 

        newX = currentPosition.x + 2;
        up = currentPosition.y + 1;
        down = currentPosition.y - 1;

        validMoves.addAll(checkXAxis(up, down, newX, currentBoard));

        return validMoves;
    }


    private List<Point> checkYAxis(Board currentBoard, int leftX, int rightX, int y){
        
        List<Point> validMoves = new ArrayList<>();

        Point checkLeft = new Point(leftX, y);
        Point checkRight = new Point(rightX, y);

        validMoves.addAll(checkPoint(currentBoard, checkLeft));
        validMoves.addAll(checkPoint(currentBoard, checkRight));

        return validMoves;
    }

    private List<Point> checkXAxis(int upY, int downY, int x, Board currentBoard){

        List<Point> validMoves = new ArrayList<>();

        Point checkUp = new Point(x, upY);
        Point checkDown = new Point(x, downY);

        validMoves.addAll(checkPoint(currentBoard, checkUp));
        validMoves.addAll(checkPoint(currentBoard, checkDown));

        return validMoves;
    }


    private List<Point> checkPoint(Board currentBoard, Point toCheck){
        
        List<Point> validMoves = new ArrayList<>();

        if(currentBoard.isInBounds(toCheck)){
            Piece pieceToCheck = currentBoard.getPiece(toCheck);
            if(pieceToCheck.isValidPiece()){
                if(pieceToCheck.getTeam() != this.getTeam()){
                    validMoves.add(toCheck);
                }
            }
            if (!pieceToCheck.isValidPiece()){
                validMoves.add(toCheck);
            }
        }
        return validMoves;
    }
}
