package Input;

import Main.*;
import Player.Player;
import Stuff.SaverLoader;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

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
            if (mx >= TopState.back.x & mx <= TopState.back.x+120 & my >= TopState.back.y & my <= TopState.back.y+50){
                State.setState(Game.menuState);
            }
        }
        if (State.getCurrentState() == Game.gameState){
            if (Player.isAlive()== false){
                if (mx >= Player.getYes().x & mx <= Player.getYes().x+150 & my >= Player.getYes().y & my <= Player.getYes().y+70){
                    State.setState(Game.menuState);
                    Player.setAlive(true);
                    Player.x = 30;

                    try{
                        SaverLoader sl = new SaverLoader();
                        sl.save(String.valueOf(GameState.score));
                    }catch (IOException exp){
                        throw new RuntimeException(exp);
                    }
                    GameState.reset();
                }
                if (mx >= Player.getNo().x & mx <= Player.getNo().x+150 & my >= Player.getNo().y & my <= Player.getNo().y+70){
                    State.setState(Game.menuState);
                    Player.setAlive(true);
                    Player.x = 30;
                    GameState.reset();
                }
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
