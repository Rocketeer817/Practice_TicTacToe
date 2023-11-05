package org.example.strategies.GameWinningStrategies;

import org.example.models.Board;
import org.example.models.GameWinningStrategy;
import org.example.models.Move;

public class CornerWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean isGameWon(Board board, Move move) {
        return false;
    }
}
