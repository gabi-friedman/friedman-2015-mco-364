package friedman.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;

public class Client {

	public static void main(String [] args){
		Socket socket = null;
		try {
			socket = new Socket("192.168.1.4", 3763);
			OutputStream out = socket.getOutputStream();

			PrintWriter writer = new PrintWriter(out);
			writer.println("Hi from gabi");
			writer.flush();
			//Thread.sleep(10*1000);
			writer.println("Hi");
			writer.flush();
			//Thread.sleep(10*1000);
			writer.println("Hi");
			writer.flush();//this makes sure that the info gets sent

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally{
			IOUtils.closeQuietly(socket);
			/*try {
				if(socket!=null){
					socket.close();
				}					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

		}
	}

}
