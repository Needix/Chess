package de.needix.code.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import de.needix.code.controller.MainController;
import de.needix.code.model.Board;

public class MainWindowPanel extends JPanel {
    private Board currentBoard;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        double cellWidth = ((double) width) / MainController.BOARD_SIZE;
        double cellHeight = ((double) height) / MainController.BOARD_SIZE;

        for (int y = 0; y < MainController.BOARD_SIZE; y++) {
            for (int x = 0; x < MainController.BOARD_SIZE; x++) {
                Color color;
                if ((x + y) % 2 == 0) {
                    color = Color.WHITE;
                } else {
                    color = Color.BLACK;
                }
                g.setColor(color);
                int xCoord = (int) (x * cellWidth);
                int yCoord = (int) (y * cellHeight);
                g.fillRect(xCoord, yCoord, (int) cellWidth, (int) cellHeight);

                currentBoard.getPiece(x, y);
            }
        }
    }

    public void updatePanel(Board currentBoard) {
        this.currentBoard = currentBoard;
        this.repaint();
    }
}
