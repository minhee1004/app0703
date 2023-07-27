package org.sp.app0703.color;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//우측창에서 발생하는 액션이벤트를 감지하기 위한 리스너 정의
public class MyListener2 implements ActionListener{
	RigthFrame rigthFrame;
	LeftFrame leftFrame;
	
	public MyListener2(RigthFrame rigthFrame) {
		this.rigthFrame= rigthFrame;
		this.leftFrame = rigthFrame.leftFrame;
	}


	public void actionPerformed(ActionEvent e) {
			System.out.println("우측창의 버튼들 눌렀어?");
	
			Object obj=e.getSource(); //이벤트를 일으킨 컴포넌트를 반환
			if(obj==rigthFrame.bt_green) {
				leftFrame.p.setBackground(Color.green);
				}else if(obj==rigthFrame.bt_blue) {
				leftFrame.p.setBackground(Color.blue);
				}else if(obj==rigthFrame.bt_pink) {
				leftFrame.p.setBackground(Color.pink);
				}
			}
			
			
}
