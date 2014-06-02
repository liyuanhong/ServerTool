package com.lyh.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import com.lyh.param.GlobalParam;

public class ReturnStyleListener extends MouseAdapter{
	private JRadioButton defaultRadio;   
	private JRadioButton specifyRadio;
	private JRadioButton noneRadio;
	private GlobalParam global;
	
	private JRadioButton radioButton;
	
	public ReturnStyleListener(JRadioButton defaultRadio,
			JRadioButton specifyRadio, JRadioButton noneRadio,GlobalParam global) {
		super();
		this.defaultRadio = defaultRadio;
		this.specifyRadio = specifyRadio;
		this.noneRadio = noneRadio;
		this.global = global;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		radioButton = (JRadioButton)e.getSource();
		if(e.getButton() == MouseEvent.BUTTON1){
			if(defaultRadio.equals(radioButton)){
				global.setResponseStye(0);
			}else if(specifyRadio.equals(radioButton)){
				global.setResponseStye(1);
			}else if(noneRadio.equals(radioButton)){
				global.setResponseStye(2);
			}			
		}
	}
}
