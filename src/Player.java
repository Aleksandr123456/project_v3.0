import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    private Animation animationLeft;
    private Animation animationRight;

    private Game game;
    private float x, y;
    private int width, height;
    private int speed = 4;
    private Rectangle player;
    private int playerHealth = 3;

    private Chain chain;
    private boolean shotMade = false;

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

    private void moveRight(){
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
        }
    }

    public void update(){
        animationLeft.update();
        animationRight.update();

        if(game.getKeyManager().isLeft())
            moveLeft();
        if(game.getKeyManager().isRight())
            moveRight();
        if(game.getKeyManager().isUp())
            shoot();

        player.x = (int) x;
    }

    public void draw(Graphics g){
        g.drawImage(getCurrentImage(),(int) x,(int) y,null);
    }

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

    public float getY() {
        return y;
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

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerHealth() {

        return playerHealth;
    }
}
