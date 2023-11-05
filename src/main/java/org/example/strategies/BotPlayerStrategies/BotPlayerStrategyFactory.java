package org.example.strategies.BotPlayerStrategies;

import org.example.models.BotDifficulty;
import org.example.models.BotPlayerStrategy;

public class BotPlayerStrategyFactory {
    public static BotPlayerStrategy getStrategy(BotDifficulty botDifficulty) {
        switch (botDifficulty) {
            case EASY:
                return new EasyModeStrategy();
            case MEDIUM:
                return new MediumModeStrategy();
            case HARD:
                return new HardModeStrategy();
            default:
                return null;
        }
    }
}
