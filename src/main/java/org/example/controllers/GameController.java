package org.example.controllers;

import org.example.exceptions.NotEnoughPlayersException;
import org.example.models.*;

import java.util.*;

public class GameController {
    public Game createGame(int dimension, List<Player> playerList, List<GameWinningStrategyEnum> gameWinningStrategyEnums) throws NotEnoughPlayersException {
        Game game = Game.getBuilder()
                .setBoard(dimension)
                .setPlayerList(playerList)
                .setGameWinningStrategyEnums(gameWinningStrategyEnums)
                .setGameStatus(GameStatus.IN_PROGRESS)
                .build();

        return game;
    }

    public void makeMove(Game game) {
        game.nextMove();
    }

    public List<Player> initializePlayers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players");
        int n = sc.nextInt();
        List<Player> playerList = new ArrayList<>();
        Set<Character> symbolsSet = new HashSet<>();

        boolean botPresent = false;
        for(int i = 0; i< n; i++){
            System.out.println("Choose if the player is human? (y/n)");
            char choice = sc.next().charAt(0);
            Player player;
            if(choice=='n'){
                if(botPresent){
                    System.out.println("Only one bot allowed");
                    throw new RuntimeException("Only one bot allowed");
                }
                botPresent = true;
                System.out.println("Enter the difficulty level (E/M/H)");
                char difficulty = sc.next().charAt(0);
                player = new BotPlayer(difficulty);
            }
            else {

                System.out.println("Enter the name for player "+(i+1));
                String name = sc.next();
                player = new HumanPlayer(){
                    {
                        setName(name);
                    }
                };

            }

            System.out.println("Enter the symbol for player "+(i+1));
            char symbol = sc.next().charAt(0);

            if(symbolsSet.contains(symbol)){
                System.out.println("Symbol already taken");
                throw new RuntimeException("Symbol already taken");
            }
            symbolsSet.add(symbol);
            player.setSymbol(symbol);
            playerList.add(player);
        }
        return playerList;
    }
}
