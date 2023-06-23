package de.needix.code.model;

import java.awt.Point;
import java.util.Collections;
import java.util.List;
import de.needix.code.model.pieces.Piece;

public class EmptyPiece extends Piece {

    @Override
    public String getDisplayCharacter() {
        return "";
    }

    @Override
    public List<Point> getValidMoves(Board currentBoard) {
        return Collections.emptyList();
    }

    @Override
    public boolean isValidPiece() {
        return false;
    }
}
