package de.needix.code.model;

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
        pieces[7][0] = new Rook().setTeam(Team.WHITE);
        pieces[0][7] = new Rook().setTeam(Team.BLACK);
        pieces[7][7] = new Rook().setTeam(Team.BLACK);

        pieces[0][1] = new Knight().setTeam(Team.WHITE);
        pieces[0][6] = new Knight().setTeam(Team.WHITE);
        pieces[7][1] = new Knight().setTeam(Team.BLACK);
        pieces[7][6] = new Knight().setTeam(Team.BLACK);

        pieces[0][2] = new BishopPiece().setTeam(Team.WHITE);
        pieces[0][5] = new BishopPiece().setTeam(Team.WHITE);
        pieces[7][2] = new BishopPiece().setTeam(Team.BLACK);
        pieces[7][5] = new BishopPiece().setTeam(Team.BLACK);

        pieces[0][3] = new Queen().setTeam(Team.WHITE);
        pieces[7][3] = new Queen().setTeam(Team.BLACK);

        pieces[0][4] = new KingPiece().setTeam(Team.WHITE);
        pieces[7][4] = new KingPiece().setTeam(Team.BLACK);

        for (int i = 0; i < MainController.BOARD_SIZE; i++) {
            pieces[1][i] = new Pawn().setTeam(Team.WHITE);
            pieces[6][i] = new Pawn().setTeam(Team.BLACK);
        }
    }

    public void getPiece(int x, int y) {}
}
