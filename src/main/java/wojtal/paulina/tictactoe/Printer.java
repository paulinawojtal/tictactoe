package wojtal.paulina.tictactoe;

class Printer {

    public void print( TicTacToeBoard board) {

        System.out.print("---------\n");
        for (int i = 0; i < board.getBoard().length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                System.out.print(board.getBoard()[i][j] == null ? "  " : board.getBoard()[i][j].getSymbol().toString() + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }
}
