import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage player, background;

    public static final int width = 48, height = 48;
    public static final int width1 = 1024, height1 = 512;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/1.jpg"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/2.jpg"));

        player = sheet.crop(0, height * 2, width,height);
        background = sheet1.crop(0,0,width1,height1);
    }
}
