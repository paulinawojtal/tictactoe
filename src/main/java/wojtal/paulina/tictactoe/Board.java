package wojtal.paulina.tictactoe;

interface Board extends Printer{

    void clearBoard();

    int getBoardSize();

    Cell[][] getBoard();

    boolean isAnyEmptyCellOnBoard();

    boolean isThisBoardCellEmpty(int firstCoordinate, int secondCoordinate);

    void makeBoardCellOccupied(int firstCoordinate, int secondCoordinate, Symbol symbol);

    boolean checkIfCellHasSymbol(int firstCoordinate, int secondCoordinate, Symbol symbol);
}
