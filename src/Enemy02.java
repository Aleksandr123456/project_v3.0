import java.awt.*;

public class Enemy02 extends Enemy {

    public Enemy02(Game game, int x, int y){
        super(game,x,y);
    }

    public void move() {
        if(x > game.getWidth() - width | x < 0)
            speedX *= -1;
        if(y > game.getHeight() - height | y < 0)
            speedY *= -1;
        x += speedX;
        y += speedY;

        enemy.x = (int) x;
        enemy.y = (int) y;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)x,(int)y,width,height);
    }

    @Override
    public void onDeath() {

    }
}
