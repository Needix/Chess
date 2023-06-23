package de.needix.code.model.pieces;

import java.awt.Point;
import java.util.List;
import de.needix.code.model.Board;

public abstract class Piece {
    public enum Team {
        WHITE, BLACK
    }

    private Team team;

    public Piece setTeam(Team team) {
        this.team = team;
        return this;
    }

    public Team getTeam() {
        return team;
    }

    public abstract String getDisplayCharacter();

    public abstract List<Point> getValidMoves(Board currentBoard, Point currentPosition);

    public boolean isValidPiece() {
        return true;
    }
}

