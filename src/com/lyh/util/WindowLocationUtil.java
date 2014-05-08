package com.lyh.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WindowLocationUtil {
	public static void setWindowInScreenCenter(JFrame frame){
		int windowWidth = frame.getWidth();                     //��ô��ڿ�
	     int windowHeight = frame.getHeight();                   //��ô��ڸ�       
	     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();             //��ȡ��Ļ�ĳߴ�
	     int screenWidth = screenSize.width;                     //��ȡ��Ļ�Ŀ�
	     int screenHeight = screenSize.height;                   //��ȡ��Ļ�ĸ�
	     frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ   
	}
}
