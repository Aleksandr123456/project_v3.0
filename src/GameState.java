import java.awt.*;

public class GameState extends State{
    private Player player;
    private Enemy enemy, alamenemy;

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

        if (player.isShotMade()) {
            player.getChain().update();
            collisionChainEnemy(player.getChain(), enemy);
        }
        collisionPlayerEnemy(player, enemy);

        collisionPlayerEnemy(player, enemy);
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

    public void collisionChainEnemy(Chain chain, Enemy enemy){

        if(chain.getChain().intersects(enemy.getEnemy())){
            System.out.println("CHAIN HIT ENEMY");
            enemy.setEnemyHealt(enemy.getEnemyHealt()-1);
            this.getPlayer().setShotMade(false);
        }
    }

    public void collisionPlayerEnemy(Player player, Enemy enemy){

        if(player.getPlayer().intersects(enemy.getEnemy())){
            System.out.println("ENEMY HIT HERO");
        }
    }

}
