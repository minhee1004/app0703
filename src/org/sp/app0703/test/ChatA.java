package org.sp.app0703.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p;
	JTextField t;
	JButton bt;
	ChatB chatB;
	ChatC chatC;
	
	public ChatA() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p = new JPanel(); 
		t=new JTextField(16);
		bt = new JButton("open");
		
		 
		add(scroll);//센터에 부착
		p.add(t);//패널에 부착
		p.add(bt);//패널에 부착 
		add(p, BorderLayout.SOUTH);//남쪽에 패널 부착
		
		setBounds(200, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		bt.addActionListener(this);//버튼과 리스너와의 연결 
		t.addKeyListener(this);//텍스트필드와 리스너와의 연결 
	}
	

	public void actionPerformed(ActionEvent e) {
		//System.out.println("버튼 눌렀어?");
		chatB=new ChatB();
		chatC=new ChatC();
		
		chatB.setChatA(this);
		chatB.setChatC(chatC);
		
		chatC.setChatA(this);
		chatC.setChatB(chatB);
	}


	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode(); // js event.keyCode 와 동일 
		
		if(key==KeyEvent.VK_ENTER) { //엔터키를 눌럿다면..
			//System.out.println("엔터쳣어?");
			
			//1)나의 창의 area에 입력한 값 대입
			String msg=t.getText();
			area.append(msg+"\n");
			t.setText("");//입력한 값 초기화
			
			//2)ChatB 창의 area에 입력한 값 대입 
			chatB.area.append(msg+"\n");
			chatB.t.setText("");//입력한 값 초기화
			chatC.area.append(msg+"\n");
			//chatC.t.setText("");//입력한 값 초기화
		}
		
	}

	public static void main(String[] args) {
		new ChatA();
	}
}