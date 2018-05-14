import java.awt.*;

public class GameState extends State{
    private Player player;
    private Enemy enemy;

    private boolean isRunning = true;

    public GameState(Game game){
        super(game);
        player = new Player(game,200,game.getHeight() - Assets.player.getHeight());
        enemy = new Enemy(game,100,70);
    }

    @Override
    public void update() {
        player.update();
        enemy.update();
        if (player.isShotMade())
            player.getChain().update();
        
        check(player.getX(),enemy.getX(),player.getY(),enemy.getY());

    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);
        enemy.draw(g);
        if(player.isShotMade())
            player.getChain().draw(g);
    }

    public Player getPlayer() {
        return player;
    }

    public void check(float playerX, float enemyX, float playerY, float enemyY){
        if ((enemyY > playerY - 24 && enemyX > playerX - 24 && enemyX < playerX+24)) {
            Game.end();
        }
    }
}
