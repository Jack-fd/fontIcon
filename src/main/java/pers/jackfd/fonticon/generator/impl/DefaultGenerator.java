package pers.jackfd.fonticon.generator.impl;

import com.google.common.collect.Lists;
import pers.jackfd.fonticon.generator.IBaseGenartor;

import java.awt.*;
import java.util.List;

/**
 * Created by MQ on 2016/4/9.
 */
public class DefaultGenerator implements IBaseGenartor {

    private static List<Color> colorList = Lists.newArrayList();

    static {
        colorList.add(new Color(255, 148, 62));
        colorList.add(new Color(246, 191, 38));
        colorList.add(new Color(246, 94, 141));
        colorList.add(new Color(246, 94, 94));
        colorList.add(new Color(197, 203, 99));
        colorList.add(new Color(189, 132, 205));
        colorList.add(new Color(161, 136, 127));
        colorList.add(new Color(120, 192, 110));
        colorList.add(new Color(120, 145, 157));
        colorList.add(new Color(94, 201, 246));
        colorList.add(new Color(94, 151, 246));
        colorList.add(new Color(92, 107, 192));
        colorList.add(new Color(59, 194, 181));
    }

    @Override
    public Color getBackgroundColor() {
        int random = (int) (Math.random() * colorList.size());
        Color color = colorList.get(random);
        if (color == null) {
            color = getBackgroundColor();
        }
        return color;
    }

    @Override
    public Color getForegroundColor() {
        return new Color(255, 255, 255);
    }
}
