import java.awt.*;

public class Enemy {
    private Game game;
    private float x, y;
    private int width, height;
    private double speed = 1;
    private double speed1 = 1;
    private Rectangle enemy;

    private int enemyHealt = 1;

    public Enemy(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = Assets.enemy.getWidth();
        this.height = Assets.enemy.getHeight();
        this.enemy = new Rectangle(x,y,width,height);
    }

    public void update(){
        x += speed;
        y += speed1;

        if(y >= game.getHeight() - width | y <= 0)
            speed1 *= -1;
        if(x >= game.getWidth() - width | x <= 0)
            speed *= -1;

        enemy.x = (int)x;
        enemy.y = (int)y;
    }

    public void draw(Graphics g){
        g.drawImage(Assets.enemy,(int) x,(int) y,null);
        if (enemyHealt <= 0) {
            g.drawImage(Assets.alam_enemy, (int) x, (int) y, null);

        }

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getEnemy() {
        return enemy;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getEnemyHealt() {
        return enemyHealt;
    }

    public void setEnemyHealt(int enemyHealt) {
        this.enemyHealt = enemyHealt;
    }
}