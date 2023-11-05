package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Board {
    private List<List<Cell>> cells;
    private int dimension;
    public Board(int dimension){
        this.dimension = dimension;
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                cells.get(i).add(new Cell(i,j));
            }
        }
    }

    public void updateBoard(Move move) {
        Cell cell = move.getCell();
        if(cell.getCellStatus()==CellStatus.EMPTY){
            cell.setCellStatus(CellStatus.FILLED);
            cell.setPlayer(move.getPlayer());
        }
        else{
            throw new RuntimeException("Cell is already filled");
        }
    }
}
