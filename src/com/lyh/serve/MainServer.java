package com.lyh.serve;

import javax.swing.JTextField;

import com.lyh.param.GlobalParam;

public class MainServer extends Thread{
	private GlobalParam global;
	private JTextField setPortText;
	private JTextField addressField;
	
	public MainServer(GlobalParam global,JTextField setPortText,JTextField addressField) {
		this.global = global;
		this.setPortText = setPortText;
		this.addressField = addressField;
	}
	
	@Override
	public void run() {
		while(true){
			if(global.getServerStatus() == 1){
				serverStart();
			}else if(global.getServerStatus() == 0){
				serverStop();
			}
		}		
	}
	
	private void serverStart(){
		System.out.println("hello world!");
	}
	
	private void serverStop(){
		return;
	}
	
	private String getAddress(){
		
		return "";
	}
}
