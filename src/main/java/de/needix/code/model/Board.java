package de.needix.code.model;

import java.awt.Point;

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
    private Piece[][] pieces;

    public Board() {
        fillBoard();
    }

    private void fillBoard() {
        pieces = new Piece[MainController.BOARD_SIZE][MainController.BOARD_SIZE];
        pieces[0][0] = new Rook().setTeam(Team.WHITE);
        pieces[0][7] = new Rook().setTeam(Team.WHITE);
        pieces[7][0] = new Rook().setTeam(Team.BLACK);
        pieces[7][7] = new Rook().setTeam(Team.BLACK);

        pieces[1][0] = new Knight().setTeam(Team.WHITE);
        pieces[6][0] = new Knight().setTeam(Team.WHITE);
        pieces[1][7] = new Knight().setTeam(Team.BLACK);
        pieces[6][7] = new Knight().setTeam(Team.BLACK);

        pieces[2][0] = new Bishop().setTeam(Team.WHITE);
        pieces[5][0] = new Bishop().setTeam(Team.WHITE);
        pieces[2][7] = new Bishop().setTeam(Team.BLACK);
        pieces[5][7] = new Bishop().setTeam(Team.BLACK);


        pieces[3][0] = new Queen().setTeam(Team.WHITE);
        pieces[3][7] = new Queen().setTeam(Team.BLACK);

        pieces[4][0] = new King().setTeam(Team.WHITE);
        pieces[4][7] = new King().setTeam(Team.BLACK);

        for (int i = 0; i < MainController.BOARD_SIZE; i++) {
            pieces[i][1] = new Pawn().setTeam(Team.WHITE);
            pieces[i][6] = new Pawn().setTeam(Team.BLACK);
        }

        for (int y = 0; y < MainController.BOARD_SIZE; y++) {
            for (int x = 0; x < MainController.BOARD_SIZE; x++) {
                if (getPiece(x, y) == null) {
                    pieces[x][y] = new EmptyPiece();
                }
            }
        }
    }

    public Piece getPiece(int x, int y) {
        return pieces[x][y];
    }

    public boolean isInBounds(Point position) {
        return position.x >= 0 && position.y >= 0 && position.x < MainController.BOARD_SIZE
                && position.y < MainController.BOARD_SIZE;
    }
}
