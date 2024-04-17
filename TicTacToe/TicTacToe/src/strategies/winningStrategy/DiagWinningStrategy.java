package strategies.winningStrategy;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagWinningStrategy implements WinningStrategy {
    private final Map<Character, Integer> leftToRightDiagMap = new HashMap<>();
    private final Map<Character, Integer> rightToLeftDiagMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character sym = move.getPlayer().getSymbol().getSym();

        if (row == col) {
            if (!leftToRightDiagMap.containsKey(sym)) {
                leftToRightDiagMap.put(sym, 0);
            }
            leftToRightDiagMap.put(sym, leftToRightDiagMap.get(sym) + 1);

            return leftToRightDiagMap.get(sym).equals(board.getDimension());
        }

        if (row + col == board.getDimension() - 1) {
            if (!rightToLeftDiagMap.containsKey(sym)) {
                rightToLeftDiagMap.put(sym, 0);
            }
            rightToLeftDiagMap.put(sym, rightToLeftDiagMap.get(sym) + 1);
            return rightToLeftDiagMap.get(sym).equals(board.getDimension());
        }
        
        return false;
    }
}
