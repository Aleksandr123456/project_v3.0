import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private Display display;
    private Thread thread;
    private boolean running;

    public int width,height;
    public String title;

    private BufferStrategy bs;
    private Graphics g;

    private KeyManager keyManager;

    private State gameState, menuState, settingsState;

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
        if(State.getCurrentState() != null )
            State.getCurrentState().draw(g);

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


        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
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

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
