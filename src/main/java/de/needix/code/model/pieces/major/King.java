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
                return "U+2654";

            case BLACK:
                return "U+265A";

            default:
                return "";
        }
    }

    @Override
    public List<Point> getValidMoves(Board currentBoard) {

        Point position = getPos();

        List<Point> validMoves = new ArrayList<>();
        
        //TODO: CHECK CHECK
        
        // Y
        for (int i = -1; i < 2; i++) {
            // X
            for (int j = -1; j < 2; j++) {
                if (position.x == 0 && position.y == 0 ) {
                    if(j > -1 && i > -1){
                        //check for empty space
                        Piece piece = currentBoard.getPiece(j, i);
                        //piece cant move down or left
                        validMoves.add(new Point(j, i));
                    }
                } else if (position.x == 8 && position.y == 8) {
                    if(j < 3 && i < 3){
                        //check for empty space

                        //piece cant move up or right
                        validMoves.add(new Point(j, i));
                    }
                } else {
                    //check for empty space

                    validMoves.add(new Point(j, i));
                }
            }
        }

        // Remove position piece is on from valid moves
        for (Point point : validMoves) {
            if(point.equals(position)){
                validMoves.remove(point);
            }
        }
        return validMoves;
    }

}
