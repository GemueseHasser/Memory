package de.jonas.memory;

import de.jonas.GUI;
import de.jonas.Memory;

import javax.swing.JButton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static de.jonas.Memory.CARDS;
import static de.jonas.Memory.TURN;

/**
 * Das {@link GUI Graphical-User-Interface}, in dem das gesamte {@link Memory Memory-Spiel} dargestellt wird.
 */
public final class MemoryGui {

    //<editor-fold desc="CONSTANTS">
    /** Die {@link Integer Breite} des {@link GUI Fensters}. */
    private static final int WIDTH = 500;
    /** Die {@link Integer Höhe} des {@link GUI Fensters}. */
    private static final int HEIGHT = 520;

    /** Die {@link Integer Anzahl} an {@link MemoryCard Karten}, die in dem {@link GUI Fenster} verteilt werden. */
    private static final int CARDS_AMOUNT = 16;
    /** Die {@link Integer Größe}, die eine jede {@link MemoryCard Karte} hat. */
    public static final int CARD_SIZE = 110;

    /** Die {@link JButton Buttons}, die unter den {@link MemoryCard Karten} liegen und das anklicken verarbeiten. */
    public static final JButton[] BUTTONS = new JButton[CARDS_AMOUNT];
    //</editor-fold>


    //<editor-fold desc="STATIC FIELDS">
    /**
     * Die Instanz-Variable des {@link MemoryGui}. Diese funktioniert nur zuverlässig, wenn das {@link MemoryGui} genau
     * einmal instanziiert wurde, da die Variable statisch ist und somit nur die Instanz der neuesten Instanz zurück
     * gibt, da diese nicht für jede Instanz neu erzeugt wird, sondern nur für die neueste.
     */
    private static MemoryGui instance;
    //</editor-fold>

    //<editor-fold desc="LOCAL FIELDS">
    /** Das {@link GUI Fenster}, welches durch die Instanziierung des {@link MemoryGui} erzeugt wird. */
    public final GUI gui;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue und vollständig unabhängige Instanz des {@link MemoryGui}. In diesem {@link GUI Fenster} wird
     * das gesamte {@link Memory Memory-Spiel} dargestellt.
     */
    public MemoryGui() {
        instance = this;
        gui = new GUI(WIDTH, HEIGHT, "Memory - by Jonas -", false);

        placeCards(gui);

        gui.show();
    }
    //</editor-fold>


    /**
     * Platziert alle {@link MemoryCard Karten} in einem bestimmten {@link GUI Fenster}.
     *
     * @param gui Das {@link GUI Fenster}, in dem die {@link MemoryCard Karten} platziert werden sollen.
     */
    private void placeCards(final GUI gui) {
        // shuffle memory cards
        final List<MemoryCard> cards = Arrays.asList(CARDS);
        Collections.shuffle(cards);
        cards.toArray(CARDS);

        int x = 10;
        int y = 10;

        for (int i = 0; i < CARDS_AMOUNT; i++) {
            BUTTONS[i] = new JButton(TURN.getIcon());
            BUTTONS[i].setBounds(x, y, CARD_SIZE, CARD_SIZE);
            BUTTONS[i].addActionListener(new ActionHandler(BUTTONS[i], CARDS[i]));
            x += CARD_SIZE + 10;
            if (i % 4 == 3) {
                y += CARD_SIZE + 10;
                x = 10;
            }
            gui.add(BUTTONS[i]);
        }
    }

    /**
     * Gibt die Instanz-Variable zurück.
     *
     * @return Die Instanz-Variable.
     */
    public static MemoryGui getInstance() {
        return instance;
    }
}
