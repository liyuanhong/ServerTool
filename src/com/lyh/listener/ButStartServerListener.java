package com.lyh.listener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ButStartServerListener extends MouseAdapter{
	private JFrame frame;
	private JButton startServiceBut; 
	private JTextField setPortText;
	private JTextField addressField;
		
	public ButStartServerListener(JFrame frame, JButton startServiceBut,
			JTextField setPortText, JTextField addressField) {
		this.frame = frame;
		this.startServiceBut = startServiceBut;
		this.setPortText = setPortText;
		this.addressField = addressField;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(startServiceBut.getText().equals("Æô¶¯")){
			setPortText.setEditable(false);
			startServiceBut.setForeground(Color.RED);
			startServiceBut.setText("Í£Ö¹");
		}else if(startServiceBut.getText().equals("Í£Ö¹")){
			setPortText.setEditable(true);
			startServiceBut.setForeground(Color.BLACK);
			startServiceBut.setText("Æô¶¯");
		}		
	}
}
