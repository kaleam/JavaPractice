package strategies.winningStrategy;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    private final Map<Integer,HashMap<Character,Integer>> rowMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character sym = move.getPlayer().getSymbol().getSym();

        if(!rowMaps.containsKey(row)){
            rowMaps.put(row, new HashMap<>());
        }

        Map<Character,Integer> currRowMap = rowMaps.get(row);
        if(!currRowMap.containsKey(sym)){
            currRowMap.put(sym, 0);
        }
        currRowMap.put(sym, currRowMap.get(sym) + 1);

        return currRowMap.get(sym).equals(board.getDimension());
    }
}
