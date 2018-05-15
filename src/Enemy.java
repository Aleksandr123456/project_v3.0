import java.awt.*;

public abstract class Enemy {
    protected Game game;
    protected float x, y;
    protected int width, height;
    protected double speedX = 4;
    protected double speedY = 4;
    protected Rectangle enemy;

    public Enemy(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = 80;
        this.height = 80;
        this.enemy = new Rectangle(x,y,width,height);
    }

    public void update(){
        move();

    }

    public abstract void move();

    public abstract void draw(Graphics g);

    public abstract void onDeath();

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