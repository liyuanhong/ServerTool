package com.lyh.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.lyh.util.WindowLocationUtil;

public class ServerWindow {
	private String startSerButText = "启动";
	
	
	private JFrame frame;             //this is the main frame
	private JPanel topPanel;          //this is the panel in top view
	private JLabel setPortLabel;    
	private JTextField setPortText;     //this is the textbox for appionting port
	private JButton startServiceBut;       //this button to start the server
	private JPanel centerPanel;         //this is the panel in the center view
	private JTabbedPane tabPanel;    
	private JLabel addressLabel;          
	private JTextField addressField;     //this is the textbox for showing address
	
	private JPanel tabpanePanelControl;
	private JPanel tabpanePanelLog;
	
	public ServerWindow() {
		init();
	}
	
	public void init(){
		frame = new JFrame();           //set the locatoin of the main window
		frame.setSize(500, 400);		
		frame.setVisible(true);
		WindowLocationUtil.setWindowInScreenCenter(frame);
		
		topPanel = new JPanel();                             //add top view in the main window
		frame.add(topPanel,BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout());
		
		setPortLabel = new JLabel();            //add the port label
		setPortLabel.setText("端口：");
		topPanel.add(setPortLabel);
		
		setPortText = new JTextField();          //add the port textbox  
		setPortText.setText("3030");
		setPortText.setColumns(5);
		topPanel.add(setPortText);
		
		startServiceBut = new JButton(startSerButText);  //add the start button
		topPanel.add(startServiceBut);
		
		addressLabel = new JLabel();
		addressLabel.setText("地址：");
		topPanel.add(addressLabel);
		
		addressField = new JTextField();                //add the address testbox
		addressField.setEditable(false);
		addressField.setColumns(20);
		topPanel.add(addressField);
		
		centerPanel = new JPanel();                    //add the center panel
		centerPanel.setLayout(new BorderLayout());
		frame.add(centerPanel,BorderLayout.CENTER);
			
		tabPanel = new JTabbedPane(JTabbedPane.TOP);    //add the tabpanel
		tabpanePanelControl = new JPanel();
		tabpanePanelLog = new JPanel();
		tabpanePanelControl.setLayout(new BorderLayout());
		tabPanel.addTab("控制", tabpanePanelControl);
		tabPanel.addTab("日志", tabpanePanelLog);
		centerPanel.add(tabPanel,BorderLayout.CENTER);
		
		frame.setVisible(true);
		WindowLocationUtil.setWindowInScreenCenter(frame);
	}
}
