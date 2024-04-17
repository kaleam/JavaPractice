package models;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.List;

import strategies.winningStrategy.WinningStrategy;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(Builder builder) {
        this.board = new Board(builder.getDimension());
        this.players = builder.getPlayers();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = builder.getWinningStrategies();
        this.moves = new ArrayList<>();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Game build() {
            return new Game(this);
        }

    }

    public void printBoard() {
        board.printBoard();
    }

    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // check boundary conditions
        if (row < 0 || row >= board.getDimension() || col < 0 || col >= board.getDimension())
            return false;

        // check if cell is not EMPTY
        if (!board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY))
            return false;

        return true;
    }

    public void makeMove() {
        // call move method of Player/Bot
        Player currentPlayer = players.get(nextPlayerIndex);
        Move currentMove = currentPlayer.makeMove(board);

        System.out.println("This is player " + currentPlayer.getName() + "'s move ");

        // validate move
        while (!validateMove(currentMove)) {
            System.out.println("This is invalid move. Please retry the move.");
            currentMove = currentPlayer.makeMove(board);
        }

        // update cell
        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        // update moves list
        Move move = new Move(currentPlayer, cell);
        moves.add(move);

        // Update next player index
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

        // check winner
        if (checkWinner(move)) {
            winner = currentPlayer;
            gameStatus = GameStatus.ENDED;
        } else if (moves.size() == board.getDimension() * board.getDimension()) {
            gameStatus = GameStatus.DRAW;
        }
    }

    private boolean checkWinner(Move move) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

}
