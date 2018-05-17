package Main;

import Images.Assets;
import Input.KeyManager;
import Input.MouseInput;
import Stuff.Display;
import javafx.scene.media.AudioClip;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game{

    private Display display;
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

    public Game(String title){
        this.width = 1024;
        this.height = 512;
        this.title = title;

        keyManager = new KeyManager();
        mouseInput = new MouseInput();
        init();
    }


    private void init(){ // erinevate objekte initsialiseerimine
        display =  new Display(title,width,height);
        display.getCanvas().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseInput);
        Assets.init();
        
        AudioClip game_sound = new AudioClip(this.getClass().getResource("/textures/game_sound.mp3").toExternalForm());
        game_sound.setVolume(0.5);
        game_sound.play();

        menuState = new MenuState(this);
        gameState = new GameState(this);
        settingsState = new TopState(this);
        State.setState(menuState);
}

    private void update(){
        keyManager.update();
        State.getCurrentState().update();

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();

        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        // eemaldame kõike
        g.clearRect(0, 0, width, height);
        // joonistame

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

        bs.show();
        g.dispose();
    }

    public void run() {

        int fps = 60;

        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running) {   // mängu tsükkel
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

    public void start(){

        if (running)
            return;
        running = true;
        run();
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
}
