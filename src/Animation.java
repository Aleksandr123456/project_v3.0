import java.awt.image.BufferedImage;

public class Animation {
    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] images;

    public Animation(int speed, BufferedImage[] images){
        this.speed = speed;
        this.images = images;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index++;
            timer = 0;
            if(index >= images.length)
                index = 0;
        }
    }

    public BufferedImage getCurrentImage() {
        return images[index];
    }
}
