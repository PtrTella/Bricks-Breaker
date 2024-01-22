package brickbreaker.common;

import java.util.Arrays;

import javafx.scene.image.Image;

/**
 * Class to load the resources: map files, game icons, ranking stats.
 */
public class ImageUtils {
    
    /**
     * Method to load the json file.
     */
    public static void LoadImagers() {

        Arrays.stream(GameImages.values()).forEach(value -> {
            value.setImage(new Image(ClassLoader.getSystemResourceAsStream(value.getFilePath())));
        });

        Arrays.stream(GameObjectsImages.values()).forEach(value -> {
            value.setImage(new Image(ClassLoader.getSystemResourceAsStream(value.getFilePath())));
        });
    }

}
