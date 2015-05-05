package friedman.multichat;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.io.IOUtils;

public class Client extends JFrame implements ReaderListener {
	private static final long serialVersionUID = 1L;
	private JTextArea area;
	private JTextArea text;
	private Socket socket;
	private ReaderThread rt;

	public Client() throws UnknownHostException, IOException {
		setTitle("Chat");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		area = new JTextArea();
		area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area);
		add(scroll, BorderLayout.CENTER);

		text = new JTextArea();
		text.setLineWrap(true);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
					case KeyEvent.VK_ENTER:
						try {
							OutputStream out = socket.getOutputStream();
							PrintWriter writer = new PrintWriter(out);
							String msg = text.getText();
							writer.println(msg);
							writer.flush();
						}
						catch (IOException e1) {
							e1.printStackTrace();
						}
					break;
				}
			}
		});
		add(text, BorderLayout.SOUTH);

		socket = new Socket("localhost", 3232);
		rt = new ReaderThread(socket, this);
		rt.start();
		setVisible(true);
	}

	@Override
	public void onLineRead(String msg){
		if (!area.getText().equals("")) {
			area.append("\n");
		}
		area.append(msg);
		text.setText("");
	}

	@Override
	public void onCloseSocket(Socket socket) {
		IOUtils.closeQuietly(socket);
	}
}