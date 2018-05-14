import java.awt.*;

public class Enemy {
    private Game game;
    private float x, y;
    private int width, height;
    private double speed = 1;
    private double speed1 = 1;
    private Rectangle enemy;

    public Enemy(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = Assets.player.getWidth();
        this.height = Assets.player.getHeight();
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
        g.drawImage(Assets.player,(int) x,(int) y,null);
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
}
