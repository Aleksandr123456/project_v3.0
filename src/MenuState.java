import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.event.MouseAdapter;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class MenuState extends State {

    public static Rectangle playButton = new Rectangle(Game.width/2-160,Game.height/2-50,320,50);
    public static Rectangle settingsButton = new Rectangle(Game.width/2-90,Game.height/2+50,180,50);
    public static Rectangle quitButton = new Rectangle(Game.width/2-90, Game.height/2+150,180,50);

    public static Color color = Color.RED;

    public MenuState(Game game) {
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

        g.drawString("BUBLE TRUBLE EPIC VIDEO GAME", 120,100);
        g.drawString("Start the Game", playButton.x+10, playButton.y+40);
        g.drawString("Settings",settingsButton.x+10,settingsButton.y+40);
        g.drawString("Quit",quitButton.x+40,quitButton.y+40);

        g2d.draw(playButton);
        g2d.draw(settingsButton);
        g2d.draw(quitButton);
    }

    public static void setColor(Color color) {
        MenuState.color = color;
        System.out.println(color);
    }
    public static Color getColor() {
        return color;
    }
}
