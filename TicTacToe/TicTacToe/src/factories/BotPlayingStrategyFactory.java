package factories;

import models.BotDiffLevel;
import strategies.botPlayingStrategy.EasyBotPlayingStrategy;
import strategies.botPlayingStrategy.HardBotPlayingStrategy;
import strategies.botPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static getBotPlayingStrategy(BotDiffLevel botDiffLevel){
        if(botDiffLevel.equals(botDiffLevel.EASY)){
            return new EasyBotPlayingStrategy();
        }
        else if(botDiffLevel.equals(botDiffLevel.MEDIUM)){
            return new MediumBotPlayingStrategy();
        }
        else{
            return new HardBotPlayingStrategy();
        }
    }
}
