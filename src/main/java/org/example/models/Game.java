package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.exceptions.NotEnoughPlayersException;
import org.example.strategies.GameWinningStrategies.GameWinningStrategyFactory;

import java.util.List;


@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> playerList;
    private int currentPlayerIndex;
    private List<Move> moveList;
    private GameStatus gameStatus;
    private Player winner;
    private List<GameWinningStrategyEnum> gameWinningStrategyEnums;
    private List<GameWinningStrategy> gameWinningStrategyList;

    public Game(GameBuilder builder) throws NotEnoughPlayersException {
        this.board = builder.board;
        if(builder.playerList.size()<2)
            throw new NotEnoughPlayersException("Atleast 2 players are required to start the game");
        if(builder.gameWinningStrategyEnums.size()==0){
            throw new RuntimeException("Atleast 1 winning strategy is required to start the game");
        }
        this.playerList = builder.playerList;
        this.moveList = builder.moveList;
        this.gameWinningStrategyEnums = builder.gameWinningStrategyEnums;
        this.gameStatus = builder.gameStatus;
        for(GameWinningStrategyEnum gameWinningStrategyEnum : gameWinningStrategyEnums){
            gameWinningStrategyList.add(GameWinningStrategyFactory.getGameWinningStrategy(gameWinningStrategyEnum));
        }
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void nextMove(){
        Player player = playerList.get(currentPlayerIndex);
        Move move = player.makeMove(board);
        moveList.add(move);

        updateBoard(move);

        for(GameWinningStrategy gameWinningStrategy : gameWinningStrategyList){
            if(gameWinningStrategy.isGameWon(board,move)){
                gameStatus = GameStatus.WIN;
                winner = playerList.get(currentPlayerIndex);
                return;
            }
        }

        //check for draw
        boolean isDraw = true;
        for(List<Cell> cellList : board.getCells()){
            for(Cell cell : cellList){
                if(cell.getCellStatus()==CellStatus.EMPTY){
                    isDraw = false;
                }
            }
        }

        if(isDraw){
            gameStatus = GameStatus.DRAW;
            return;
        }

        currentPlayerIndex = (currentPlayerIndex+1)%playerList.size();
    }

    public void updateBoard(Move move){
        board.updateBoard(move);
    }

    public static class GameBuilder{
        private Board board;
        private List<Player> playerList;
        private List<Move> moveList;
        private List<GameWinningStrategyEnum> gameWinningStrategyEnums;
        private List<GameWinningStrategy> gameWinningStrategyList;
        private GameStatus gameStatus;

        public GameBuilder setBoard(int dimension) {
            this.board = new Board(dimension);
            return this;
        }

        public GameBuilder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public GameBuilder setMoveList(List<Move> moveList) {
            this.moveList = moveList;
            return this;
        }

        public GameBuilder setGameWinningStrategyEnums(List<GameWinningStrategyEnum> gameWinningStrategyEnums) {
            this.gameWinningStrategyEnums = gameWinningStrategyEnums;
            return this;
        }

        public GameBuilder setGameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return this;
        }

        public Game build() throws NotEnoughPlayersException {
            return new Game(this);
        }


    }
}
