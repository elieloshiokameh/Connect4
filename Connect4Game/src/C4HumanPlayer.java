import java.util.InputMismatchException;
import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {
    public C4HumanPlayer() {
        setPiece();
        Connect4Grid2DArray.players.add(this);
    }

    @Override
    public int dropColumn() {
        Scanner playerInput = new Scanner(System.in);
        System.out.println("What column would you like to drop your piece in?");
        int playerColumn = 0;
        try {
            playerColumn = playerInput.nextInt();
            if (playerColumn >= 0 && playerColumn < 7)
                return playerColumn;
        } catch (InputMismatchException e) {
            System.out.println("Invalid column. Must be a column between 1 and 7.");
        }
        return playerColumn;
    }
}
