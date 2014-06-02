package com.lyh.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import com.lyh.param.GlobalParam;
import com.lyh.util.SkinManager;

public class ChangeSkinListener extends MouseAdapter{
	private JRadioButton defaultSkinRad;
	private JRadioButton winSkinRad;
	private JRadioButton colorSkinRad;
	private JRadioButton circularSkinRad;
	private JFrame frame;
	private GlobalParam global;
	
	private JRadioButton radioButton;

	public ChangeSkinListener(JRadioButton defaultSkinRad,JRadioButton winSkinRad,
			JRadioButton colorSkinRad, JRadioButton circularSkinRad,
			 JFrame frame, GlobalParam global) {
		super();
		this.defaultSkinRad = defaultSkinRad;
		this.winSkinRad = winSkinRad;
		this.colorSkinRad = colorSkinRad;
		this.circularSkinRad = circularSkinRad;
		this.frame = frame;
		this.global = global;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		radioButton = (JRadioButton)e.getSource();
		if(e.getButton() == MouseEvent.BUTTON1){
			if(defaultSkinRad.equals(radioButton)){
				SkinManager.setSkin(SkinManager.DEFAULT_SKIN, frame);
			}else if(winSkinRad.equals(radioButton)){
				SkinManager.setSkin(SkinManager.WIN_SKIN, frame);
			}else if(colorSkinRad.equals(radioButton)){
				SkinManager.setSkin(SkinManager.COLOR_SKIN, frame);
			}else if(circularSkinRad.equals(radioButton)){
				SkinManager.setSkin(SkinManager.CIRCULAR_SKIN, frame);
			}
		}
	}
}
