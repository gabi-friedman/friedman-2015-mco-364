package friedman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SocketThread extends Thread {
	private Socket s;

	public SocketThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			InputStream in;
			in = s.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));//gives u strings as opposed to bytes			

			String line;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//gets bytes

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
