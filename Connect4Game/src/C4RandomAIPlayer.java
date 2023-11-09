public class C4RandomAIPlayer extends ConnectPlayer {
    public C4RandomAIPlayer() {
        setPiece();
        Connect4Grid2DArray.players.add(this);
    }

    @Override
    public int dropColumn() {
        return (int) Math.round(Math.random() * 6);
    }


}
