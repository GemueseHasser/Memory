package de.jonas;

import de.jonas.memory.GameData;
import de.jonas.memory.MemoryCard;
import de.jonas.memory.MemoryGui;

public class Memory {

    //<editor-fold desc="CONSTANTS">
    /** Alle {@link MemoryCard Memory-Karten} die in diesem Spiel vorkommen und immer wieder neu verteilt werden. */
    public static final MemoryCard[] CARDS = new MemoryCard[]{
        new MemoryCard("/de/jonas/res/card1.jpg", "Karte1", true),
        new MemoryCard("/de/jonas/res/card1.jpg", "Karte1", true),
        new MemoryCard("/de/jonas/res/card2.jpg", "Karte2", true),
        new MemoryCard("/de/jonas/res/card2.jpg", "Karte2", true),
        new MemoryCard("/de/jonas/res/card3.jpg", "Karte3", true),
        new MemoryCard("/de/jonas/res/card3.jpg", "Karte3", true),
        new MemoryCard("/de/jonas/res/card4.jpg", "Karte4", true),
        new MemoryCard("/de/jonas/res/card4.jpg", "Karte4", true),
        new MemoryCard("/de/jonas/res/card5.jpg", "Karte5", true),
        new MemoryCard("/de/jonas/res/card5.jpg", "Karte5", true),
        new MemoryCard("/de/jonas/res/card6.jpg", "Karte6", true),
        new MemoryCard("/de/jonas/res/card6.jpg", "Karte6", true),
        new MemoryCard("/de/jonas/res/card7.jpg", "Karte7", true),
        new MemoryCard("/de/jonas/res/card7.jpg", "Karte7", true),
        new MemoryCard("/de/jonas/res/card8.jpg", "Karte8", true),
        new MemoryCard("/de/jonas/res/card8.jpg", "Karte8", true),
    };

    /** Die Ansicht einer noch umgedrehten {@link MemoryCard}. */
    public static final MemoryCard TURN = new MemoryCard("/de/jonas/res/turn.jpg", "Umgedreht", true);
    /** Die Ansicht einer {@link MemoryCard}, die schon richtig zugeordnet wurde. */
    public static final MemoryCard FORBIDDEN = new MemoryCard("/de/jonas/res/forbidden.jpg", "Verboten", true);
    //</editor-fold>


    //<editor-fold desc="setup and start">
    /**
     * Die Main-Methode der Anwendung, die vor allen anderen Methoden als erstes aufgerufen wird.
     *
     * @param args .
     */
    public static void main(String[] args) {
        // initialize game-data
        new GameData();
        // open memory-interface
        new MemoryGui();
    }
    //</editor-fold>

}
