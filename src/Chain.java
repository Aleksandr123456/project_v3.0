import java.awt.*;

public class Chain {
    private int x, y;
    private int width = 20, height = 0;
    private int speed = 2;
    private Rectangle chain;
    private GameState game;

    public Chain(GameState game,int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;

        chain = new Rectangle(x, y,0,0);
    }

    public void update(){
        if(y < 0)
            game.getPlayer().setShotMade(false);
        else {
            y -= speed;
            height += speed;
        }
    }

    public void draw(Graphics g){
        g.drawRect(x,y,width,height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
