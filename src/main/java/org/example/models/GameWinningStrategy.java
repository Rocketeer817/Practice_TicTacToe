package org.example.models;

public interface GameWinningStrategy {
    boolean isGameWon(Board board, Move move);
}
