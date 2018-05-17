package Chain;

import Main.GameState;
import Player.Player;

import java.awt.*;

public class Chain {
    private int x, y;
    private int width = 5, height = 0;
    private int speed = 9;
    private Rectangle chain;
    private GameState game;
    private Player player;

    public Chain(GameState game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;

        player = game.getPlayer();
        // Ahela ristkülik, kasutame hitbox'i määramiseks
        chain = new Rectangle((int)(player.getX() + player.getWidth()/2 - width/2),
                y,width,0);
    }

    public void update(){
        if(y < 0) // ahel kadub ekraani lõppu jõudes
            game.getPlayer().setShotMade(false);
        else {
            y -= speed;
            height += speed;  // ristküliku koordinaadid algavad vasakus ülemises nurgas
        }                     // seega peame seda kõrguse muuta koos y-koordinaadiga

        chain.y = y;
        chain.height = height;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(chain.x, chain.y,chain.width,chain.height + game.getPlayer().getHeight());
    }

    public Rectangle getChain() {
        return chain;
    }
}
