package friedman.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderThread extends Thread {
	private Socket socket;
	private ReaderListener rl;

	public ReaderThread(Socket socket, ReaderListener rl) {
		this.socket = socket;
		this.rl = rl;
	}

	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String msg;
			while ((msg = br.readLine()) != null) {
				rl.onLineRead(msg);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		rl.onCloseSocket(socket);
	}
}