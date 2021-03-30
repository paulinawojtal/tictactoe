package wojtal.paulina.tictactoe;

import java.util.Random;

public class AILevelMediumPlayer implements Player{

    private final String name;
    private final Symbol symbol;
    private Board board;
    private final Random random = new Random();

    public AILevelMediumPlayer(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
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
        System.out.println("Making move level \"medium\"");

        boolean makeWinner = makeThisPlayerAWinnerIfPossible();
        if (!makeWinner) {
            boolean isBlocked = blockOpponentIfPossible();
            if (!isBlocked) {
                makeRandomMove();
            }
        }
    }



    private void makeRandomMove() {
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

    private boolean makeThisPlayerAWinnerIfPossible() {
        return checkAllRowsIfTwoInARowPlaceThird(symbol);
    }

    private boolean blockOpponentIfPossible() {
        Symbol opponentSymbol = symbol == Symbol.O ? Symbol.X : Symbol.O;

        boolean isBlockedInRows = checkAllRowsIfTwoInARowPlaceThird(opponentSymbol);
        if (!isBlockedInRows) {
            boolean isBlockedInColumns = checkAllColumnsIfTwoInAColumnPlaceThird(opponentSymbol);
            if (!isBlockedInColumns) {
                boolean isBlockedDiagonalRight = ifTwoDiagonalRightPlaceThird(opponentSymbol);
                if (!isBlockedDiagonalRight) {
                    boolean isBlockedDiagonalLeft = ifTwoDiagonalLeftPlaceThird(opponentSymbol);
                    return isBlockedDiagonalLeft;
                }
            }
        }
        return true;
    }

    private boolean checkAllColumnsIfTwoInAColumnPlaceThird(Symbol opponentOrThisPlayerSymbol) {
        int i = 0;
        boolean keepTrying = true;
        do {
            keepTrying = !ifTwoInAColumnPlaceThird(opponentOrThisPlayerSymbol, i);
            i++;
        } while (keepTrying && i < 3);
        return !keepTrying;
    }

    private boolean checkAllRowsIfTwoInARowPlaceThird(Symbol currentSymbol) {
        int i = 0;
        boolean keepTrying = true;
        do {
            keepTrying = !ifTwoInARowPlaceThird(currentSymbol, i);
            i++;
        } while (keepTrying && i < 3);
        return !keepTrying;
    }

    private boolean ifTwoInARowPlaceThird(Symbol opponentOrThisPlayerSymbol, int rowNumber) {
        if (board.checkIfCellHasSymbol(rowNumber,0, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(rowNumber, 1, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(rowNumber, 2)) {
            board.makeBoardCellOccupied(rowNumber, 2, symbol);
            return true;
        } else if (board.checkIfCellHasSymbol(rowNumber, 1, opponentOrThisPlayerSymbol )
                && board.checkIfCellHasSymbol(rowNumber, 2, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(rowNumber, 0)) {
            board.makeBoardCellOccupied(rowNumber, 0, symbol );
            return true;
        } else if (board.checkIfCellHasSymbol(rowNumber, 0, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(rowNumber, 2, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(rowNumber, 1)) {
            board.makeBoardCellOccupied(rowNumber,1, symbol);
            return true;
        }
        return false;
    }

    private boolean ifTwoInAColumnPlaceThird(Symbol opponentOrThisPlayerSymbol, int columnNumber) {
        if (board.checkIfCellHasSymbol(0, columnNumber, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(1, columnNumber, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(2, columnNumber)) {
            board.makeBoardCellOccupied(2, columnNumber, symbol);
            return true;
        } else if (board.checkIfCellHasSymbol(0, columnNumber, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(2, columnNumber, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(1, columnNumber)) {
            board.makeBoardCellOccupied( 1, columnNumber, symbol );
            return true;
        } else if (board.checkIfCellHasSymbol(1, columnNumber, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(2, columnNumber, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(0, columnNumber)) {
            board.makeBoardCellOccupied( 0, columnNumber, symbol );
            return true;
        }
        return false;
    }

    private boolean ifTwoDiagonalRightPlaceThird(Symbol opponentOrThisPlayerSymbol) {
        if (board.checkIfCellHasSymbol(0, 0, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(1, 1, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(2, 2)) {
            board.makeBoardCellOccupied(2, 2, symbol);
            return true;
        } else if (board.checkIfCellHasSymbol(0, 0, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(2, 2, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(1, 1)) {
            board.makeBoardCellOccupied( 1, 1, symbol );
            return true;
        } else if (board.checkIfCellHasSymbol(1, 1, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(2, 2, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(0, 0)) {
            board.makeBoardCellOccupied( 0, 0, symbol );
            return true;
        }
        return false;
    }

    private boolean ifTwoDiagonalLeftPlaceThird(Symbol opponentOrThisPlayerSymbol) {
        if (board.checkIfCellHasSymbol(0, 2, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(1, 1, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(2, 0)) {
            board.makeBoardCellOccupied(2, 0, symbol);
            return true;
        } else if (board.checkIfCellHasSymbol(0, 2, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(2, 0, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(1, 1)) {
            board.makeBoardCellOccupied( 1, 1, symbol );
            return true;
        } else if (board.checkIfCellHasSymbol(1, 1, opponentOrThisPlayerSymbol)
                && board.checkIfCellHasSymbol(2, 0, opponentOrThisPlayerSymbol)
                && board.isThisBoardCellEmpty(0, 2)) {
            board.makeBoardCellOccupied( 0, 2, symbol );
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + name + ", symbol: " + symbol;
    }
}