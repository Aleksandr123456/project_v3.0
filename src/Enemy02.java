import java.awt.*;

public class Enemy02 extends Enemy {

    public Enemy02(Game game, int x, int y){
        super(game,x,y);
        width = 30;
        height = 30;
        jumpHeight = game.getHeight()/5;
        this.color = Color.GREEN;
        this.enemy = new Rectangle(x,y,width,height);
    }
}
