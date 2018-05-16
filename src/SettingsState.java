import java.awt.*;

public class SettingsState extends State {

    public static Rectangle fps = new Rectangle(Game.width/2-400,Game.height/2-50,350,50);
    public static Rectangle fps30 = new Rectangle(Game.width/2+50,Game.height/2-50,100,50);
    public static Rectangle fps60 = new Rectangle(Game.width/2+200,Game.height/2-50,100,50);
    public static Rectangle fps120 = new Rectangle(Game.width/2+350,Game.height/2-50,100,50);
    public static Rectangle back = new Rectangle(0,0,120,50);

    public static Color color = Color.RED;

    public SettingsState(Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("Serif", Font.PLAIN, 50);
        g.setFont(font);
        g.setColor(color);


        g.drawString("FPS reguliration", fps.x+10, fps.y+40);
        g.drawString("30", fps30.x+25, fps30.y+40);
        g.drawString("60", fps60.x+25, fps60.y+40);
        g.drawString("120", fps120.x+10, fps120.y+40);
        g.drawString("Back", back.x+10, back.y+40);

        g2d.draw(fps);
        g2d.draw(fps30);
        g2d.draw(fps60);
        g2d.draw(fps120);
        g2d.draw(back);
    }
}
