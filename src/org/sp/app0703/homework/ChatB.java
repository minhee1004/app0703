package org.sp.app0703.homework;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame implements KeyListener {
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;
	
	ChatA chatA;
	ChatC chatC;


	public void setChatA(ChatA chatA) {
		this.chatA = chatA;
	}

	public void setChatC(ChatC chatC) {
		this.chatC = chatC;
	}

	public ChatB() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p = new JPanel();
		t = new JTextField(20);

		// this.chatA = chatA; //주입(injection)

		add(scroll);// 센터에 부착
		p.add(t);// 패널에 부착

		add(p, BorderLayout.SOUTH);// 남쪽에 패널 부착

		setBounds(400, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// t와 리스너연결
		t.addKeyListener(this);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		// System.out.println("입력했어?");
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ENTER) {
			String msg = t.getText();
			area.append(msg+"\n");
			chatA.area.append(msg+"\n");
			chatC.area.append(msg+"\n");
			
			//2)초기화
			t.setText("");
		}

	}
}