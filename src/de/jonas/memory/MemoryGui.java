package de.jonas.memory;

import de.jonas.GUI;

import javax.swing.JButton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static de.jonas.Memory.CARDS;
import static de.jonas.Memory.TURN;

public final class MemoryGui {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 520;

    private static final int CARDS_AMOUNT = 16;
    public static final int CARD_SIZE = 110;

    public static final JButton[] BUTTONS = new JButton[CARDS_AMOUNT];

    private static MemoryGui instance;

    public final GUI gui;

    public MemoryGui() {
        instance = this;
        gui = new GUI(WIDTH, HEIGHT, "Memory - by Jonas -", false);

        placeCards(gui);

        gui.show();
    }

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

    public static MemoryGui getInstance() {
        return instance;
    }
}
