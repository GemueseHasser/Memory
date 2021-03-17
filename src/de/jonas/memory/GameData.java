package de.jonas.memory;

public class GameData {

    public GameData() {
        data = this;
    }

    private static GameData data;

    private int trys;

    public void incrementTrys() {
        trys++;
    }

    public int getTrys() {
        return this.trys;
    }

    public static GameData getData() {
        return data;
    }

    public void setTrys(final int trys) {
        this.trys = trys;
    }

}
