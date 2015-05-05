package friedman.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread{
	private LinkedBlockingQueue<String> lbq;
	private ArrayList<Socket> sockets;
	private String msg;

	public WriterThread(LinkedBlockingQueue<String> lbq, ArrayList<Socket> sockets) {
		this.lbq = lbq;
		this.sockets = sockets;
	}

	@Override
	public void run(){
		while(true){
			try {
				msg = lbq.take();

				for(Socket socket: sockets){
					OutputStream out;
					out = socket.getOutputStream(); 
					PrintWriter pw = new PrintWriter(out);
					pw.println(msg);
					pw.flush();
				} 
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}