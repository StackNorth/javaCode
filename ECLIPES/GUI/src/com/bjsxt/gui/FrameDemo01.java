package com.bjsxt.gui;

import java.awt.Color;
import java.awt.Frame;
/**
 * 创建一个新的窗口
 * @author llf
 *
 */
public class FrameDemo01 {
	public static void main(String[] args) {
		Frame f = new Frame("my frist test");//建立一个窗口和名字
		f.setBackground(Color.black);//设置窗口的背景颜色
		f.setLocation(0,0);//设置窗口位置
		f.setSize(170, 200);//设置窗口大小
		f.setResizable(false);//设置是否可调节大小
		f.setVisible(true);//设置是否可见
	}
}
