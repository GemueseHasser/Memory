package de.jonas.memory;

import javax.swing.JButton;

public class CardPair {

    private final MemoryCard card1;
    private final MemoryCard card2;
    private final JButton button1;
    private final JButton button2;

    public CardPair(
        final MemoryCard card1,
        final MemoryCard card2,
        final JButton button1,
        final JButton button2
    ) {
        this.card1 = card1;
        this.card2 = card2;
        this.button1 = button1;
        this.button2 = button2;
    }

    public MemoryCard getCard1() {
        return this.card1;
    }

    public MemoryCard getCard2() {
        return this.card2;
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public boolean isEmpty() {
        return card1 == null && card2 == null;
    }

    public boolean hasFirst() {
        return card1 != null && card2 == null;
    }

    public boolean isFull() {
        return card1 != null && card2 != null;
    }

}
