package de.needix.code.gui;

import javax.swing.JFrame;
import de.needix.code.controller.MainController;

public class Window extends JFrame {
    private volatile boolean stopped;

    private MainWindowPanel mainWindowFrame;
    private MainController controller;

    public Window(MainController controller) {
        this.controller = controller;

        mainWindowFrame = new MainWindowPanel(controller);
        mainWindowFrame.setBounds(0, 0, (int) getBounds().getWidth(),
                (int) getBounds().getHeight());
        mainWindowFrame.setVisible(true);
        this.add(mainWindowFrame);

        new Thread(this::run).start();
    }

    public void run() {
        while (!stopped) {
            mainWindowFrame.updatePanel(controller.getBoard());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
