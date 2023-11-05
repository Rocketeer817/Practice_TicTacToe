package org.example;

import org.example.controllers.GameController;
import org.example.exceptions.NotEnoughPlayersException;
import org.example.models.*;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimension of the board");
        int dimension = sc.nextInt();

        System.out.println("Enter the number of players");
        int n = sc.nextInt();

        GameController gameController = new GameController();

        List<Player> playerList = gameController.initializePlayers();

        try {

            Game game = gameController.createGame(dimension, playerList, Arrays.asList(GameWinningStrategyEnum.ORDER_ONE));

            while (game.getGameStatus() == GameStatus.IN_PROGRESS) {
                gameController.makeMove(game);
            }

            if (game.getGameStatus() == GameStatus.WIN) {
                System.out.println("The winner is " + game.getWinner().getSymbol());
            } else {
                System.out.println("The game is a draw");
            }
        }
        catch (NotEnoughPlayersException e){
            System.out.println(e.getMessage());
        }
    }

}