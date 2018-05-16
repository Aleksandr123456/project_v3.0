import javafx.scene.input.MouseEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[] buttons;
<<<<<<< HEAD
    private boolean up, left, right, esc;
=======
    private boolean up, left, right,escape;
>>>>>>> ccf333c7674218d0e444bc4c1d601e0530429452

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

    public boolean escape() {
        return escape;
    }

    public boolean isRight() { return right; }


    public void update(){
        up = buttons[KeyEvent.VK_UP];
        left = buttons[KeyEvent.VK_LEFT];
        right = buttons[KeyEvent.VK_RIGHT];
<<<<<<< HEAD

        esc = buttons[KeyEvent.VK_ESCAPE];
=======
        escape = buttons[KeyEvent.VK_ESCAPE];
>>>>>>> ccf333c7674218d0e444bc4c1d601e0530429452
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