package de.needix.code.model.pieces.major;

import java.awt.Point;
import java.util.Collections;
import java.util.List;
import de.needix.code.model.Board;
import de.needix.code.model.pieces.Piece;

public class Queen extends Piece {

    @Override
    public String getDisplayCharacter() {
        switch (getTeam()) {
            case WHITE:
                return "♕";
            case BLACK:
                return "♛";
        
            default:
                return "";
        }
    }

    @Override
    public List<Point> getValidMoves(Board currentBoard, Point currentPosition) {
        return Collections.emptyList();
    }
}
