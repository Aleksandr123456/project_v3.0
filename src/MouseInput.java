import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mx >= MenuState.playButton.x & mx <= MenuState.playButton.x+320 & my >= MenuState.playButton.y & my <= MenuState.playButton.y+50){
            State.setState(Game.gameState);
        }
        if (mx >= MenuState.quitButton.x & mx <= MenuState.quitButton.x+180 & my >= MenuState.quitButton.y & my <= MenuState.quitButton.y+50){
            System.exit(1);
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
