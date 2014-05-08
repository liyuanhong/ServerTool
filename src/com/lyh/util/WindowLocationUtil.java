package com.lyh.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WindowLocationUtil {
	public static void setWindowInScreenCenter(JFrame frame){
		int windowWidth = frame.getWidth();                     //获得窗口宽
	     int windowHeight = frame.getHeight();                   //获得窗口高       
	     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();             //获取屏幕的尺寸
	     int screenWidth = screenSize.width;                     //获取屏幕的宽
	     int screenHeight = screenSize.height;                   //获取屏幕的高
	     frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示   
	}
}
