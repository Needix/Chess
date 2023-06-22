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
        pieces[7][0] = new RookPiece().setTeam(Team.WHITE);
        pieces[0][7] = new RookPiece().setTeam(Team.BLACK);
        pieces[7][7] = new RookPiece().setTeam(Team.BLACK);

        pieces[0][1] = new KnightPiece().setTeam(Team.WHITE);
        pieces[0][6] = new KnightPiece().setTeam(Team.WHITE);
        pieces[7][1] = new KnightPiece().setTeam(Team.BLACK);
        pieces[7][6] = new KnightPiece().setTeam(Team.BLACK);

        pieces[0][2] = new BishopPiece().setTeam(Team.WHITE);
        pieces[0][5] = new BishopPiece().setTeam(Team.WHITE);
        pieces[7][2] = new BishopPiece().setTeam(Team.BLACK);
        pieces[7][5] = new BishopPiece().setTeam(Team.BLACK);

        pieces[0][3] = new QueenPiece().setTeam(Team.WHITE);
        pieces[7][3] = new QueenPiece().setTeam(Team.BLACK);

        pieces[0][4] = new KingPiece().setTeam(Team.WHITE);
        pieces[7][4] = new KingPiece().setTeam(Team.BLACK);

        for (int i = 0; i < MainController.BOARD_SIZE; i++) {
            pieces[1][i] = new PawnPiece().setTeam(Team.WHITE);
            pieces[6][i] = new PawnPiece().setTeam(Team.BLACK);
        }
    }

    public void getPiece(int x, int y) {}
}
