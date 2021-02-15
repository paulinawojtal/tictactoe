package wojtal.paulina.tictactoe;

enum GameState {
    DRAW{
        @Override
        void endMessage() {
            System.out.println("Draw");
        }
    },
    X_WON {
        @Override
        void endMessage() {
            System.out.println("X wins");
        }
    },
    O_WON {
        @Override
        void endMessage() {
            System.out.println("O wins");
        }
    },
    NOT_FINISHED {
        @Override
        void endMessage() {
            System.out.println("Game not finished");
        }
    };

    abstract void endMessage();
}
