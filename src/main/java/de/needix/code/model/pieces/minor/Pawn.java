package de.needix.code.model.pieces.minor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        return Arrays.asList(new Point(currentPosition.x, currentPosition.y + 1),
                new Point(currentPosition.x, currentPosition.y + 2));
    }

}
