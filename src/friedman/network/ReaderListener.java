package friedman.network;

import java.net.Socket;

public interface ReaderListener {

	void onLineRead(String lineIn);

	void onCloseSocket(Socket s);

}
