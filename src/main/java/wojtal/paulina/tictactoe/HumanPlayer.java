package wojtal.paulina.tictactoe;

import java.util.Scanner;

class HumanPlayer implements Player{

    private final String name;
    private final Symbol symbol;
    private final Scanner scanner = new Scanner(System.in);
    private int firstCoordinate;
    private int secondCoordinate;
    private Board board;

    public HumanPlayer(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "" + name + ", symbol " + symbol.toString();
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public void makeTheMove() {
        String coordinatesInput;
        boolean keepTrying = true;

        while (keepTrying) {
            System.out.println( "Enter the coordinates: > " );
            coordinatesInput = scanner.nextLine();

            boolean isAssignPossible = assignCoordinatesIfPossible(coordinatesInput);
            if (isAssignPossible) {
                boolean coordinatesAreInRange = checkIfCoordinatesAreInRange1to3();
                if (coordinatesAreInRange) {
                    if (board.isThisBoardCellEmpty( firstCoordinate - 1, secondCoordinate -1)) {
                        board.makeBoardCellOccupied( firstCoordinate - 1, secondCoordinate - 1, symbol );
                        keepTrying = false;
                    } else {
                        System.out.println( "This cell is occupied! Choose another one!" );
                    }
                }
            }
        }

    }

    private boolean assignCoordinatesIfPossible(String input) {
        try {
            String[] array = input.split( "\\s+" );
            firstCoordinate = Integer.parseInt( array[0] );
            secondCoordinate = Integer.parseInt( array[1] );
        } catch (RuntimeException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        return true;
    }

    private boolean checkIfCoordinatesAreInRange1to3() {
        if (firstCoordinate > 0 && firstCoordinate < 4 &&
                secondCoordinate > 0 && secondCoordinate < 4) {
            return true;
        } else {
            System.out.println( "Coordinates should be from 1 to 3!" );
            return false;
        }
    }
}
