package org.example.strategies.GameWinningStrategies;

import org.example.models.GameWinningStrategy;
import org.example.models.GameWinningStrategyEnum;

public class GameWinningStrategyFactory {
    public static GameWinningStrategy getGameWinningStrategy(GameWinningStrategyEnum gameWinningStrategyEnum) {
        switch (gameWinningStrategyEnum) {
            case ROW_WISE:
                return new RowWinningStrategy();
//            case COLUMN_WISE:
//                return new ColumnWiseGameWinningStrategy();
//            case DIAGONAL_WISE:
//                return new DiagonalWiseGameWinningStrategy();
//            case REVERSE_DIAGONAL_WISE:
//                return new ReverseDiagonalWiseGameWinningStrategy();
            case ORDER_ONE:
                return new OrderOneWinningStrategy();
            case CORNER_WISE:
                return new CornerWinningStrategy();
            default:
                return null;
        }
    }
}
