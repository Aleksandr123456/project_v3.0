import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

public class Game{

    private Display display;
    private Thread thread;
    private boolean running;

    public static int width,height;
    public String title;

    private BufferStrategy bs;
    private Graphics g;

    private KeyManager keyManager;
    private MouseInput mouseInput;

    public static State gameState;
    public static State menuState;
    public static  State settingsState;



    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;

        keyManager = new KeyManager();
        mouseInput = new MouseInput();
    }


    private void init(){
        display =  new Display(title,width,height);
        display.getCanvas().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseInput);
        Assets.init();


        menuState = new MenuState(this);
        gameState = new GameState(this);
        settingsState = new SettingsState(this);
        State.setState(menuState);
}

    private void update(){
        keyManager.update();
        State.getCurrentState().update();

    }

    int h = 200,y = 200;
    private void render() {
        bs = display.getCanvas().getBufferStrategy();

        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0, 0, width, height);
        //Draw here

        if (State.getCurrentState() == menuState){
            g.drawImage(Assets.menu_background,0,0,null);
        }

        if (State.getCurrentState() == gameState) {
            g.drawImage(Assets.background, 0, 0, null);
        }

        if (State.getCurrentState() == settingsState){
            g.drawImage(Assets.settings_background,0,0,null);
        }
        if(State.getCurrentState() != null )
            State.getCurrentState().draw(g);

        //End drawing
        bs.show();
        g.dispose();
    }

    public void run() {

        init();
        int fps = 120;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
                delta--;
            }
        }
        System.exit(1);
    }

    public synchronized void start(){
        if (running)
            return;
        running = true;
        run();
    }

    public synchronized void stop(){
        if (!running)
            return;
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public State getGameState() {
        return gameState;
    }

    public void end(){
        running = false;
    }

}
