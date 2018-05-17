package Main;

import Enemy.Enemy;
import Images.Assets;
import Player.Player;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GameState extends State{
    private Player player;
    private static List<Enemy> enemies = new LinkedList<>();
    private List<Enemy> newEnemies = new LinkedList<>();
    private Enemy deadEnemy;
    public static int score = 0;

    public GameState(Game game){
        super(game);
        init();
    }

    private void init(){ // loome mängu alse seisu
        player = new Player(game,200,game.getHeight() - Assets.getPlayer().getHeight());

        Enemy enemy1 = new Enemy(game,300,game.getHeight() - 100);
        Enemy enemy2 = new Enemy(game, 500, game.getHeight() - 200);
        enemies.clear();   // eelmisest mängust võiksid jääda pallid
        enemies.add(enemy1);
        enemies.add(enemy2);
    }

    @Override
    public void update() {
        if(player == null | enemies.size() == 0) // kui midagi pärast mängu seis ei laadinud
            init();

        if(enemies.size() == 0)
            System.exit(1);
        if(game.getKeyManager().isEsc())
            System.exit(1);

        player.update();
        for(Enemy enemy: enemies) // uuendame iga palli seisu
            enemy.update();

        if (player.isShotMade()) { // uuendame ahelat, kui on vaja
            player.getChain().update();

            for(Enemy enemy: enemies)   // kontrollime, kas mingi pall ja ahel puutuvad kokku
                collisionChainEnemy(player.getChain(), enemy);

            if(deadEnemy != null){  // deadEnemy on viimane pall mis ahelaga kokku puutunud
                enemies.remove(deadEnemy);  // seda pole vaja nüüd uuendada ja joonistada
                deadEnemy = null;
            }

            if(newEnemies.size() != 0){   // newEnemies on 2 palli, mis ilmuvad ühe palli kaduse pärast
                enemies.addAll(newEnemies);
                newEnemies.clear();
            }
        }
        for (Enemy enemy: enemies)  // kas mängija ja pallid puutuvad kokku
            collisionPlayerEnemy(player, enemy);

    }

    @Override
    public void draw(Graphics g) { // põhimõtteliselt sama loogika, aga joonistamiseks
        if(player == null | enemies.size() == 0)
            init();

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

    private void collisionChainEnemy(Chain.Chain chain, Enemy enemy){

        if(chain.getChain().intersects(enemy.getEnemy())){ // kuna pallil ja mängijal on oma Rectangle, võime kasutada meetodi intersect
            deadEnemy = enemy;

            newEnemies.add(new Enemy(game, (int)enemy.getX()-20, (int)enemy.getY()-30));
            newEnemies.add(new Enemy(game, (int)enemy.getX()+20, (int)enemy.getY()-30));
            newEnemies.get(0).setSpeedX(-1.5); // pöörame ühe palli

            score += 1;
            this.getPlayer().setShotMade(false);
        }
    }

    private void collisionPlayerEnemy(Player player, Enemy enemy){

        if(player.getPlayer().intersects(enemy.getEnemy())){
            Player.setAlive(false);
        }
    }

    public static void reset(){
        score = 0;
        enemies.clear();
    }
}
