import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable,ActionListener{

    private Display display;
    private Thread thread;
    private boolean running;

    public int width,height;
    public String title;

    private BufferStrategy bs;
    private Graphics g;


    private BufferedImage testImage;
    private SpriteSheet sheet;

    int x = 0;
    int y = 0;


    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }


    private void init(){
        display =  new Display(title,width,height);
        Assets.init();

    }

    private void update(){
        x += 1;
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();

        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        //Cleat screen
        g.clearRect(0, 0, width, height);
        //Draw here

        g.drawImage(Assets.background,0 ,0 ,null);
        g.drawImage(Assets.player,x,y, null);

        Circle c = new Circle();
        c.setCenterX(20);
        c.setCenterY(50);
        c.setRadius(20);



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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
