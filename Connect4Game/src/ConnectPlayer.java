public abstract class ConnectPlayer {
    private char piece;

    void setPiece() {
        if (Connect4Grid2DArray.players.size() > 0) {
            this.piece = Connect4Grid2DArray.PLAYER_X;
        } else {
            this.piece = Connect4Grid2DArray.PLAYER_O;
        }
    }

    public char getPiece() {
        return this.piece;
    }

    ;

    public abstract int dropColumn();
}
