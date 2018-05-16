import java.awt.*;

public class GameState extends State{
    private Player player;
    private Enemy enemy;

    public GameState(Game game){
        super(game);
        player = new Player(game,200,game.getHeight() - Assets.getPlayer().getHeight());
        enemy = new Enemy01(game,100,70);
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

    }

    @Override
    public void draw(Graphics g) {
        if(player.isShotMade())
            player.getChain().draw(g);
        player.draw(g);
        enemy.draw(g);
    }

    public Player getPlayer() {
        return player;
    }

    public void collisionChainEnemy(Chain chain, Enemy enemy){

        if(chain.getChain().intersects(enemy.getEnemy())){
            System.out.println("CHAIN HIT ENEMY");
            this.getPlayer().setShotMade(false);
        }
    }

    public void collisionPlayerEnemy(Player player, Enemy enemy){

        if(player.getPlayer().intersects(enemy.getEnemy())){
            System.out.println("ENEMY HIT HERO");
        }
    }

}
