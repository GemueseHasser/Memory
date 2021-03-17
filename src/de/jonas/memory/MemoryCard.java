package de.jonas.memory;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.io.IOException;

import static de.jonas.memory.MemoryGui.CARD_SIZE;

public final class MemoryCard {

    private final String name;
    private ImageIcon icon;
    private boolean isOff;

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

    public ImageIcon getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOff() {
        return this.isOff;
    }

    public void setOff(final boolean isOff) {
        this.isOff = isOff;
    }

}
