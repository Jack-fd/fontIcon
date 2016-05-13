package pers.jackfd.fonticon;

import com.google.common.math.DoubleMath;
import pers.jackfd.fonticon.generator.IBaseGenartor;
import pers.jackfd.fonticon.generator.impl.DefaultGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.RoundingMode;

/**
 * Created by MQ on 2016/4/9.
 */
public class Fonticon {

    private IBaseGenartor genartor;

    public Fonticon() {
        genartor = new DefaultGenerator();
    }

    public Fonticon(IBaseGenartor genartor) {
        this.genartor = genartor;
    }

    public BufferedImage create(String text, int size) {
        int ratio = DoubleMath.roundToInt(size / 5.0, RoundingMode.HALF_UP);
        BufferedImage identicon = new BufferedImage(ratio * 5, ratio * 5, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = identicon.getGraphics();
        graphics.setColor(genartor.getBackgroundColor()); // 背景色
        graphics.fillRect(0, 0, identicon.getWidth(), identicon.getHeight());
        graphics.setColor(genartor.getForegroundColor());
        Font font = new Font("楷体", Font.BOLD, size / text.length());
        graphics.setFont(font);
        int x = -5;
        int y = size / text.length();
        graphics.drawString(text, x, y - 30);

        return identicon;
    }
}
