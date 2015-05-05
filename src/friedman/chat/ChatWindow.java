package friedman.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWindow extends JFrame {

	private JButton send;
	private JTextArea area;
	private JTextField feild;

	public ChatWindow() {
		setSize(400, 400);
		setTitle("Chat Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		BorderLayout layout = new BorderLayout();
		c.setLayout(layout);

		send = new JButton("SEND");
		c.add(send, BorderLayout.NORTH);

		area = new JTextArea();
		area.setBackground(Color.lightGray);
		c.add(area, BorderLayout.CENTER);

		feild = new JTextField();
		Container south = new Container();
		south.setLayout(new GridLayout());
		south.add(feild);
		south.add(send);
		c.add(south, BorderLayout.SOUTH);

		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getSource().equals(send)) {
					area.insert(feild.getText()+"\n", 0);
				}
			}
		};
		send.addActionListener(listener);
	}
	
	
	
	public String sendMsg(){
		return feild.getText();
	}
	public void getMsg(String s){
		area.insert(feild.getText()+"\n", 0);
	}

	public static void main(String[] args) {
		ChatWindow chat = new ChatWindow();
		chat.setVisible(true);

	}

}