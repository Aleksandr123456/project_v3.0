import java.awt.*;

public class Enemy01 extends Enemy {

    public Enemy01(Game game, int x, int y){
        super(game,x,y);
        width = 20;
        height = 20;
        jumpHeight = game.getHeight()/6;
        this.color = Color.RED;
        this.enemy = new Rectangle(x,y,width,height);
    }

}
