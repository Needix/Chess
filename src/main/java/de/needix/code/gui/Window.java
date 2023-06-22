package de.needix.code.gui;

import javax.swing.JFrame;

public class Window extends JFrame {
    private volatile boolean stopped;

    private MainWindowPanel mainWindowFrame;

    public Window() {
        mainWindowFrame = new MainWindowPanel();
        mainWindowFrame.setBounds(0, 0, (int) getBounds().getWidth(),
                (int) getBounds().getHeight());
        mainWindowFrame.setVisible(true);
        this.add(mainWindowFrame);

        new Thread(this::run).start();;
    }

    public void run() {
        while (!stopped) {
            mainWindowFrame.repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
