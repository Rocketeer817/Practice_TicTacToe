package org.example.strategies.GameWinningStrategies;

import org.example.models.Board;
import org.example.models.GameWinningStrategy;
import org.example.models.Move;
import org.example.models.Player;

import java.util.HashMap;
import java.util.Map;

public class OrderOneWinningStrategy implements GameWinningStrategy {
    Map<Player, Map<Integer,Integer>> playerRowMap = new HashMap<>();
    Map<Player, Map<Integer,Integer>> playerColMap = new HashMap<>();
    Map<Player, Integer> playerDiagMap = new HashMap<>();
    Map<Player, Integer> playerAntiDiagMap = new HashMap<>();

    @Override
    public boolean isGameWon(Board board, Move move) {

        Player player = move.getPlayer();

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();


        //check for row win
        if(playerRowMap.containsKey(player)==false) {
            playerRowMap.put(player,new HashMap<>());
        }

        Map<Integer,Integer> rowMap = playerRowMap.get(player);
        rowMap.put(row, rowMap.getOrDefault(row,0)+1);
        if(rowMap.get(row)==board.getDimension()){
            return true;
        }

        //check for col win
        if(playerColMap.containsKey(player)==false) {
            playerColMap.put(player,new HashMap<>());
        }

        Map<Integer,Integer> colMap = playerColMap.get(player);
        colMap.put(col, colMap.getOrDefault(col,0)+1);
        if(colMap.get(col)==board.getDimension()){
            return true;
        }

        //check for diag win
        if(playerDiagMap.containsKey(player)==false) {
            playerDiagMap.put(player,0);
        }

        if(row==col){
            playerDiagMap.put(player,playerDiagMap.get(player)+1);
            if(playerDiagMap.get(player)==board.getDimension()){
                return true;
            }
        }

        //check for antidiag win
        if(playerAntiDiagMap.containsKey(player)==false){
            playerAntiDiagMap.put(player,0);
        }

        if(row+col==board.getDimension()-1){
            playerAntiDiagMap.put(player,playerAntiDiagMap.get(player)+1);
            if(playerAntiDiagMap.get(player)==board.getDimension()){
                return true;
            }
        }

        return false;
    }
}
