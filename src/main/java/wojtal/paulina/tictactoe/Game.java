package wojtal.paulina.tictactoe;

class Game {

    private final TicTacToeBoard board;
    private Round round;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final Printer printer;

    public Game(Player player1, Player player2) {
        this.board = new TicTacToeBoard();
        this.firstPlayer = player1;
        this.secondPlayer = player2;
        this.printer = new Printer();
    }

    void play() {
        printer.print( board );

        boolean keepPlaying = true;

        for (int turn = 1; turn < 10; turn++) {
            if (keepPlaying) {
                Player player = turn % 2 == 0 ? secondPlayer : firstPlayer;
                round = new Round( board, player );
                round.playOneRound();

                keepPlaying = round.evaluateGame() == GameState.NOT_FINISHED;
            }
        }
        round.evaluateGame().endMessage();
    }
}
