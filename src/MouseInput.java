import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (State.getCurrentState() == Game.menuState) {
            if (mx >= MenuState.playButton.x & mx <= MenuState.playButton.x + 320 & my >= MenuState.playButton.y & my <= MenuState.playButton.y + 50) {
                State.setState(Game.gameState);
            }
            if (mx >= MenuState.quitButton.x & mx <= MenuState.quitButton.x + 180 & my >= MenuState.quitButton.y & my <= MenuState.quitButton.y + 50) {
                System.exit(1);
            }
            if (mx >= MenuState.settingsButton.x & mx <= MenuState.settingsButton.x + 180 & my >= MenuState.settingsButton.y & my <= MenuState.settingsButton.y + 50) {
                State.setState(Game.settingsState);
            }
        }
        if (State.getCurrentState() == Game.settingsState){
            if (mx >= SettingsState.fps30.x & mx <= SettingsState.fps30.x+100 & my >= SettingsState.fps30.y & my <= SettingsState.fps30.y+50){
                State.setState(Game.gameState);
            }
            if (mx >= SettingsState.fps60.x & mx <= SettingsState.fps60.x+100 & my >= SettingsState.fps60.y & my <= SettingsState.fps60.y+50){
                State.setState(Game.gameState);
            }
            if (mx >= SettingsState.fps120.x & mx <= SettingsState.fps120.x+100 & my >= SettingsState.fps120.y & my <= SettingsState.fps120.y+50){
                State.setState(Game.gameState);
            }
            if (mx >= SettingsState.back.x & mx <= SettingsState.back.x+120 & my >= SettingsState.back.y & my <= SettingsState.back.y+50){
                State.setState(Game.menuState);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {
    }
}
