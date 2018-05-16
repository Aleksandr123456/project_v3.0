import javafx.scene.shape.Circle;

import java.awt.*;

public abstract class Enemy {
    protected Game game;
    protected float x, y;
    protected int width, height;
    protected double speedX = 1.5;
    protected double speedY = 4;
    protected double jumpHeight;
    protected Rectangle enemy;
    protected Color color;
    protected Enemy child;

    public Enemy(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
    }

    public void update(){
        move();

    }

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getEnemy() {
        return enemy;
    }

    public Enemy getChild() {
        return child;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public void setEnemy(Rectangle enemy) {
        this.enemy = enemy;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setChild(Enemy child) {
        this.child = child;
    }
}

