package de.needix.code.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import de.needix.code.controller.MainController;
import de.needix.code.model.Board;
import de.needix.code.model.pieces.Piece;

public class MainWindowPanel extends JPanel {
    private Board currentBoard;

    @Override
    public void paintComponent(Graphics g) {
        if (currentBoard == null) {
            return;
        }

        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        double cellWidth = ((double) width) / MainController.BOARD_SIZE;
        double cellHeight = ((double) height) / MainController.BOARD_SIZE;

        for (int x = 0; x < MainController.BOARD_SIZE; x++) {
            for (int y = 0; y < MainController.BOARD_SIZE; y++) {
                Color color;
                if ((x + y) % 2 == 0) {
                    color = Color.WHITE;
                } else {
                    color = Color.GRAY;
                }
                g.setColor(color);
                int xCoord = (int) (x * cellWidth);
                int yCoord = (int) (y * cellHeight);
                g.fillRect(xCoord, yCoord, (int) cellWidth, (int) cellHeight);

                g.setColor(Color.BLACK);
                Piece piece = currentBoard.getPiece(x, y);
                ((Graphics2D) g).setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString(piece.getDisplayCharacter(null), (int) (xCoord + (cellWidth / 6)),
                        (int) (yCoord + (cellHeight / 2)));
                // g.drawString(piece.getDisplayCharacter(null), (int) (xCoord), (int) (yCoord));
            }
        }
    }

    public void updatePanel(Board currentBoard) {
        this.currentBoard = currentBoard;
        this.repaint();
    }
}
