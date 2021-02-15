package wojtal.paulina.tictactoe;

import java.util.Random;

public class AILevelEasyPlayer implements Player {

    Random random = new Random();
    private String name;
    private Symbol symbol;

    public AILevelEasyPlayer( String name, Symbol symbol ) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public void makeTheMove(Board board) {
        System.out.println("Making move level \"easy\"");

        boolean keepTrying = true;

        while (keepTrying) {
            int firstCoordinate = random.nextInt(3);
            int secondCoordinate = random.nextInt(3);

            boolean isThisCellEmpty = board.isThisBoardCellEmpty( firstCoordinate, secondCoordinate );

            if (isThisCellEmpty) {
                board.makeBoardCellOccupied( firstCoordinate, secondCoordinate, symbol );
                keepTrying = false;
            }
        }

    }

    @Override
    public String toString() {
        return "" + name + ", symbol: " + symbol;
    }


}
