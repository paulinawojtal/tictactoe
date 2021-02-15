package wojtal.paulina.tictactoe;

enum Level {

    USER("user") {
        @Override
        Player setPlayer(Symbol symbol) {
            return new HumanPlayer( "human", symbol );
        }
    }, EASY("easy") {
        @Override
        Player setPlayer(Symbol symbol) {
            return new AILevelEasyPlayer( "AIEasy", symbol );
        }
    }, MEDIUM("medium") {
        @Override
        Player setPlayer(Symbol symbol) {
            return null;
        }
    }, HARD("hard") {
        @Override
        Player setPlayer(Symbol symbol) {
            return null;
        }
    };

    private String player;

    Level( String player ) {
        this.player = player;
    }

    abstract Player setPlayer(Symbol symbol);
}
