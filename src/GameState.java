import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameState extends State{
    private Player player;
    private List<Enemy> enemies = new LinkedList<>();
    private List<Enemy> newEnemies = new LinkedList<>();
    private Enemy deadEnemy;
    public static int score = 0;

    public GameState(Game game){
        super(game);
        player = new Player(game,200,game.getHeight() - Assets.getPlayer().getHeight());

        Enemy enemy1 = new Enemy(game,getRandomXPos(),game.getHeight() - 100);
        Enemy enemy2 = new Enemy(game, getRandomXPos(), game.getHeight() - 200);
        enemies.add(enemy1);
        enemies.add(enemy2);
    }

    @Override
    public void update() {
        if(enemies.size() == 0)
            System.exit(1);
        if(game.getKeyManager().isEsc())
            System.exit(1);

        player.update();
        for(Enemy enemy: enemies)
            enemy.update();

        if (player.isShotMade()) {
            player.getChain().update();

            for(Enemy enemy: enemies)
                collisionChainEnemy(player.getChain(), enemy);

            if(deadEnemy != null){
                enemies.remove(deadEnemy);
                deadEnemy = null;
            }

            if(newEnemies.size() != 0){
                enemies.addAll(newEnemies);
                newEnemies.clear();
            }
        }
        for (Enemy enemy: enemies)
            collisionPlayerEnemy(player, enemy);

    }

    @Override
    public void draw(Graphics g) {

        if(player.isShotMade())
            player.getChain().draw(g);

        player.draw(g);

        for(Enemy enemy: enemies)
            enemy.draw(g);

        Font font = new Font("Serif", Font.PLAIN, 50);
        g.setFont(font);
        g.setColor(Color.CYAN);
        g.drawString("Score " + score, 0,50);

    }

    public Player getPlayer() {
        return player;
    }

    private void collisionChainEnemy(Chain chain, Enemy enemy){

        if(chain.getChain().intersects(enemy.getEnemy())){
            deadEnemy = enemy;

            newEnemies.add(new Enemy(game, (int)enemy.getX()-40, (int)enemy.getY()-20));
            newEnemies.add(new Enemy(game, (int)enemy.getX()+40, (int)enemy.getY()-20));
            newEnemies.get(0).setSpeedX(-1.5);

            score += 1;
            this.getPlayer().setShotMade(false);
        }
    }

    private void collisionPlayerEnemy(Player player, Enemy enemy){

        if(player.getPlayer().intersects(enemy.getEnemy())){
            System.out.println("DEAD");
            Player.alive = false;
            System.out.println("ENEMY HIT HERO");
        }
    }

    private int getRandomXPos(){
        return (int) Math.round(Math.random()*game.getWidth());
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
