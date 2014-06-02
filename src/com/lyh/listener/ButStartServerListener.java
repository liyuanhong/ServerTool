package com.lyh.listener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lyh.param.GlobalParam;
import com.lyh.serve.MainServer;

public class ButStartServerListener extends MouseAdapter{
	private JFrame frame;
	private JButton startServiceBut; 
	private JTextField setPortText;
	private JTextField addressField;
	private JTextArea contentTextArea;
	private GlobalParam global;
	private MainServer server;
	private JTextArea logArea;
		
	public ButStartServerListener(JFrame frame, JButton startServiceBut,
			JTextField setPortText, JTextField addressField,GlobalParam global,
			JTextArea contentTextArea,JTextArea logArea) {
		this.frame = frame;
		this.startServiceBut = startServiceBut;
		this.setPortText = setPortText;
		this.addressField = addressField;
		this.contentTextArea = contentTextArea;
		this.global = global;
		this.logArea = logArea;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(startServiceBut.getText().equals("Æô¶¯")){			
			start();
		}else if(startServiceBut.getText().equals("Í£Ö¹")){
			stop();
		}		
	}
	
	private void start(){
		setPortText.setEditable(false);
		addressField.setEditable(false);
		startServiceBut.setForeground(Color.RED);
		startServiceBut.setText("Í£Ö¹");
		global.setServerStatus(1);
		server = new MainServer(global,setPortText,addressField,contentTextArea,logArea);
		addressField.setText(getAddress() + ":" + setPortText.getText());	
		global.setIPAddress(getAddress());
		server.start();
	}
	
	private void stop(){
		setPortText.setEditable(true);
		addressField.setEditable(true);
		startServiceBut.setForeground(Color.BLACK);
		addressField.setText("");
		startServiceBut.setText("Æô¶¯");
		global.setServerStatus(0);
		try {
			global.getServer().close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private String getAddress(){
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}
}
