package day0329;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ex01_SwingFileImage extends JFrame{
	static String photo = "/Users/macbook/Desktop/naver0314/workall/image/image/1.jpg";
	JButton btnImageOpen;
	MyPhoto myPhoto = new MyPhoto(); // 캔버스ㅡ 내부 클래스
	
	
	public Ex01_SwingFileImage(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(800,600); //창크기 
		this.getContentPane().setBackground(new Color(255,199,187));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);
		
	}
	//캔버스를 상속받는 내부클래스
	class MyPhoto extends Canvas{
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Image imgae = new ImageIcon(photo).getImage();
			g.drawImage(imgae, 0, 0, this.getWidth(),this.getHeight(),this);
			
		}
	}
	
	public void initDesign() {
		//패널에 버튼을 생ㅇ성후 패널을 North 에 추가;
		JPanel p = new JPanel();
		btnImageOpen = new JButton("이미지 불러오기");
		p.add(btnImageOpen);
		this.add("North",p);
		
		
		//캔버스 center 에 배치
		this.add("Center",myPhoto);
		
		btnImageOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg = new FileDialog(Ex01_SwingFileImage.this, "이미지 불러오기",FileDialog.LOAD);
				dlg.setVisible(true);
				if(dlg.getFile()==null) {
					return;
				}
				photo=dlg.getDirectory()+dlg.getFile();
				myPhoto.repaint();
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01_SwingFileImage a = new Ex01_SwingFileImage("사진불러오기");
	}

}










































