package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {
    private Symbol symbol;
    public void setSymbol(char symbol){
        this.symbol = new Symbol();
        this.symbol.setSymbol(symbol);
    }
    public abstract Move makeMove(Board board);
}
