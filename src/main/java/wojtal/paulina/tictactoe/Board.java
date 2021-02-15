package wojtal.paulina.tictactoe;

interface Board {

    void clearBoard();

    int getBoardSize();

    boolean isAnyEmptyCellOnBoard();

    boolean isThisBoardCellEmpty( int firstCoordinate, int secondCoordinate );

    void makeBoardCellOccupied( int firstCoordinate, int secondCoordinate, Symbol symbol);
}
