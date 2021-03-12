package wojtal.paulina.tictactoe;

public class Position {

    private int firstCoordinate;
    private int secondCoordinate;

    public Position( int firstCoordinate, int secondCoordinate ) {
        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
    }

    @Override
    public String toString() {
        return "[" + firstCoordinate + "," + secondCoordinate + "]";
    }
}
