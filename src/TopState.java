import java.awt.*;
import java.io.IOException;

public class TopState extends State {

    public static Rectangle top = new Rectangle(Game.width/2-200,Game.height/2-150,430,50);
    public static Rectangle back = new Rectangle(0,0,120,50);

    public static Color color = Color.RED;

    private String score;

    public TopState(Game game){
        super(game);
        try{
            SaverLoader sl = new SaverLoader();
            score = sl.load();
        }catch (IOException exp){
            throw new RuntimeException(exp);
        }
    }

    public void update() { }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 50);
        g.setFont(font);
        g.setColor(color);
        g.drawString("Best score: " + score, 200,300);
        g.drawString("TOP PLAYERS EU", top.x+10, top.y+40);
        g.drawString("Back", back.x+10, back.y+40);
        g2d.draw(top);
        g2d.draw(back);
    }
}
