import java.awt.*;

public class Chain {
    private int x, y;
    private int width = 5, height = 0;
    private int speed = 9;
    private Rectangle chain;
    private GameState game;
    private Player player;

    public Chain(GameState game,int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;

        player = game.getPlayer();
        chain = new Rectangle((int)(player.getX() + player.getWidth()/2 - width/2),
                y,width,0);
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
        g.setColor(Color.BLUE);
        g.fillRect(chain.x, chain.y,chain.width,chain.height + game.getPlayer().getHeight());
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
