import controllers.GameController;
import models.*;
import strategies.winningStrategy.ColWinningStrategy;
import strategies.winningStrategy.DiagWinningStrategy;
import strategies.winningStrategy.RowWinningStrategy;
import strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        int dimension = 3;

        List<Player> players = new ArrayList<>();
        players.add(new Player(new Symbol('X'), "Abhijeet", PlayerType.HUMAN));
        players.add(new Bot(new Symbol('O'), "Scaler", PlayerType.BOT, BotDiffLevel.EASY));

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagWinningStrategy()
        );

        Game game = gameController.startGame(dimension, players, winningStrategies);

        while (gameController.gameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        gameController.printBoard(game);
        if (gameController.gameStatus(game).equals(GameStatus.ENDED)) {
            System.out.println(gameController.getWinner(game).getName() + " has won the game!");
        } else {
            System.out.println("Game is Drawn!");
        }
    }
}
