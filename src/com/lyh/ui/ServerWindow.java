package com.lyh.ui;

import javax.swing.JFrame;

import com.lyh.util.WindowLocationUtil;

public class ServerWindow {
	private JFrame frame;             //this is the main frame
	
	public ServerWindow() {
		init();
	}
	
	public void init(){
		frame = new JFrame();
		frame.setSize(300, 300);		
		frame.setVisible(true);
		WindowLocationUtil.setWindowInScreenCenter(frame);
	}
}
