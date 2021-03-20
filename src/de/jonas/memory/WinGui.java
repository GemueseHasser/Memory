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

/**
 * Das {@link WinGui} wird bei einem Sieg aufgerufen. Ein Sieg entsteht durch das richtige zuordnen aller {@link
 * MemoryCard Karten}.
 */
public final class WinGui {

    //<editor-fold desc="CONSTANTS">
    /** Die Breite des {@link WinGui}. */
    private static final int WIDTH = 300;
    /** Die Höhe des {@link WinGui}. */
    private static final int HEIGHT = 300;

    /** Die {@link Font Schriftart}, die für alle Schriften in diesem {@link WinGui} genutzt wird. */
    private static final Font FONT = new Font("Arial", Font.BOLD, 20);
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue und vollständig unabhängige Instanz des {@link WinGui}. Das {@link WinGui} wird bei einem Sieg
     * aufgerufen. Ein Sieg entsteht durch das richtige zuordnen aller * {@link MemoryCard Karten}.
     */
    public WinGui() {
        // create gui
        final GUI gui = new GUI(WIDTH, HEIGHT, "Gewonnen!", true);

        // draw gui
        final DrawGUI draw = new DrawGUI();
        draw.setBounds(0, 0, WIDTH, HEIGHT);
        draw.setVisible(true);

        // create buttons
        final JButton again = new JButton("Nochmal!");
        again.setBounds(50, 120, 200, 50);
        prepareButton(again, 0, gui);

        final JButton exit = new JButton("Beenden!");
        exit.setBounds(50, 200, 200, 50);
        prepareButton(exit, 1, gui);

        // add all components
        gui.add(again);
        gui.add(exit);
        gui.add(draw);

        // open gui
        gui.show();
    }
    //</editor-fold>


    /**
     * Bearbeitet einen {@link JButton Button} so, dass er stylisch gut in das {@link WinGui} passt und stattet ihn mit
     * allen nötigen Funktionen aus.
     *
     * @param button Der {@link JButton Button}, der bearbeitet werden soll.
     * @param action Die {@link Integer Aktion}, die beim anklicken des Buttons ausgeführt werden soll.
     * @param gui    Das {@link GUI Fenster}, in dem der Button platziert werden soll.
     */
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


    //<editor-fold desc="DrawGUI">
    /**
     * Mithilfe dieser Klasse, wird der Hintergrund und der Schriftzug auf das {@link WinGui} gezeichnet.
     */
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
    //</editor-fold>


    //<editor-fold desc="Action">
    /**
     * Mithilfe dieser Klasse wird das über einen Button hovern und das Anklicken eines Buttons verarbeitet.
     */
    private static final class Action implements MouseListener, ActionListener {

        //<editor-fold desc="LOCAL FIELDS">
        /** Der {@link JButton Button}, der angeklickt wurde bzw über den herüber gehovert wurde. */
        private final JButton button;
        /** Die Aktion, die beim Anklicken ausgeführt werden soll. */
        private final int action;
        /**
         * Das Fenster, in dem der {@link JButton Button} sitzt, über den herüber gehovert wurde oder der angeklickt
         * wurde.
         */
        private final GUI gui;
        //</editor-fold>


        //<editor-fold desc="CONSTRUCTORS">
        /**
         * Erzeugt eine neue Instanz der {@link Action Action-Klasse}, in der das über einen Button hovern und das
         * Anklicken eines Buttons verarbeitet wird.
         *
         * @param button Der auslösende {@link JButton Button}.
         * @param action Die Aktion, die beim anklicken ausgeführt werden soll.
         * @param gui    Das {@link GUI Fenster}, in dem der auslösende Button sitzt.
         */
        public Action(
            final JButton button,
            final int action,
            final GUI gui
        ) {
            this.button = button;
            this.action = action;
            this.gui = gui;
        }
        //</editor-fold>


        //<editor-fold desc="implementation">
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
        //</editor-fold>
    }
    //</editor-fold>

}
