import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage background, menu_background,settings_background;
    private static BufferedImage[] playerRunLeft;
    private static BufferedImage[] playerRunRight;
    private static BufferedImage player;

    public static void init() {
        SpriteSheet playerImages = new SpriteSheet(ImageLoader.loadImage("/textures/player_animation.png"));

        playerRunLeft = new BufferedImage[6];
        playerRunLeft[0] = playerImages.crop(30,0,30,70);
        playerRunLeft[1] = playerImages.crop(60,0,60,70);
        playerRunLeft[2] = playerImages.crop(120,0,30,70);
        playerRunLeft[3] = playerImages.crop(150,0,30,70);
        playerRunLeft[4] = playerImages.crop(180,0,60,70);
        playerRunLeft[5] = playerImages.crop(240,0,30,70);

        playerRunRight = new BufferedImage[6];
        playerRunRight[0] = playerImages.crop(30,70,30,70);
        playerRunRight[1] = playerImages.crop(60,70,60,70);
        playerRunRight[2] = playerImages.crop(120,70,30,70);
        playerRunRight[3] = playerImages.crop(150,70,30,70);
        playerRunRight[4] = playerImages.crop(180,70,60,70);
        playerRunRight[5] = playerImages.crop(240,70,30,70);

        player = playerImages.crop(0,0,30,70);
        background = ImageLoader.loadImage("/textures/back01.jpg");
        menu_background = ImageLoader.loadImage("/textures/menu_back.jpg");
        settings_background = ImageLoader.loadImage("/textures/settings_back.jpg");
    }

    public static BufferedImage getPlayer() {
        return player;
    }

    public static BufferedImage[] getPlayerRunLeft() {
        return playerRunLeft;
    }

    public static BufferedImage[] getPlayerRunRight() {
        return playerRunRight;
    }
}
