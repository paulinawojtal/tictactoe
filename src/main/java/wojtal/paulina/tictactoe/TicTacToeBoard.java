package wojtal.paulina.tictactoe;

import java.util.Arrays;

class TicTacToeBoard implements Board{

    private Cell[][] board;

    public TicTacToeBoard() {
        board = new Cell[3][3];
    }

    @Override
    public void clearBoard() {
        Arrays.fill( board, null );
    }

    public Cell[][] getBoard() {
        return board;
    }

    /*private*/ public void setBoard( Cell[][] board ) {
        this.board = board;
    }

    boolean checkIfCellHasSymbol( int firstCoordinate, int secondCoordinate, Symbol symbol) {
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
}
