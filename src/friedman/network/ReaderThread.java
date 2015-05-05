package friedman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.sun.xml.internal.ws.api.pipe.Fiber.Listener;

public class ReaderThread extends Thread{
	//want to read individual lines from our socket and do something with them
	private Socket s;
	private ReaderListener l;

	public ReaderThread(Socket s, ReaderListener l) {
		this.s = s;
		this.l = l;
	}

	@Override
	public void run() {
		try {
			InputStream in = s.getInputStream();
			
			OutputStream out = s.getOutputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));//gives u strings as opposed to bytes			
			PrintWriter writer = new PrintWriter(out);

			String lineIn;
			while((lineIn = reader.readLine()) != null){
				l.onLineRead(lineIn);
			}
			l.onCloseSocket(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//gets bytes

	}
}
