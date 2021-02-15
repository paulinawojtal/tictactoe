package wojtal.paulina.tictactoe;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner( System.in );

    public static void main( String[] args ) {

        String inputCommand;
        String[] inpCommArray;

        boolean keepTrying = true;
        boolean exit = false;

        while (!exit) {
            System.out.println("Input command: >");
            inputCommand = scanner.nextLine();
            inpCommArray = inputCommand.split( " " );

            if (inpCommArray.length == 1 && inpCommArray[0].equals("exit")) {
                exit = true;
                break;
            } else if (inpCommArray.length == 3 && inpCommArray[0].equals("start")) {

                Player player1 = setPlayer( inpCommArray[1], 1 );
                Player player2 = setPlayer( inpCommArray[2], 2 );
                if (player1 != null && player2 != null) {

                    System.out.println( player1 );
                    System.out.println( player2 );
                    Game game = new Game( player1, player2 );

                    game.play();

                } else {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }

    private static Player setPlayer(String player, int playerNumber) {
        Symbol symbol = playerNumber % 2 != 0 ? Symbol.X : Symbol.O;
        switch (player) {
            case "user":
                return Level.USER.setPlayer( symbol );
            case "easy":
                return Level.EASY.setPlayer( symbol );
            default:
                return null;
        }
    }

}
