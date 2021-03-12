package wojtal.paulina.tictactoe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AILevelMediumPlayerTest {

    static Player playerAIMedium;
    static Round oneRound;

    @BeforeAll
    static void initPlayer(){
        playerAIMedium = new AILevelMediumPlayer("medium" , Symbol.X);
    }

    @Test
    void testMakeTheMoveWhenPlayerMediumXIsAWinner() {
        Board board = new TicTacToeBoard("_XXOO_OX_");
        oneRound = new Round(board, playerAIMedium);
        playerAIMedium.setBoard(board);

        oneRound.playOneRound();
        boolean isWinner = oneRound.checkIfCurrentPlayerIsAWinner();

        assertTrue(isWinner);
    }

    @Test
    void testMakeTheMoveWhenPlayerMediumXBlocksPlayer0() {
        Board board = new TicTacToeBoard("X___X_O_O");
        oneRound = new Round(board, playerAIMedium);
        playerAIMedium.setBoard(board);

        oneRound.playOneRound();
        boolean isAppropriateSymbol = board.getBoard()[2][1].getSymbol().equals(Symbol.X);

        assertTrue(isAppropriateSymbol);
    }

    @Test
    void testMakeTheMoveWhenPlayerMediumXMakesRandomMove() {
        Board board = new TicTacToeBoard("____O__X_");
        oneRound = new Round(board, playerAIMedium);
        playerAIMedium.setBoard(board);

        oneRound.playOneRound();
        boolean isWinner = oneRound.checkIfCurrentPlayerIsAWinner();

        assertFalse(isWinner);
    }


}