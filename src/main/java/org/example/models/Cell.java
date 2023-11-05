package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private CellStatus cellStatus;
    private Player player;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellStatus = CellStatus.EMPTY;
    }
}
