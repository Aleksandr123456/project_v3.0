import java.awt.*;

public class Enemy01 extends Enemy {

    public Enemy01(Game game, int x, int y){
        super(game,x,y);
        width = 20;
        height = 20;
        jumpHeight = game.getHeight()/6;
        this.enemy = new Rectangle(x,y,width,height);
    }

    @Override
    public void move() {
        if(x > game.getWidth() - width | x < 0)
            speedX *= -1;
        if(y > game.getHeight() - height | y < 0)
            speedY *= -1;
        x += speedX;

        if(y < jumpHeight)
            speedY = 0.5;
        y += speedY;
        speedY += 0.1;


        enemy.x = (int) x;
        enemy.y = (int) y;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(enemy.x,enemy.y,width,height);
    }

    @Override
    public void onDeath() {

    }
}
