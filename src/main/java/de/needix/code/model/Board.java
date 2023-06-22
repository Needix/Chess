package de.needix.code.model;

import de.needix.code.controller.MainController;
import de.needix.code.model.pieces.BishopPiece;
import de.needix.code.model.pieces.KingPiece;
import de.needix.code.model.pieces.KnightPiece;
import de.needix.code.model.pieces.PawnPiece;
import de.needix.code.model.pieces.Piece;
import de.needix.code.model.pieces.QueenPiece;
import de.needix.code.model.pieces.RookPiece;
import de.needix.code.model.pieces.Piece.Team;

public class Board {
    private Piece[][] pieces;

    public Board() {
        fillBoard();
    }

    private void fillBoard() {
        pieces = new Piece[MainController.BOARD_SIZE][MainController.BOARD_SIZE];
        pieces[0][0] = new RookPiece().setTeam(Team.WHITE);
        pieces[0][7] = new RookPiece().setTeam(Team.WHITE);
        pieces[7][0] = new RookPiece().setTeam(Team.BLACK);
        pieces[7][7] = new RookPiece().setTeam(Team.BLACK);

        pieces[1][0] = new KnightPiece().setTeam(Team.WHITE);
        pieces[6][0] = new KnightPiece().setTeam(Team.WHITE);
        pieces[1][7] = new KnightPiece().setTeam(Team.BLACK);
        pieces[6][7] = new KnightPiece().setTeam(Team.BLACK);

        pieces[2][0] = new BishopPiece().setTeam(Team.WHITE);
        pieces[5][0] = new BishopPiece().setTeam(Team.WHITE);
        pieces[2][7] = new BishopPiece().setTeam(Team.BLACK);
        pieces[5][7] = new BishopPiece().setTeam(Team.BLACK);

        pieces[3][0] = new QueenPiece().setTeam(Team.WHITE);
        pieces[3][7] = new QueenPiece().setTeam(Team.BLACK);

        pieces[4][0] = new KingPiece().setTeam(Team.WHITE);
        pieces[4][7] = new KingPiece().setTeam(Team.BLACK);

        for (int i = 0; i < MainController.BOARD_SIZE; i++) {
            pieces[i][1] = new PawnPiece().setTeam(Team.WHITE);
            pieces[i][6] = new PawnPiece().setTeam(Team.BLACK);
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
}
