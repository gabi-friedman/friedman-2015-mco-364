package friedman.multichat;

import java.net.Socket;

public interface ReaderListener {

	void onLineRead(String lineIn);

	void onCloseSocket(Socket socket);

}
