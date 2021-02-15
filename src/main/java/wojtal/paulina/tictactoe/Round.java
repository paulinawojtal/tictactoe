package wojtal.paulina.tictactoe;

class Round {

    private final TicTacToeBoard board;
    private final Printer printer;
    private final Player player;
    private final Symbol playerSymbol;

    Round( TicTacToeBoard board , Player player) {
        this.board = board;
        this.printer = new Printer();
        this.player = player;
        playerSymbol = player.getSymbol();
    }

    void playOneRound() {
        player.makeTheMove( board );
        printer.print( board );
    }

    GameState evaluateGame() {
        if (checkIfCurrentPlayerIsAWinner()) {
            switch (playerSymbol) {
                case O:
                    return GameState.O_WON;
                case X:
                    return GameState.X_WON;
            }
        } else if (!board.isAnyEmptyCellOnBoard()) {
            return GameState.DRAW;
        }
        return GameState.NOT_FINISHED;
    }

    boolean checkIfCurrentPlayerIsAWinner() {
        return checkIfCurrentPlayerIsAWinner3InARow() ||
                checkIfCurrentPlayerIsAWinner3InAColumn() ||
                checkIfCurrentPlayerIsAWinnerDiagonal();
    }

    /*private*/ boolean checkIfCurrentPlayerIsAWinner3InARow() {

        for (int row = 0; row < 3; row++) {
            if (board.checkIfCellHasSymbol(row,0,playerSymbol) &&
                    board.checkIfCellHasSymbol( row,1,playerSymbol ) &&
                    board.checkIfCellHasSymbol( row,2,playerSymbol )) {
                return true;
            }
        }
        return false;
    }

    /*private*/ boolean checkIfCurrentPlayerIsAWinner3InAColumn() {

        for (int col = 0; col < 3; col++) {
            if (board.checkIfCellHasSymbol( 0, col, playerSymbol ) &&
                    board.checkIfCellHasSymbol( 1, col, playerSymbol ) &&
                    board.checkIfCellHasSymbol( 2, col, playerSymbol )) {
                return true;
            }
        }
        return false;
    }

    /*private*/ boolean checkIfCurrentPlayerIsAWinnerDiagonal() {
        return checkIfCurrentPlayerIsAWinnerDiagonalRight() ||
                checkIfCurrentPlayerIsAWinnerDiagonalLeft();
    }

    /*private*/ boolean checkIfCurrentPlayerIsAWinnerDiagonalRight() {
        return board.checkIfCellHasSymbol( 0,0,playerSymbol ) &&
                board.checkIfCellHasSymbol( 1,1,playerSymbol ) &&
                board.checkIfCellHasSymbol( 2,2,playerSymbol );
    }

    /*private*/ boolean checkIfCurrentPlayerIsAWinnerDiagonalLeft() {
        return board.checkIfCellHasSymbol( 0,2, playerSymbol ) &&
                board.checkIfCellHasSymbol( 1,1, playerSymbol ) &&
                board.checkIfCellHasSymbol( 2,0, playerSymbol );
    }
}
