package com.lyh.listener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.lyh.param.GlobalParam;
import com.lyh.serve.MainServer;

public class ButStartServerListener extends MouseAdapter{
	private JFrame frame;
	private JButton startServiceBut; 
	private JTextField setPortText;
	private JTextField addressField;
	private GlobalParam global;
	private MainServer server;
		
	public ButStartServerListener(JFrame frame, JButton startServiceBut,
			JTextField setPortText, JTextField addressField,GlobalParam global) {
		this.frame = frame;
		this.startServiceBut = startServiceBut;
		this.setPortText = setPortText;
		this.addressField = addressField;
		this.global = global;
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
		server = new MainServer(global,setPortText,addressField);
		addressField.setText(getAddress() + ":" + setPortText.getText());		
		server.start();
	}
	
	private void stop(){
		setPortText.setEditable(true);
		addressField.setEditable(true);
		startServiceBut.setForeground(Color.BLACK);
		addressField.setText("");
		startServiceBut.setText("Æô¶¯");
		global.setServerStatus(0);
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
