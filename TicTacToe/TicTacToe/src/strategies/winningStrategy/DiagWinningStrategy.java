package strategies.winningStrategy;

import models.Board;
import models.Move;

public class DiagWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
