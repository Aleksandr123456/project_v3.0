import java.awt.*;

public class GameState extends State{
    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game,200,100);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);
    }
}
