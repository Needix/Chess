package de.needix.code.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import de.needix.code.controller.MainController;
import de.needix.code.model.pieces.Piece;
import de.needix.code.model.pieces.Piece.Team;
import de.needix.code.model.pieces.major.Bishop;
import de.needix.code.model.pieces.major.King;
import de.needix.code.model.pieces.major.Knight;
import de.needix.code.model.pieces.major.Queen;
import de.needix.code.model.pieces.major.Rook;
import de.needix.code.model.pieces.minor.Pawn;

public class Board {
    private Map<Point, Piece> pointToPieceMap;
    private Map<Piece, Point> piecesToPointMap;

    public Board() {
        fillBoard();
    }

    private void fillBoard() {
        pointToPieceMap = new HashMap<>();
        piecesToPointMap = new HashMap<>();

        pointToPieceMap.put(new Point(0, 0), new Rook().setTeam(Team.WHITE));
        pointToPieceMap.put(new Point(0, 7), new Rook().setTeam(Team.WHITE));
        pointToPieceMap.put(new Point(7, 0), new Rook().setTeam(Team.BLACK));
        pointToPieceMap.put(new Point(7, 7), new Rook().setTeam(Team.BLACK));

        pointToPieceMap.put(new Point(1, 0), new Knight().setTeam(Team.WHITE));
        pointToPieceMap.put(new Point(6, 0), new Knight().setTeam(Team.WHITE));
        pointToPieceMap.put(new Point(1, 7), new Knight().setTeam(Team.BLACK));
        pointToPieceMap.put(new Point(6, 7), new Knight().setTeam(Team.BLACK));

        pointToPieceMap.put(new Point(2, 0), new Bishop().setTeam(Team.WHITE));
        pointToPieceMap.put(new Point(5, 0), new Bishop().setTeam(Team.WHITE));
        pointToPieceMap.put(new Point(2, 7), new Bishop().setTeam(Team.BLACK));
        pointToPieceMap.put(new Point(5, 7), new Bishop().setTeam(Team.BLACK));

        pointToPieceMap.put(new Point(3, 0), new Queen().setTeam(Team.WHITE));
        pointToPieceMap.put(new Point(3, 7), new Queen().setTeam(Team.BLACK));

        pointToPieceMap.put(new Point(4, 0), new King().setTeam(Team.WHITE));
        pointToPieceMap.put(new Point(4, 7), new King().setTeam(Team.BLACK));

        for (int i = 0; i < MainController.BOARD_SIZE; i++) {
            pointToPieceMap.put(new Point(i, 1), new Pawn().setTeam(Team.WHITE));
            pointToPieceMap.put(new Point(i, 6), new Pawn().setTeam(Team.BLACK));
        }

        updatePiecePositions();
    }

    public void movePiece(Piece selectedPiece, Point point) {
        Piece remove2 = pointToPieceMap.remove(getPosition(selectedPiece));
        Point remove = piecesToPointMap.remove(selectedPiece);

        System.out.println(remove2 + " / " + remove);

        pointToPieceMap.put(point, selectedPiece);
        piecesToPointMap.put(selectedPiece, point);
    }

    public void updatePiecePositions() {
        for (Entry<Point, Piece> pointToPiecesEntry : pointToPieceMap.entrySet()) {
            piecesToPointMap.put(pointToPiecesEntry.getValue(), pointToPiecesEntry.getKey());
        }
    }

    public Piece getPiece(int x, int y) {
        Piece piece = pointToPieceMap.get(new Point(x, y));
        if (piece == null) {
            piece = new EmptyPiece();
        }
        return piece;
    }

    public Point getPosition(Piece piece) {
        return piecesToPointMap.get(piece);
    }

    public boolean isInBounds(Point position) {
        return position.x >= 0 && position.y >= 0 && position.x < MainController.BOARD_SIZE
                && position.y < MainController.BOARD_SIZE;
    }
}
