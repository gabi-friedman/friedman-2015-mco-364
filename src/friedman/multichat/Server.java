package friedman.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.io.IOUtils;

public class Server implements ReaderListener {

	private ServerSocket ss;
	private Socket socket;
	private ArrayList<Socket> sockets;
	private LinkedBlockingQueue<String> lbq;
	private ReaderThread rt;
	private WriterThread wt;

	public Server() throws IOException {
		ss = new ServerSocket(3232);
		sockets = new ArrayList<Socket>();

		lbq = new LinkedBlockingQueue<String>();
		wt = new WriterThread(lbq, sockets);
		wt.start();

		while (true) {
			socket = ss.accept();
			rt = new ReaderThread(socket, this);
			rt.start();
			sockets.add(socket);
		}
	}

	@Override
	public void onLineRead(String msg) {
		lbq.add(msg);
	}

	@Override
	public void onCloseSocket(Socket socket) {
		IOUtils.closeQuietly(socket);
	}
}