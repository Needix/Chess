package de.needix.code.model.pieces;

import java.awt.Point;
import java.util.List;
import de.needix.code.model.Board;

public abstract class Piece {
    public enum Team {
        WHITE, BLACK
    }

    private Point pos;
    private Team team;

    public Piece setTeam(Team team) {
        this.team = team;
        return this;
    }

    public Team getTeam() {
        return team;
    }

    public Piece setPos(Point pos) {
        this.pos = pos;
        return this;
    }

    public Point getPos() {
        return pos;
    }

    public abstract String getDisplayCharacter(Team team);

    public abstract List<Point> getValidMoves(Board currentBoard);
}
