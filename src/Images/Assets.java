package Images;

import Stuff.GameCrashException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Assets {

    public static BufferedImage background, menu_background,settings_background;
    private static BufferedImage[] playerRunLeft;
    private static BufferedImage[] playerRunRight;
    private static BufferedImage player;

    public static void init() {

        BufferedImage playerImages = loadImage("/textures/player_animation.png");

        playerRunLeft = new BufferedImage[6];   // loome listi liikumise piltidega
        playerRunLeft[0] = crop(playerImages,30,0,30,70);
        playerRunLeft[1] = crop(playerImages,60,0,60,70);
        playerRunLeft[2] = crop(playerImages,120,0,30,70);
        playerRunLeft[3] = crop(playerImages,150,0,30,70);
        playerRunLeft[4] = crop(playerImages,180,0,60,70);
        playerRunLeft[5] = crop(playerImages,240,0,30,70);

        playerRunRight = new BufferedImage[6];
        playerRunRight[0] = crop(playerImages,30,70,30,70);
        playerRunRight[1] = crop(playerImages,60,70,60,70);
        playerRunRight[2] = crop(playerImages,120,70,30,70);
        playerRunRight[3] = crop(playerImages,150,70,30,70);
        playerRunRight[4] = crop(playerImages,180,70,60,70);
        playerRunRight[5] = crop(playerImages,240,70,30,70);

        player = crop(playerImages,0,0,30,70);
        background = loadImage("/textures/back02.jpg");
        menu_background = loadImage("/textures/menu_back.jpg");
        settings_background = loadImage("/textures/settings_back.jpg");
    }
    // CROP lõigab osa pildist
    private static BufferedImage crop(BufferedImage image, int x, int y, int width, int height){
        return image.getSubimage(x, y, width, height);
    }

    private static BufferedImage loadImage(String path){

        try {
            return ImageIO.read(Assets.class.getResource(path));
        } catch (IOException e) {
            throw new GameCrashException("Game Crashed. Images?");
        }
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
