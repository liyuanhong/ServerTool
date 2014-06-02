package com.lyh.util;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SkinManager {
	public static int DEFAULT_SKIN = 0;
	public static int WIN_SKIN = 1;
	public static int COLOR_SKIN = 2;
	public static int CIRCULAR_SKIN = 3;
	
	@SuppressWarnings("restriction")
	public static LookAndFeel getSkin(int skin){
		LookAndFeel show = new javax.swing.plaf.metal.MetalLookAndFeel();
		if(skin == DEFAULT_SKIN){
			show = new javax.swing.plaf.metal.MetalLookAndFeel();
		}else if(skin == WIN_SKIN){
			show = new com.sun.java.swing.plaf.windows.WindowsLookAndFeel();
		}else if(skin == COLOR_SKIN){
			show = new com.sun.java.swing.plaf.motif.MotifLookAndFeel();
		}else if(skin == CIRCULAR_SKIN){
			show = new javax.swing.plaf.nimbus.NimbusLookAndFeel();
		}		
		return show;
	}
	
	@SuppressWarnings("restriction")
	public static void setSkin(int skin,JFrame frame){
		LookAndFeel show = new javax.swing.plaf.metal.MetalLookAndFeel();
		if(skin == DEFAULT_SKIN){
			show = new javax.swing.plaf.metal.MetalLookAndFeel();
		}else if(skin == WIN_SKIN){
			show = new com.sun.java.swing.plaf.windows.WindowsLookAndFeel();
		}else if(skin == COLOR_SKIN){
			show = new com.sun.java.swing.plaf.motif.MotifLookAndFeel();
		}else if(skin == CIRCULAR_SKIN){
			show = new javax.swing.plaf.nimbus.NimbusLookAndFeel();
		}
		try {
			UIManager.setLookAndFeel(show);
		} catch (UnsupportedLookAndFeelException e) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(frame, "当前系统不支持此皮肤！", 
					"信息", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(frame);
	}
}
