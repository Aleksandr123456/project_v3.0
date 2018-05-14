import java.awt.*;

public class GameState extends State{
    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game,200,game.getHeight() - Assets.player.getHeight());
    }

    @Override
    public void update() {
        player.update();
        if(player.isShotMade())
            player.getChain().update();
    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);
        if(player.isShotMade())
            player.getChain().draw(g);
    }

    public Player getPlayer() {
        return player;
    }
}
