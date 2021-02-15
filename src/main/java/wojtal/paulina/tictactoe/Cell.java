package wojtal.paulina.tictactoe;

class Cell {

    private Position position;
    private final Symbol symbol;

    public Cell( Position position, Symbol symbol ) {
        this.position = position;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
