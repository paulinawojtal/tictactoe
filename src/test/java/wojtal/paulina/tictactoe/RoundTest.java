package wojtal.paulina.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    static Board board;
    static Round round;
    static Player player;

    @BeforeEach
    void setUp() {
        board = new TicTacToeBoard();
        player = new HumanPlayer( "human", Symbol.O );
        round = new Round( board, player );
    }


    @Test
    void checkIfCurrentPlayerIsAWinner() {
    }

    @Test
    void checkIfCurrentPlayerIsAWinner3InARow() {
        board.makeBoardCellOccupied( 1, 0, Symbol.O );
        board.makeBoardCellOccupied( 1, 1, Symbol.O );
        board.makeBoardCellOccupied( 1, 2, Symbol.O );
        board.makeBoardCellOccupied( 0, 1, Symbol.X );
        board.makeBoardCellOccupied( 2, 0, Symbol.X );

        assertTrue( round.checkIfCurrentPlayerIsAWinner3InARow());
    }

    @Test
    void checkIfCurrentPlayerIsAWinner3InAColumn() {
        board.makeBoardCellOccupied( 0, 2, Symbol.O );
        board.makeBoardCellOccupied( 1, 2, Symbol.O );
        board.makeBoardCellOccupied( 2, 2, Symbol.O );
        board.makeBoardCellOccupied( 1, 1, Symbol.X );
        board.makeBoardCellOccupied( 0, 0, Symbol.X );

        assertTrue( round.checkIfCurrentPlayerIsAWinner3InAColumn() );
    }

    @Test
    void checkIfCurrentPlayerIsAWinnerDiagonal() {
    }

    @Test
    void checkIfCurrentPlayerIsAWinnerDiagonalRight() {
        board.makeBoardCellOccupied( 0, 0, Symbol.O );
        board.makeBoardCellOccupied( 1, 1, Symbol.O );
        board.makeBoardCellOccupied( 2, 2, Symbol.O );
        board.makeBoardCellOccupied( 0, 1, Symbol.X );
        board.makeBoardCellOccupied( 2, 0, Symbol.X );

        assertTrue( round.checkIfCurrentPlayerIsAWinnerDiagonalRight() );
    }

    @Test
    void checkIfCurrentPlayerIsAWinnerDiagonalLeft() {
        board.makeBoardCellOccupied( 0, 2, Symbol.O );
        board.makeBoardCellOccupied( 1, 1, Symbol.O );
        board.makeBoardCellOccupied( 2, 0, Symbol.O );
        board.makeBoardCellOccupied( 1, 0, Symbol.X );
        board.makeBoardCellOccupied( 2, 2, Symbol.X );

        assertTrue( round.checkIfCurrentPlayerIsAWinnerDiagonalLeft() );
    }
}