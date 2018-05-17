package Player;

import Chain.Chain;
import Images.Animation;
import Images.Assets;
import Main.Game;
import Main.GameState;
import javafx.scene.media.AudioClip;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    private Animation animationLeft;
    private Animation animationRight;

    private Game game;
    public static float x, y;
    private int width, height;
    private int speed = 4;
    private Rectangle player;

    private Chain chain;
    private boolean shotMade = false;

    private static Rectangle yes = new Rectangle(280,240,150,70);
    private static Rectangle no = new Rectangle(570,240,150,70);
    private static boolean alive = true;


    public Player(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = Assets.getPlayer().getWidth();
        this.height = Assets.getPlayer().getHeight();
        this.player = new Rectangle(x,y,width,height);

        animationLeft = new Animation(160, Assets.getPlayerRunLeft());
        animationRight = new Animation(160, Assets.getPlayerRunRight());
    }

    private void moveRight(){ // ekraani piiride kontrollimine ja liikumine
        if(x < game.getWidth() - width)
            x += speed;
    }

    private void moveLeft(){
        if(x > 0)
            x -= speed;
    }

    private void shoot() {
        if(!shotMade) {
            shotMade = true;
            chain = new Chain((GameState) game.getGameState(),(int) x, (int) y);
            AudioClip mApplause = new AudioClip(this.getClass().getResource("/textures/shoot.mp3").toExternalForm());
            mApplause.setVolume(0.2);
            mApplause.play();

        }
    }

    public void update(){
        animationLeft.update();
        animationRight.update();

        if(game.getKeyManager().isLeft()) // Kasutaja sisendi kontroll
            moveLeft();
        if(game.getKeyManager().isRight())
            moveRight();
        if(game.getKeyManager().isUp())
            shoot();
        player.x = (int) x;
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        if (alive) {
            g.drawImage(getCurrentImage(), (int) x, (int) y, null);
        }
        if (!alive) {
            x = -200;
            Font font = new Font("Serif", Font.PLAIN, 70);
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("---------------YOU LOST----------------", 0, 100);
            g.drawString("Save?",415,170);
            g.drawString("YES",280,300);
            g.drawString("NO",590,300);
            g2d.draw(yes);
            g2d.draw(no);
        }
    }

    // getterid
    public BufferedImage getCurrentImage(){
        if(game.getKeyManager().isLeft())
            return animationLeft.getCurrentImage();
        if(game.getKeyManager().isRight())
            return animationRight.getCurrentImage();
        return Assets.getPlayer();
    }
    public Chain getChain() {
        return chain;
    }

    public boolean isShotMade() {
        return shotMade;
    }

    public void setShotMade(boolean shotMade) {
        this.shotMade = shotMade;
    }

    public float getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getPlayer() {
        return player;
    }

    public static Rectangle getYes() {
        return yes;
    }

    public static Rectangle getNo() {
        return no;
    }

    public static boolean isAlive() {
        return alive;
    }

    public static void setAlive(boolean alive) {
        Player.alive = alive;
    }
}
