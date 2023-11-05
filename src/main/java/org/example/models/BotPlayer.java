package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.strategies.BotPlayerStrategies.BotPlayerStrategyFactory;

@Getter
@Setter
public class BotPlayer extends Player{

    private BotDifficulty difficulty;
    private BotPlayerStrategy strategy;

    public BotPlayer( char difficulty){
        super();
        switch(difficulty){
            case 'E':
                this.difficulty = BotDifficulty.EASY;
                break;

            case 'M':
                this.difficulty = BotDifficulty.MEDIUM;
                break;

            case 'H':
                this.difficulty = BotDifficulty.HARD;
                break;

            default:
                throw new RuntimeException("Invalid difficulty level");

        }
        this.strategy = BotPlayerStrategyFactory.getStrategy(this.difficulty);
    }

    @Override
    public Move makeMove(Board board) {
        return strategy.getMove(board, this);
    }
}
