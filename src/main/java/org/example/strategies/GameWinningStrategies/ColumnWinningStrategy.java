package org.example.strategies.GameWinningStrategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.GameWinningStrategy;
import org.example.models.Move;

import java.util.List;

public class ColumnWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean isGameWon(Board board, Move move) {
        int col = move.getCell().getCol();

        char playerSymbol = move.getPlayer().getSymbol().getSymbol();

        //check for row win
        int count = 0;

        List<Cell> colCells = board.getCells().stream().map(cellList -> cellList.get(col)).toList();

        for(Cell cell : colCells){
            if(cell.getPlayer().getSymbol().getSymbol()==playerSymbol){
                count++;
            }
        }

        return count==board.getDimension();
    }
}
