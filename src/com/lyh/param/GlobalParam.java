package com.lyh.param;

public class GlobalParam {
	private int skin = 0;             //set the skin
	private int serverStatus = 0;     //set the server is on or off
	
	public int getServerStatus() {
		return serverStatus;
	}
	public void setServerStatus(int serverStatus) {
		this.serverStatus = serverStatus;
	}
	public int getSkin() {
		return skin;
	}
	public void setSkin(int skin) {
		this.skin = skin;
	}
	
}
