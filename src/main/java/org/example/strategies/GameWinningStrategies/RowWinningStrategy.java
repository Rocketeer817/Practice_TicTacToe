package org.example.strategies.GameWinningStrategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.GameWinningStrategy;
import org.example.models.Move;

import java.util.List;

public class RowWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean isGameWon(Board board, Move move) {
        int row = move.getCell().getRow();

        char playerSymbol = move.getPlayer().getSymbol().getSymbol();

        //check for row win
        int count = 0;

        List<Cell> rowCells = board.getCells().get(row);

        for(Cell cell : rowCells){
            if(cell.getPlayer().getSymbol().getSymbol()==playerSymbol){
                count++;
            }
        }

        return count==board.getDimension();
    }
}
