package com.lyh.param;

import java.net.ServerSocket;
import java.net.Socket;

public class GlobalParam {
	private int skin = 0;             //set the skin
	private int serverStatus = 0;     //set the server is on or off
	private int responseStye = 0;     //0 (default) 1(special) 2(return nothing)
	private String IPAddress = "127.0.0.1";
	private Socket socket;
	private ServerSocket server;
	
	public ServerSocket getServer() {
		return server;
	}
	public void setServer(ServerSocket server) {
		this.server = server;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public int getResponseStye() {
		return responseStye;
	}
	public void setResponseStye(int responseStye) {
		this.responseStye = responseStye;
	}
	public int getServerStatus() {
		return serverStatus;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
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
