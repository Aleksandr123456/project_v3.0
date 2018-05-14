import java.awt.*;

public class Player {
    private Game game;
    private float x, y;
    private int width, height;
    private int speed = 4;
    private Rectangle player;

    private Chain chain;
    private boolean shotMade = false;

    public Player(Game game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = Assets.player.getWidth();
        this.height = Assets.player.getHeight();
        this.player = new Rectangle(x,y,width,height);
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
        if(game.getKeyManager().isLeft())
            moveLeft();
        if(game.getKeyManager().isRight())
            moveRight();
        if(game.getKeyManager().isUp())
            shoot();

        player.x = (int) x;
    }

    public void draw(Graphics g){
        g.drawImage(Assets.player,(int) x,(int) y,null);
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
}
