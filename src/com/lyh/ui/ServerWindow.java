package com.lyh.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.lyh.listener.ButStartServerListener;
import com.lyh.param.GlobalParam;
import com.lyh.util.WindowLocationUtil;

public class ServerWindow {
	private Font font = new Font("幼圆", Font.BOLD, 13);
	private GlobalParam global = new GlobalParam();    //transform the parms
	
	
	private JFrame frame;             //this is the main frame
	private JPanel topPanel;          //this is the panel in top view
	private JLabel setPortLabel;    
	private JTextField setPortText;     //this is the textbox for appionting port
	private JButton startServiceBut;       //this button to start the server
	private JPanel centerPanel;         //this is the panel in the center view
	private JPanel bottonPanel;
	private JTabbedPane tabPanel;    
	private JLabel addressLabel;          
	private JTextField addressField;     //this is the textbox for showing address
	
	private JPanel tabpanePanelControl;
	   private JPanel titlePanel;
	      private JLabel controlTit;
	      private JPanel controlRadioPanel;
	      private JScrollPane contentTextScrollPane;
	      private JTextArea contentTextArea;
	   private ButtonGroup controlButGroup;
	   private JRadioButton defaultRadio;   
	   private JRadioButton specifyRadio;
	   private JRadioButton noneRadio;
	private JPanel tabpanePanelLog;
	   JScrollPane logScrollpanel;
	      JTextArea logArea;
	private JPanel tabpanePanelControl_top;
	   
	private JRadioButton defaultSkinRad;
	private JRadioButton winSkinRad;
	private JRadioButton colorSkinRad;
	private JRadioButton circularSkinRad;
	private ButtonGroup skinButtonGroup;
	
	
	public ServerWindow() {
		init();
		addListener();
	}
	
	public void init(){
		frame = new JFrame();           //set the locatoin of the main window
		frame.setSize(500, 600);		
		frame.setVisible(true);
		WindowLocationUtil.setWindowInScreenCenter(frame);
		
		topPanel = new JPanel();                             //add top view in the main window
		frame.add(topPanel,BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setPortLabel = new JLabel();            //add the port label
		setPortLabel.setText("端口：");
		setPortLabel.setFont(font);
		topPanel.add(setPortLabel);
		
		setPortText = new JTextField();          //add the port textbox  
		setPortText.setText("3030");
		setPortLabel.setFont(font);
		setPortText.setColumns(5);
		topPanel.add(setPortText);
		
		startServiceBut = new JButton("启动");  //add the start button
		topPanel.add(startServiceBut);
		
		addressLabel = new JLabel();
		addressLabel.setText("地址：");
		addressLabel.setFont(font);
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
		tabpanePanelLog.setLayout(new BorderLayout());
		tabPanel.addTab("控制", tabpanePanelControl);
		tabPanel.addTab("日志", tabpanePanelLog);
		tabPanel.setFont(font);
		centerPanel.add(tabPanel,BorderLayout.CENTER);
		bottonPanel = new JPanel();
		bottonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.add(bottonPanel,BorderLayout.SOUTH);
		
		titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(2, 1));	
		tabpanePanelControl.add(titlePanel,BorderLayout.NORTH);
		controlTit = new JLabel("设置响应方式:");
		controlRadioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		controlTit.setFont(font);
		titlePanel.add(controlTit);
		titlePanel.add(controlRadioPanel);
		
		controlButGroup = new ButtonGroup();          //add the return style radio button
		defaultRadio = new JRadioButton("默认");
		specifyRadio = new JRadioButton("指定");
		noneRadio = new JRadioButton("不返回");
		controlButGroup.add(defaultRadio);
		controlButGroup.add(specifyRadio);
		controlButGroup.add(noneRadio);
		defaultRadio.setSelected(true);		
		controlRadioPanel.add(defaultRadio);
		controlRadioPanel.add(specifyRadio);
		controlRadioPanel.add(noneRadio);
		
		contentTextScrollPane = new JScrollPane();     //add the return text area
		contentTextArea = new JTextArea();
		contentTextArea.setFont(new Font("幼圆", Font.PLAIN, 14));
		contentTextScrollPane.setViewportView(contentTextArea);
		tabpanePanelControl.add(contentTextScrollPane,BorderLayout.CENTER);
		contentTextArea.setLineWrap(true);
		
		logScrollpanel = new JScrollPane();            //add the log text box
		logArea = new JTextArea();
		logArea.setLineWrap(true);
		logArea.setEditable(false);
		logArea.setBackground(UIManager.getColor("Button.background"));
		logArea.setFont(new Font("幼圆", Font.PLAIN, 14));
		logScrollpanel.setViewportView(logArea);
		tabpanePanelLog.add(logScrollpanel,BorderLayout.CENTER);
		
		skinButtonGroup = new ButtonGroup();
		defaultSkinRad = new JRadioButton("默认皮肤");
		defaultSkinRad.setSelected(true);
		winSkinRad = new JRadioButton("windows皮肤");
		colorSkinRad = new JRadioButton("有彩皮肤");
		circularSkinRad = new JRadioButton("幼圆皮肤");
		skinButtonGroup.add(defaultSkinRad);
		skinButtonGroup.add(winSkinRad);
		skinButtonGroup.add(colorSkinRad);
		skinButtonGroup.add(circularSkinRad);
		bottonPanel.add(defaultSkinRad);
		bottonPanel.add(winSkinRad);
		bottonPanel.add(colorSkinRad);
		bottonPanel.add(circularSkinRad);
				
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowLocationUtil.setWindowInScreenCenter(frame);		
	}
	
	public void addListener(){
		startServiceBut.addMouseListener(new ButStartServerListener(frame, startServiceBut, 
				setPortText, addressField,global));
	}
}
