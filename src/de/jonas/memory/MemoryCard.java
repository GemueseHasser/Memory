package de.jonas.memory;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.io.IOException;

import static de.jonas.memory.MemoryGui.CARD_SIZE;

/**
 * Eine {@link MemoryCard} besteht aus einem {@link String Namen}, einem {@link ImageIcon Icon} und einem {@link Boolean
 * Zustand}, welcher beschreibt, ob die {@link MemoryCard} umgedreht ist oder nicht.
 */
public final class MemoryCard {

    //<editor-fold desc="LOCAL FIELDS">
    /** Der {@link String Name} der {@link MemoryCard}. */
    private final String name;
    /** Das {@link ImageIcon Icon} der {@link MemoryCard}. */
    private ImageIcon icon;
    /** Der {@link Boolean Zustand} der {@link MemoryCard} (umgedreht oder nicht). */
    private boolean isOff;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">
    /**
     * Erzeugt eine neue und vollständig unabhängige Instanz einer {@link MemoryCard}. Eine {@link MemoryCard} besteht
     * aus einem {@link String Namen}, einem {@link ImageIcon Icon} und einem * {@link Boolean Zustand}, welcher
     * beschreibt, ob die {@link MemoryCard} umgedreht ist oder nicht.
     *
     * @param ressource Der {@link String Pfad} zu dem {@link ImageIcon Icon} der {@link MemoryCard} (ressourcen Pfad).
     * @param name      Der Name der {@link MemoryCard}.
     * @param isOff     Der aktuelle {@link Boolean Zustand} der {@link MemoryCard} (umgedreht oder nicht).
     */
    public MemoryCard(
        final String ressource,
        final String name,
        final boolean isOff
    ) {
        try {
            final Image image = ImageIO.read(getClass().getResource(ressource)).getScaledInstance(
                CARD_SIZE,
                CARD_SIZE,
                Image.SCALE_SMOOTH
            );
            this.icon = new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.isOff = isOff;
    }
    //</editor-fold>


    /**
     * Das {@link ImageIcon Icon} der {@link MemoryCard}.
     *
     * @return Das {@link ImageIcon Icon} der {@link MemoryCard}.
     */
    public ImageIcon getIcon() {
        return this.icon;
    }

    /**
     * Der {@link String Name} der {@link MemoryCard}.
     *
     * @return Der {@link String Name} der {@link MemoryCard}.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Der {@link Boolean Zustand} der {@link MemoryCard} (umgedreht oder nicht).
     *
     * @return Der {@link Boolean Zustand} der {@link MemoryCard} (umgedreht oder nicht).
     */
    public boolean isOff() {
        return this.isOff;
    }

    /**
     * Setzt den {@link Boolean Zustand} der {@link MemoryCard} (ob sie umgedreht ist oder nicht) neu.
     *
     * @param isOff Der neue {@link Boolean Zustand} der {@link MemoryCard} (ob sie umgedreht ist oder nicht).
     */
    public void setOff(final boolean isOff) {
        this.isOff = isOff;
    }

}
