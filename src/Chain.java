import java.awt.*;

public class Chain {
    private int x, y;
    private int width = 20, height = 0;
    private int speed = 4;
    private Rectangle chain;
    private GameState game;

    public Chain(GameState game,int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;

        chain = new Rectangle(x, y,width,0);
    }

    public void update(){
        if(y < 0)
            game.getPlayer().setShotMade(false);
        else {
            y -= speed;
            height += speed;
        }

        chain.y = y;
        chain.height = height;
    }

    public void draw(Graphics g){

        g.fillRect(chain.x+40,
                chain.y+40,chain.width,chain.height + game.getPlayer().getHeight());
        
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getChain() {
        return chain;
    }
}
