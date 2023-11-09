import java.util.ArrayList;

public class Connect4Grid2DArray implements Connect4Grid {
    public static final int NUMBER_OF_ROWS = 6;
    public static final int NUMBER_OF_COLUMNS = 7;
    public static final char BLANK = ' ';
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    public static ArrayList<ConnectPlayer> players;
    public char[][] grid;

    public Connect4Grid2DArray() {
        grid = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        players = new ArrayList<>(2);
    }

    @Override
    public void emptyGrid() {
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                grid[i][j] = BLANK;
            }
        }
    }

    @Override
    public String toString() {
        String myString = "";
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            myString = myString + "\n| ";
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                myString += grid[i][j];
                myString = myString + " | ";
            }
            myString += ("\n------------------------------");
        }
        return myString += "\n  0   1   2   3   4   5   6 \n";
    }

    @Override
    public boolean isValidColumn(int column) {
        return (column >= 0 && column < NUMBER_OF_COLUMNS);
    }

    @Override
    public boolean isColumnFull(int column) {
        for (char[] chars : grid) {
            if (chars[column] == BLANK) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void dropPiece(ConnectPlayer player, int column) {
        if (isValidColumn(column)) {
            int row = -1;
            for (int i = 0; row == -1 && i < grid.length; i++) {
                if (grid[i][column] != BLANK) {
                    row = i - 1;
                } else if (i == grid.length - 1) {
                    row = grid.length - 1;
                }
                if (row != -1) {
                    grid[row][column] = player.getPiece();
                }
            }
        }

    }

    @Override
    public boolean didLastPieceConnect4() {
        boolean connected = false;
        int row = 0;
        int column = 1;
        char prevPosition = grid[row][column];
        int connectedPieces = 0;

        for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
//            connectedPieces = 0;
            for (int i = 0; i < NUMBER_OF_ROWS - 1; i++) {
                if (grid[i][j] == prevPosition && grid[i][j] == grid[i + 1][j] && prevPosition != BLANK) {
                    connectedPieces++;
                    if (connectedPieces == 4)
                        connected = true;
                }
            }
        }
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
//            connectedPieces = 0;
            for (int j = 0; j < NUMBER_OF_COLUMNS - 1; j++) {
                if (grid[i][j] == prevPosition && grid[i][j] == grid[i][j + 1] && prevPosition != BLANK) {
                    connectedPieces++;
                    if (connectedPieces == 4)
                        connected = true;
                }
            }
        }


        return connected;
    }

    @Override
    public boolean isGridFull() {
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                if (grid[i][j] == BLANK) {
                    return false;
                }
            }
        }
        return true;
    }
}
