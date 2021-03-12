package wojtal.paulina.tictactoe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {

    static TicTacToeBoard board;

    @BeforeAll
    public static void setBoard(){
        Cell cell1 = new Cell( new Position( 0, 0 ), Symbol.O );
        Cell cell2 = new Cell( new Position( 1, 0 ), Symbol.X );
        Cell cell3 = new Cell( new Position( 1, 1 ), Symbol.X );
        Cell cell4 = new Cell( new Position( 1, 2 ), Symbol.X );
        Cell cell5 = new Cell( new Position( 0, 2 ), Symbol.O );

        Cell[][] cells = new Cell[3][3];
        cells[0][0] = cell1;
        cells[1][0] = cell2;
        cells[1][1] = cell3;
        cells[1][2] = cell4;
        cells[0][2] = cell5;

        board = new TicTacToeBoard();
        board.setBoard( cells );
    }
    @Test
    void clearBoard() {
    }

    @Test
    void isAnyEmptyCellOnBoard1() {
        assertTrue(board.isAnyEmptyCellOnBoard());
    }

    @Test
    void isAnyEmptyCellOnBoard2() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board.makeBoardCellOccupied( row, col, Symbol.X );
            }
        }
        assertFalse(board.isAnyEmptyCellOnBoard());
    }

    @Test
    void isThisBoardCellEmpty11() {
        assertFalse( board.isThisBoardCellEmpty( 1,1 ) );
    }

    @Test
    void isThisBoardCellEmpty00() {
        assertFalse( board.isThisBoardCellEmpty( 0,0 ) );
    }

    @Test
    void isThisBoardCellEmpty01() {
        board.getBoard()[0][1] = null;
        assertTrue( board.isThisBoardCellEmpty( 0,1 ) );
    }

    @Test
    void makeBoardCellOccupied() {
        board.makeBoardCellOccupied( 2, 0, Symbol.O );
        assertFalse( board.isThisBoardCellEmpty( 2,0 ) );
    }

    @Test
    void checkIfCellHasSymbolTest1() {

        assertAll(
                () -> assertTrue( board.checkIfCellHasSymbol( 1,1, Symbol.X )),
                () -> assertFalse( board.checkIfCellHasSymbol( 0,2, Symbol.O ))
        );
    }
}