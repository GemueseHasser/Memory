package de.jonas.memory;

import javax.swing.JButton;

/**
 * Ein {@link CardPair Karten-Paar} besteht aus zwei {@link MemoryCard Memory-Karten} und zwei (zu den {@link MemoryCard
 * Memory-Karten} zugehörigen) {@link JButton Buttons}.
 */
public final class CardPair {

    //<editor-fold desc="LOCAL FIELDS">
    /** Die erste {@link MemoryCard Memory-Karte}. */
    private final MemoryCard card1;
    /** Die zweite {@link MemoryCard Memory-Karte}. */
    private final MemoryCard card2;
    /** Der erste {@link JButton Button}. */
    private final JButton button1;
    /** Der zweite {@link JButton Button}. */
    private final JButton button2;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt ein neues und vollständig unabhängiges {@link CardPair Karten-Paar}. Dieses {@link CardPair Karten -Paar}
     * besteht aus zwei {@link MemoryCard Memory-Karten} und zwei {@link JButton Buttons}.
     *
     * @param card1   Die erste {@link MemoryCard Memory-Karte}.
     * @param card2   Die zweite {@link MemoryCard Memory-Karte}.
     * @param button1 Der erste {@link JButton Button}.
     * @param button2 Der zweite {@link JButton Button}.
     */
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
    //</editor-fold>


    /**
     * Die erste {@link MemoryCard Memory-Karte}.
     *
     * @return Die erste {@link MemoryCard Memory-Karte}.
     */
    public MemoryCard getCard1() {
        return this.card1;
    }

    /**
     * Die zweite {@link MemoryCard Memory-Karte}.
     *
     * @return Die zweite {@link MemoryCard Memory-Karte}.
     */
    public MemoryCard getCard2() {
        return this.card2;
    }

    /**
     * Der erste {@link JButton Button}.
     *
     * @return Der erste {@link JButton Button}.
     */
    public JButton getButton1() {
        return button1;
    }

    /**
     * Der zweite {@link JButton Button}.
     *
     * @return Der zweite {@link JButton Button}.
     */
    public JButton getButton2() {
        return button2;
    }

    /**
     * Prüft ob das {@link CardPair Karten-Paar} leer ist.
     *
     * @return Ist das {@link CardPair Karten-Paar} leer?
     */
    public boolean isEmpty() {
        return card1 == null && card2 == null;
    }

    /**
     * Prüft ob das {@link CardPair Karten-Paar} genau eine (die erste) {@link MemoryCard Memory-Karte} beinhaltet.
     *
     * @return Hat das {@link CardPair Karten-Paar} genau eine (die erste) {@link MemoryCard Memory-Karte}?
     */
    public boolean hasFirst() {
        return card1 != null && card2 == null;
    }

    /**
     * Prüft ob das {@link CardPair Karten-Paar} voll ist.
     *
     * @return Ist das {@link CardPair Karten-Paar} voll?
     */
    public boolean isFull() {
        return card1 != null && card2 != null;
    }

}
