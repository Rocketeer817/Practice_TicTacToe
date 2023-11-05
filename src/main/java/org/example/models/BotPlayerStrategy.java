package org.example.models;

public interface BotPlayerStrategy {
    Move getMove(Board board, Player player);
}
