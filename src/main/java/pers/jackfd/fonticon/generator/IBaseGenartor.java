package pers.jackfd.fonticon.generator;

import java.awt.Color;

/**
 * Created by MQ on 2016/4/9.
 */
public interface IBaseGenartor {

    /**
     * 获取图片背景色
     *
     * @return
     */
    Color getBackgroundColor();


    /**
     * 获取图案前景色
     *
     * @return
     */
    Color getForegroundColor();
}
