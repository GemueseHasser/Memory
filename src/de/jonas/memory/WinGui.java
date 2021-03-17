package de.jonas.memory;

import de.jonas.GUI;
import de.jonas.Memory;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WinGui {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    private static final Font FONT = new Font("Arial", Font.BOLD, 20);

    public WinGui() {
        final GUI gui = new GUI(WIDTH, HEIGHT, "Gewonnen!", true);

        final DrawGUI draw = new DrawGUI();
        draw.setBounds(0, 0, WIDTH, HEIGHT);
        draw.setVisible(true);

        final JButton again = new JButton("Nochmal!");
        again.setBounds(50, 120, 200, 50);
        prepareButton(again, 0, gui);

        final JButton exit = new JButton("Beenden!");
        exit.setBounds(50, 200, 200, 50);
        prepareButton(exit, 1, gui);

        gui.add(again);
        gui.add(exit);
        gui.add(draw);
        gui.show();
    }

    private void prepareButton(
        final JButton button,
        final int action,
        final GUI gui
    ) {
        button.setFont(FONT);
        button.setOpaque(true);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFocusable(false);
        button.addMouseListener(new Action(button, action, gui));
        button.addActionListener(new Action(button, action, gui));
    }

    private static final class DrawGUI extends JLabel {
        @Override
        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g.setColor(Color.GRAY);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.WHITE);
            g.setFont(FONT.deriveFont(30f));
            g.drawString("Du hast gewonnen!", 10, 50);

            repaint();
        }
    }

    private static final class Action implements MouseListener, ActionListener {

        private final JButton button;

        private final int action;

        private final GUI gui;

        public Action(
            final JButton button,
            final int action,
            final GUI gui
        ) {
            this.button = button;
            this.action = action;
            this.gui = gui;
        }

        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (action == 0) {
                MemoryGui.getInstance().gui.dispose();
                gui.dispose();

                for (final MemoryCard card : Memory.CARDS) {
                    card.setOff(true);
                }

                new MemoryGui();
            }
            if (action == 1) {
                System.exit(0);
            }
        }

        @Override
        public void mouseClicked(final MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(final MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(final MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(final MouseEvent mouseEvent) {
            button.setBackground(Color.RED);
            button.setForeground(Color.GRAY);
        }

        @Override
        public void mouseExited(final MouseEvent mouseEvent) {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
        }
    }

}
