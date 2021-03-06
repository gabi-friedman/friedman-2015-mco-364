package friedman.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class ChatServer implements ReaderListener{

	private Socket socket;

	public ChatServer(JTextArea textArea) {

		try {
			//client = new Socket("192.168.1.6", 3762);
			
			ServerSocket serverSocket = new ServerSocket(6003); // port num sent
			socket = serverSocket.accept();
			ReaderThread thread = new ReaderThread(socket,textArea,this);
			thread.start();
			/*
			//client = new Socket("localhost", 3762);
			// in
				InputStream in = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
					textArea.append(line+"\n");
				}
*/
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void recieveMessages(){
		
	
	}
	public void sendText(String text) throws IOException {

		OutputStream out = socket.getOutputStream();

		PrintWriter writer = new PrintWriter(out);

		writer.println(text);

		writer.flush();

	}

	@Override
	public void onLineRead(String lineIn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCloseSocket(Socket s) {
		// TODO Auto-generated method stub
		
	}
}