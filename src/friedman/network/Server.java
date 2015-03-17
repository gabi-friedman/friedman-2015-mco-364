package friedman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//server listens
	//socket = endpoints of communications 
	public static void main(String [] args){
		try {
			ServerSocket ss = new ServerSocket(3761);//listens for the Server's side of the socket

			SocketThread t;
			while (true){
				Socket s = ss.accept();//accept method returns a socket, this is a blocking call and the prog x adv til the socket is returned
				t = new SocketThread(s);
				t.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}