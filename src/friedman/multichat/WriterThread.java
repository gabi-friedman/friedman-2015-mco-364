package friedman.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread{
	private LinkedBlockingQueue<String> lbq;
	private ArrayList<Socket> sockets;
	private String msg;

	public WriterThread(LinkedBlockingQueue<String> lbq, ArrayList<Socket> sockets) {
		this.lbq = lbq;
		this.sockets = sockets;
		
		byte b;
		
	}
	
	@Override
	public void run(){
		while(true){
			try{
				String msg = lbq.take();
				writeToSockets(msg);

			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}

	public void writeToSockets(String msg){

		synchronized(sockets){
			Iterator<Socket> iter = sockets.iterator();

			while(iter.hasNext()){
				Socket s = iter.next();
				try{
					PrintWriter pw = new PrintWriter(s.getOutputStream());
					pw.println(msg);
					pw.flush();
				} catch (IOException e) {
					iter.remove();
					e.printStackTrace();
				}
			}
		}

		//if one socket is null throws exception- outside the for loop
		//prints stack trace but x crash
		//if u hav 10 and the 5th doesnt 

	}
}
