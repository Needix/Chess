package de.needix.code.controller;

import javax.swing.WindowConstants;
import de.needix.code.gui.Window;
import de.needix.code.model.Board;

public class MainController {
    public static final int BOARD_SIZE = 8;

    private Window GUI;
    private Board board;

    public MainController() {
        GUI = new Window(this);
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GUI.setVisible(true);
        GUI.setSize(800, 800);

        board = new Board();
    }

    public Board getBoard() {
        return board;
    }
}
