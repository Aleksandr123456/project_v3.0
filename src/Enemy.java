import java.awt.*;

public class Enemy {
    private Game game;
    private float x, y;
    private int width, height;
    private double speed = 3;
    private double speed1 = 3;

    public Enemy(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = Assets.player.getWidth();
        this.height = Assets.player.getHeight();
    }

    public void update(){
        x += speed;
        y += speed1;

        if(y >= game.getHeight() - width)
            speed1 = speed1 * -1;
        if(y <= 0)
            speed1 = speed1 * -1;

        if(x >= game.getWidth() - width)
            speed = speed * -1;
        if(x <= 0)
            speed = speed * -1;
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
}
