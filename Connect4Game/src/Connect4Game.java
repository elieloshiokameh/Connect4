/* SELF ASSESSMENT
Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop.
If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify
the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods
in the Connect4Grid interface. Finally, a check is performed to determine a win.
Comment: yes

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: yes

Connect4Grid2DArray class (25 marks)
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid.
It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.
It provides as implementation of the method to check whether there is a win.
Comment: yes

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method.
Comment: yes

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: yes

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality.
Comment: yes

Total Marks out of 100: 85
*/

import java.util.Scanner;

public class Connect4Game {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Connect4Grid2DArray grid = new Connect4Grid2DArray();
        grid.emptyGrid();
        boolean typeSelected = false;
        String selection = null;
        while (!typeSelected) {
            System.out.println("Human ('h') or Computer ('c') or \"exit\" to quit?");
            if (input.hasNext("h") || input.hasNext("c") || input.hasNext("H") || input.hasNext("C") || input.hasNext("exit")) {
                selection = input.nextLine();
                typeSelected = true;
            } else {
                {
                    System.out.println("Error: Invalid Input");
                    input.nextLine();
                }
            }

            ConnectPlayer player1 = new C4HumanPlayer();
            assert selection != null;
            if(selection.equalsIgnoreCase("exit")){
                System.out.println("Ending game.");
                break;
            }
            if (selection.equalsIgnoreCase("h")) {
                ConnectPlayer player2 = new C4HumanPlayer();
            } else {
                ConnectPlayer player2 = new C4RandomAIPlayer();
            }
            boolean endGame = false;
            ConnectPlayer currentPlayer;
            int count = 0;
            while (!endGame && !grid.isGridFull()) {
                System.out.println(grid.toString());
                if (count % 2 == 0) {
                    currentPlayer = Connect4Grid2DArray.players.get(0);
                } else {
                    currentPlayer = Connect4Grid2DArray.players.get(1);
                }

                int column = currentPlayer.dropColumn();
                if (grid.isColumnFull(column)) {
                    System.out.println("Error: column full.");
                } else {
                    grid.dropPiece(currentPlayer, column);
                    count++;
                }
                if (grid.didLastPieceConnect4()) {
                    endGame = true;
                    System.out.println(grid.toString());
                    System.out.println("GAME OVER - " + currentPlayer.getPiece() + " wins.");
                }
            }
            if (grid.isGridFull()) {
                System.out.println("GAME OVER - Grid full.");
                //System.exit(1);
            }

        }
    }
}
