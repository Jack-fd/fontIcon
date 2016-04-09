package pers.jackfd.fonticon;

import com.google.common.base.Preconditions;
import com.google.common.math.DoubleMath;
import org.apache.commons.lang3.StringUtils;
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

    private BufferedImage create(String text, int size) {
        Preconditions.checkArgument(size > 0 && StringUtils.isNotBlank(text));

        int ratio = DoubleMath.roundToInt(size / 5.0, RoundingMode.HALF_UP);

        BufferedImage identicon = new BufferedImage(ratio * 5, ratio * 5, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = identicon.getGraphics();

        graphics.setColor(genartor.getBackgroundColor()); // 背景色
        graphics.fillRect(0, 0, identicon.getWidth(), identicon.getHeight());

        graphics.setColor(genartor.getForegroundColor());

        Font font = new Font("楷体", Font.BOLD, 180);
        graphics.setFont(font);
        char c = text.toCharArray()[0];
        int x = 5;
        if (c < 127) {
            x = 50;
        }
        graphics.drawString(text, x, 165);
        return identicon;
    }
}
