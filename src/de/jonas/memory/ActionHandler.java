package de.jonas.memory;

import de.jonas.GUI;
import de.jonas.Memory;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import static de.jonas.Memory.FORBIDDEN;
import static de.jonas.Memory.TURN;

/**
 * Mithilfe des {@link ActionHandler ActionHandlers} wird die Aktion, die beim Anklicken einer {@link MemoryCard}
 * ausgeführt werden soll, ausgeführt und die Interaktion insgesamt gehandhabt.
 */
public final class ActionHandler implements ActionListener {

    //<editor-fold desc="CONSTANTS">
    /** Das aktuelle {@link CardPair Karten-Paar}, welches aufgedeckt ist. */
    private static CardPair CURRENT_PAIR = new CardPair(null, null, null, null);
    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Der angeklickte {@link JButton Button}, der sich unter der {@link MemoryCard} befindet. */
    private final JButton button;
    /** Die {@link MemoryCard}, die über dem {@link JButton Button} liegt. */
    private final MemoryCard card;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue Instanz des {@link ActionHandler ActionHandlers}. Hiermit wird dieser dann initialisiert und
     * der jeweilige {@link JButton Button} und die jeweilige (dazu gehörige) {@link MemoryCard} wird deklariert.
     *
     * @param button Der jeweilige {@link JButton Button}, der der auslöser dieses Events war.
     * @param card   Die jeweilige {@link MemoryCard}, die der Auslöser dieses Events war.
     */
    public ActionHandler(
        final JButton button,
        final MemoryCard card
    ) {
        this.button = button;
        this.card = card;
    }
    //</editor-fold>


    //<editor-fold desc="implementation">
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        // check if card is already up
        if (!card.isOff()) {
            return;
        }
        // check if 2 cards alreaydy up
        if (CURRENT_PAIR.isFull()) {
            return;
        }
        // check if one card is alreaydy up
        if (CURRENT_PAIR.hasFirst()) {
            final MemoryCard card1 = CURRENT_PAIR.getCard1();
            final JButton button1 = CURRENT_PAIR.getButton1();
            if (button1.equals(button)) {
                return;
            }
            CURRENT_PAIR = new CardPair(card1, card, button1, button);
            checkPair();
        }
        // check if no card is already up
        if (CURRENT_PAIR.isEmpty()) {
            CURRENT_PAIR = new CardPair(card, null, button, null);
        }
        // change card to up
        button.setIcon(card.getIcon());
    }
    //</editor-fold>

    /**
     * Es wird nachdem zwei Karten aufgedeckt wurden hiermit überprüft, ob der Nutzer zwei gleiche Karten aufgedeckt
     * hat. Wenn dies der Fall ist, werden diese mit einem neuen Bildchen belegt und sind aus der Runde raus. Ansonsten
     * wird das Paar einfach wieder umgedreht und der Nutzer setzt seine Suche fort.
     */
    private void checkPair() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // check if card has the same name
                if (!CURRENT_PAIR.getCard1().getName().equals(CURRENT_PAIR.getCard2().getName())) {
                    CURRENT_PAIR.getButton1().setIcon(TURN.getIcon());
                    CURRENT_PAIR.getButton2().setIcon(TURN.getIcon());
                    clearPair();
                    GameData.getData().incrementPairs();
                    checkWin();
                    return;
                }
                CURRENT_PAIR.getButton1().setIcon(FORBIDDEN.getIcon());
                CURRENT_PAIR.getButton2().setIcon(FORBIDDEN.getIcon());
                CURRENT_PAIR.getCard1().setOff(false);
                CURRENT_PAIR.getCard2().setOff(false);
                clearPair();
                GameData.getData().incrementPairs();
                checkWin();
            }
        }, 750);
    }

    /**
     * Leert das aktuelle {@link CardPair}, welches aufgedeckt wird.
     */
    private void clearPair() {
        CURRENT_PAIR = new CardPair(null, null, null, null);
    }

    /**
     * Überprüft ob alle Karten der Runde gefunden wurden. Wenn dies der Fall ist, wird ein {@link GUI Graphical-User
     * -Interface} geöffnet, in dem der Nutzer dann entscheiden kann, ob er erneut spielen möchte, oder das Spiel
     * beenden möchte.
     */
    private void checkWin() {
        for (MemoryCard card : Memory.CARDS) {
            if (card.isOff()) {
                return;
            }
        }
        new WinGui();
        System.out.println("Your trys: " + GameData.getData().getPairs());
        GameData.getData().setPairs(0);
    }
}
