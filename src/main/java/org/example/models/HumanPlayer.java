package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumanPlayer extends Player{
    private String name;
    @Override
    public Move makeMove(Board board) {
        return null;
    }
}
