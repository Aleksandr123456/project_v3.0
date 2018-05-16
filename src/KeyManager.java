import javafx.scene.input.MouseEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[] buttons;
    private boolean up, left, right, esc;

    public KeyManager(){
        buttons = new boolean[1000];
    }

    public boolean isEsc() {
        return esc;
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

        esc = buttons[KeyEvent.VK_ESCAPE];
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