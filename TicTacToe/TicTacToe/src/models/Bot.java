package models;

import factories.BotPlayingStrategyFactory;
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

    public Bot(Symbol symbol, String name, PlayerType playerType, BotDiffLevel botDiffLevel) {
        super(symbol,name,playerType);
        this.botDiffLevel = botDiffLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDiffLevel);
    }

    public BotDiffLevel getBotDiffLevel() {
        return botDiffLevel;
    }

    public void setBotDiffLevel(BotDiffLevel botDiffLevel) {
        this.botDiffLevel = botDiffLevel;
    }

}
