import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

public class Game implements Runnable,ActionListener{

    private Display display;
    private Thread thread;
    private boolean running;

    public int width,height;
    public String title;

    private BufferStrategy bs;
    private Graphics g;

    private KeyManager keyManager;

<<<<<<< HEAD
    private State gameState, menuState, settingsState;
=======
    private BufferedImage testImage;
    private SpriteSheet sheet;

    int x = 0;
    int y = 0;

>>>>>>> 35661e9a5613b00c4a2d3bfaad257ca6cf3889df

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;

        keyManager = new KeyManager();
    }


    private void init(){
        display =  new Display(title,width,height);
        display.getCanvas().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(this);

        State.setState(gameState);
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

        g.drawImage(Assets.background,0 ,0 ,null);
<<<<<<< HEAD
        if(State.getCurrentState() != null )
            State.getCurrentState().draw(g);
=======
        g.drawImage(Assets.player,x,y, null);

        Circle c = new Circle();
        c.setCenterX(20);
        c.setCenterY(50);
        c.setRadius(20);


>>>>>>> 35661e9a5613b00c4a2d3bfaad257ca6cf3889df

        //End drawing
        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println(" " +ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
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

<<<<<<< HEAD
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
=======
    @Override
    public void actionPerformed(ActionEvent e) {

>>>>>>> 35661e9a5613b00c4a2d3bfaad257ca6cf3889df
    }
}
