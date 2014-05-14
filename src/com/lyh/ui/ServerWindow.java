package com.lyh.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lyh.util.WindowLocationUtil;

public class ServerWindow {
	private JFrame frame;             //this is the main frame
	private JPanel topPanel;          //this is the panel in top view
	private JLabel setPrtLabel;    
	private JTextField setPortText;     //this is the textbox for appionting port
	private JButton startService;       //this button to start the server
	
	public ServerWindow() {
		init();
	}
	
	public void init(){
		frame = new JFrame();           //set the locatoin of the main window
		frame.setSize(300, 300);		
		frame.setVisible(true);
		WindowLocationUtil.setWindowInScreenCenter(frame);
		
		topPanel = new JPanel();                             //add top view in the main window
		frame.add(topPanel,BorderLayout.SOUTH);
		topPanel.setLayout(new FlowLayout());
		
		setPrtLabel.setText("¶Ë¿Ú£º");
		topPanel.add(setPrtLabel);
	}
}
