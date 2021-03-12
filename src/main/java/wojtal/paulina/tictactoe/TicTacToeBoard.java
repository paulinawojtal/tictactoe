package wojtal.paulina.tictactoe;

import java.util.Arrays;

class TicTacToeBoard implements Board, Printer{

    private Cell[][] board;

    public TicTacToeBoard() {
        board = new Cell[3][3];
    }

    public TicTacToeBoard(String initialString) {
        board = new Cell[3][3];
        char[] array = initialString.toCharArray();

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                char symbol = array[j + i*3];
                if (symbol == '_') {
                    this.board[i][j] = null;
                } else {
                    this.board[i][j] = new Cell(new Position(i, j), Symbol.valueOf(String.valueOf(symbol)));
                }
            }
        }
    }

    @Override
    public void clearBoard() {
        Arrays.fill( board, null );
    }

    @Override
    public Cell[][] getBoard() {
        return board;
    }

    /*private*/ public void setBoard( Cell[][] board ) {
        this.board = board;
    }

    @Override
    public boolean checkIfCellHasSymbol( int firstCoordinate, int secondCoordinate, Symbol symbol ) {
        return board[firstCoordinate][secondCoordinate] == null ? false : board[firstCoordinate][secondCoordinate].getSymbol().equals( symbol );
    }

    @Override
    public int getBoardSize() {
        return board.length;
    }

    @Override
    public boolean isAnyEmptyCellOnBoard() {
        for (Cell[] a : board) {
            for (Cell c : a) {
                if (c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isThisBoardCellEmpty( int firstCoordinate, int secondCoordinate ) {
        return board[firstCoordinate][secondCoordinate] == null;
    }

    @Override
    public void makeBoardCellOccupied( int firstCoordinate, int secondCoordinate, Symbol symbol ) {

        Cell cell = new Cell( new Position( firstCoordinate, secondCoordinate ), symbol );

        board[firstCoordinate][secondCoordinate] = cell;
    }

    @Override
    public void print() {
        System.out.print("---------\n");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] == null ? "  " : board[i][j].getSymbol().toString() + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }
}
