package com.lyh.serve;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lyh.param.GlobalParam;

public class MainServer extends Thread{
	private GlobalParam global;
	private JTextField setPortText;
	private JTextField addressField;
	private JTextArea contentTextArea;
	private ServerSocket server;
	private Socket socket;
	private JTextArea logArea;
	
	private String IPAdress;
	private int port;
	
	
	public MainServer(GlobalParam global,JTextField setPortText,JTextField addressField,
			JTextArea contentTextArea,JTextArea logArea) {
		this.global = global;
		this.setPortText = setPortText;
		this.addressField = addressField;
		this.contentTextArea = contentTextArea;
		this.logArea = logArea;
		init();
	}
	
	@Override
	public void run() {
		while(true){
			if(global.getServerStatus() == 1){
				serverStart();				
			}else if(global.getServerStatus() == 0){
				serverStop();
				return;
			}
		}		
	}
	
	private void serverStart(){		
		try {
			global.setServer(server);
			socket = server.accept();
			global.setSocket(socket);
			
			InputStream is = socket.getInputStream();
            String line = readLine(is, socket);	
		} catch (IOException e) {
			e.printStackTrace();
		}			
		
		if(global.getResponseStye() == 0){
			defaultStyle();
		}else if(global.getResponseStye() == 1){
			specialStyle();
		}else if(global.getResponseStye() == 2){
			returnNoneStyle();
		}
	}
	
	private void serverStop(){
		try {
			global.getServer().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	//three of the response style
	private void defaultStyle(){
		try {
			String str = "";															
			
//			System.out.println(socket);
			InetSocketAddress add = (InetSocketAddress) socket.getRemoteSocketAddress();
			str = add.getAddress() + String.valueOf(add.getPort());	
			
//			System.out.println("default");			
			OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());
			output.write(str);
			output.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void specialStyle(){
		try {
			String str = "";
			str = contentTextArea.getText();
//			System.out.println("special");
			
			OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());
			output.write(str);
			output.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void returnNoneStyle(){
		try {
			String str = "";
			str = contentTextArea.getText();
//			System.out.println("none");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void init(){
		try {
			port = Integer.parseInt(setPortText.getText());
			server = new ServerSocket(port);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	
	
	
	private String readLine(InputStream is, Socket socket) throws IOException {
        byte[] readByte = new byte[1024];
        String tmpStr = "";
        int len = 0;
        int total = 0;
        
        is.read();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tmpStr = "有来自：  " + socket.getInetAddress() + "  的请求。 " + df.format(new Date()) + "\n\r";
//        while((len = is.read(readByte)) != -1){
//        	tmpStr = tmpStr + new String(readByte, 0, len);
//        }
//        System.out.println(is.read());
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        tmpStr = "log:  " + tmpStr + "  " + df.format(new Date()) + "\n\r";
        logArea.append(tmpStr);
        logArea.append("--------" + "\n\r");
		
        return "";
		
		
		
		
//		 ArrayList<Byte> lineByteList = new ArrayList<Byte>();
//	        byte readByte;
//	        int total = 0;	        
//	            do {
//	                readByte = (byte) is.read();
//	                System.out.println(readByte);
//	                lineByteList.add(Byte.valueOf(readByte));
//	            } while (readByte != 10);
//	        return "";
    }
}



