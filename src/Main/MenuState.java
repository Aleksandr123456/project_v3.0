package Main;

import java.awt.*;

public class MenuState extends State {

    public static Rectangle playButton = new Rectangle(Game.width/2-160,Game.height/2-50,320,50);
    public static Rectangle settingsButton = new Rectangle(Game.width/2-90,Game.height/2+50,180,50);
    public static Rectangle quitButton = new Rectangle(Game.width/2-90, Game.height/2+150,180,50);

    public static Color color = Color.YELLOW;

    public MenuState(Game game) {super(game); }

    public void update() {
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 50);
        g.setFont(font);
        g.setColor(color);

        g.drawString("BUBLE TRUBLE EPIC VIDEO GAME", 120,100);
        g.drawString("Start Playing", playButton.x+30, playButton.y+40);
        g.drawString("Top",settingsButton.x+50,settingsButton.y+40);
        g.drawString("Quit",quitButton.x+40,quitButton.y+40);
        g2d.draw(playButton);
        g2d.draw(settingsButton);
        g2d.draw(quitButton);
    }
}
