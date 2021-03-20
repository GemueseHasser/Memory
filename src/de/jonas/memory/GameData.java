package de.jonas.memory;

/**
 * In der {@link GameData} werden alle Informationen zu der einzelnen Spielrunde gesammelt.
 */
public final class GameData {

    //<editor-fold desc="CONSTANTS">
    /** Die Instanz-Variable der {@link GameData}. */
    private static final GameData data = new GameData();
    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Die {@link Integer Anzahl} an Paaren, die der Spieler umgedreht hat. */
    private int pairs;
    //</editor-fold>

    /**
     * Erhöht die {@link Integer Anzahl} an Paaren, die der Spieler umgedreht hat um 1.
     */
    public void incrementPairs() {
        pairs++;
    }

    /**
     * Gibt die aktuelle {@link Integer Anzahl} an Paaren zurück, die der Spieler bisher umgedreht hat.
     *
     * @return die aktuelle {@link Integer Anzahl} an Paaren, die der Spieler bisher umgedreht hat.
     */
    public int getPairs() {
        return this.pairs;
    }

    /**
     * Setzt die {@link Integer Anzahl} an Paaren neu, die der Spieler umgedreht hat.
     *
     * @param pairs Die neue {@link Integer Anzahl} an Paaren, die der Spieler umgedreht hat.
     */
    public void setPairs(final int pairs) {
        this.pairs = pairs;
    }

    /**
     * Gibt die Instanz-Variable der {@link GameData} zurück.
     *
     * @return Die Instanz-Variable der {@link GameData}.
     */
    public static GameData getData() {
        return data;
    }

}
