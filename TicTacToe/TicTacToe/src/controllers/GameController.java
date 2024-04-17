package controllers;

import models.Game;
import models.GameStatus;
import models.Player;
import strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimensions, List<Player> players, List<WinningStrategy> winningStrategies){
        return Game.getBuilder()
                .setDimension(dimensions)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){
        //TODO
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public GameStatus gameStatus(Game game){
        return game.getGameStatus();
    }
}
