import javafx.scene.input.MouseEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[] buttons;
    private boolean up, left, right;

    public KeyManager(){
        buttons = new boolean[256];
    }

    public boolean isUp() {
        return up;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() { return right; }


    public void update(){
        up = buttons[KeyEvent.VK_UP];
        left = buttons[KeyEvent.VK_LEFT];
        right = buttons[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        buttons[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        buttons[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}