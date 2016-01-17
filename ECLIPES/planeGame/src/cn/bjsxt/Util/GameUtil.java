package cn.bjsxt.Util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * ��Ϸ�����г��õ��ࣨ�������ͼƬ�ķ���
 * @author llf
 *
 */
public class GameUtil {
	private GameUtil(){}//������ͨ��˽��	
	public static Image getImage(String path) {
		BufferedImage bi = null;
		try {
			URL u =  GameUtil.class.getClassLoader().getResource(path);
			bi = javax.imageio.ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}
}