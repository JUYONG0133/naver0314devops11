package day0401;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGibon extends JFrame{
	
	
	public SwingGibon(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(300,300); //창크기 
		this.getContentPane().setBackground(new Color(255,199,187));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);
		
	}
	
	public void initDesign() {

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingGibon a = new SwingGibon("스윙버튼");
	}

}
