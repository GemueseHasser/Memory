package de.jonas.memory;

import de.jonas.Memory;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import static de.jonas.Memory.FORBIDDEN;
import static de.jonas.Memory.TURN;

public class ActionHandler implements ActionListener {

    private static CardPair CURRENT_PAIR = new CardPair(null, null, null, null);

    private final JButton button;
    private final MemoryCard card;

    public ActionHandler(
        final JButton button,
        final MemoryCard card
    ) {
        this.button = button;
        this.card = card;
    }

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
                    GameData.getData().incrementTrys();
                    checkWin();
                    return;
                }
                CURRENT_PAIR.getButton1().setIcon(FORBIDDEN.getIcon());
                CURRENT_PAIR.getButton2().setIcon(FORBIDDEN.getIcon());
                CURRENT_PAIR.getCard1().setOff(false);
                CURRENT_PAIR.getCard2().setOff(false);
                clearPair();
                GameData.getData().incrementTrys();
                checkWin();
            }
        }, 750);
    }

    private void clearPair() {
        CURRENT_PAIR = new CardPair(null, null, null, null);
    }

    private void checkWin() {
        for (MemoryCard card : Memory.CARDS) {
            if (card.isOff()) {
                return;
            }
        }
        new WinGui();
        System.out.println("Your trys: " + GameData.getData().getTrys());
        GameData.getData().setTrys(0);
    }
}
