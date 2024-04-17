package strategies.winningStrategy;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy {
    private final Map<Integer, HashMap<Character,Integer>> colMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Character sym = move.getPlayer().getSymbol().getSym();

        if(!colMaps.containsKey(col)){
            colMaps.put(col, new HashMap<>());
        }

        Map<Character,Integer> currColMap = colMaps.get(col);
        if(!currColMap.containsKey(sym)){
            currColMap.put(sym, 0);
        }
        currColMap.put(sym, currColMap.get(sym) + 1);

        return currColMap.get(sym).equals(board.getDimension());
    }
}
