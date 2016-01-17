package cn.bjsxt.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * ��Ϸ�����г��õ��ࣨ�������ͼƬ�ķ���
 * @author llf
 *
 */
public class GameUtil {
	private GameUtil(){}//������ͨ��˽��	
	public static Image getImage(String path) {
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
