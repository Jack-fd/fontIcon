package pers.jackfd.fonticon;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FonticonTest {

    @Test
    public void Imagetest() throws IOException {
        Fonticon fonticon = new Fonticon();
        BufferedImage image = fonticon.create("字", 200);
        ImageIO.write(image, "PNG", new File("c:\\test.png"));
    }
}
