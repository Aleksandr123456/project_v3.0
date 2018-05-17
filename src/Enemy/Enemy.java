package Enemy;

import Main.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.*;

public class Enemy {
    private Game game;
    private float x, y;
    private int width, height;
    private double speedX = 1.5;
    private double speedY = 4;
    private Rectangle enemy;
    private List<Color> colors = new ArrayList<>();
    private Color color;

    public Enemy(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;

        this.enemy = new Rectangle(x,y,width,height); // hitbox

        colors.addAll(Arrays.asList(Color.RED,Color.GREEN,Color.CYAN,Color.BLUE,Color.MAGENTA));
        int index = (int) Math.round(Math.random()*colors.size()-1); // valime suvaliselt värvi
        if(index == -1)
            index = 0;
        this.color = colors.get(index);
    }

    public void update(){
        move();
    }

    public void move() {
        if(x > game.getWidth() - width | x < 0)     // ekraani piiride kontrollimine
            speedX *= -1;
        if(y > game.getHeight() - height | y < 0)
            speedY *= -1;
        x += speedX;

        y += speedY;
        speedY += 0.1;

        enemy.x = (int) x;    // väärtustame ristküliku koordinaate
        enemy.y = (int) y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(enemy.x,enemy.y,width,height);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Rectangle getEnemy() {
        return enemy;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }
}

