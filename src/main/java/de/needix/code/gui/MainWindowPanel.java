package de.needix.code.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import de.needix.code.controller.MainController;
import de.needix.code.model.Board;
import de.needix.code.model.EmptyPiece;
import de.needix.code.model.pieces.Piece;

public class MainWindowPanel extends JPanel implements MouseListener {
    private Board currentBoard;
    private Piece selectedPiece = new EmptyPiece();

    public MainWindowPanel() {
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        if (currentBoard == null) {
            return;
        }

        super.paintComponent(g);

        double cellWidth = getCellWidth();
        double cellHeight = getCellHeight();

        Set<Point> validMoves = new HashSet<>(selectedPiece.getValidMoves(currentBoard));

        for (int x = 0; x < MainController.BOARD_SIZE; x++) {
            for (int y = 0; y < MainController.BOARD_SIZE; y++) {
                Piece piece = currentBoard.getPiece(x, y);

                Color color;
                if (piece == selectedPiece) {
                    color = Color.blue;
                } else if (validMoves.contains(new Point(x, y))) {
                    color = Color.red;
                } else if ((x + y) % 2 == 0) {
                    color = Color.WHITE;
                } else {
                    color = Color.GRAY;
                }

                g.setColor(color);
                int xCoord = (int) (x * cellWidth);
                int yCoord = (int) ((MainController.BOARD_SIZE - y - 1) * cellHeight);
                g.fillRect(xCoord, yCoord, (int) cellWidth, (int) cellHeight);

                g.setColor(Color.BLACK);
                ((Graphics2D) g).setFont(new Font("Courier", Font.BOLD, 80));
                g.drawString(piece.getDisplayCharacter(null), (int) (xCoord + (cellWidth / 10)),
                        (int) (yCoord + (cellHeight / 1.2)));
            }
        }
    }

    private double getCellWidth() {
        return getCellDimension(getWidth());
    }

    private double getCellHeight() {
        return getCellDimension(getHeight());
    }

    private double getCellDimension(int dimension) {
        return ((double) dimension) / MainController.BOARD_SIZE;
    }

    public void updatePanel(Board currentBoard) {
        this.currentBoard = currentBoard;
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int xCoord = e.getX();
        int yCoord = e.getY();

        double cellWidth = getCellWidth();
        double cellHeight = getCellHeight();

        int coordPieceX = (int) (xCoord / cellWidth);
        int coordPieceY = (int) (yCoord / cellHeight);

        selectedPiece =
                currentBoard.getPiece(coordPieceX, MainController.BOARD_SIZE - coordPieceY - 1);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Not needed
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Not needed
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not needed
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Not needed
    }
}
