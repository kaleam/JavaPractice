package models;

import strategies.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDiffLevel botDiffLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public Bot(BotDiffLevel botDiffLevel) {
        this.botDiffLevel = botDiffLevel;
    }

    public BotDiffLevel getBotDiffLevel() {
        return botDiffLevel;
    }

    public void setBotDiffLevel(BotDiffLevel botDiffLevel) {
        this.botDiffLevel = botDiffLevel;
    }

}
