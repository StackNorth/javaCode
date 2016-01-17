package cn.bjsxt.test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 游戏开发中常用的类（比如加载图片的方法
 * @author llf
 *
 */
public class GameUtil {
	private GameUtil(){}//构造器通常私有	
	public static Image getImage(String path) {
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return img;
	}
}
