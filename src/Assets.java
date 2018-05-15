import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage player, background,enemy,alam_enemy;

    public static final int width1 = 1024, height1 = 512,width2 = 100, height2 = 100,width3 = 200, height3 = 196,width4 = 150, height4 = 150;

    public static void init() {
        SpriteSheet background_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/2.jpg"));
        SpriteSheet enemy_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/7.png"));
        SpriteSheet player_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/4.png"));
        SpriteSheet alamenemy_sheet = new SpriteSheet(ImageLoader.loadImage("/textures/1.png"));

        player = player_sheet.crop(0, 0, width2,height2);
        background = background_sheet.crop(0,0,width1,height1);
        enemy = enemy_sheet.crop(0,0,width3,height3);
        alam_enemy = alamenemy_sheet.crop(0,0,width4,height4);
    }
}
