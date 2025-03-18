package utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageComparison {
    public static boolean compareImages(String imagePath1, String imagePath2) {
        try {
            BufferedImage img1 = ImageIO.read(new File(imagePath1));
            BufferedImage img2 = ImageIO.read(new File(imagePath2));

            if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
                return false;
            }

            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
