package wojtal.paulina.tictactoe;

public interface Player {

    Symbol getSymbol();

    void setBoard(Board board);

    void makeTheMove();

}
