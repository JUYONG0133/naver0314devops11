package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ex08_SwingImage extends JFrame{
	final static String PHOTO = "/Users/macbook/Desktop/naver0314/workall/image/image/1.jpg";
	JButton btnOpen;
	MyDraw draw = new MyDraw();
	
	
	public Ex08_SwingImage(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(1300,700); //창크기 
		//		this.getContentPane().setBackground(new Color(255,199,187));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);

	}
	class MyDraw extends Canvas{
		
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Image image = null;
			image = new ImageIcon(PHOTO).getImage();
			g.drawImage(image, 380, 70, 520, 560, this);
			//if(photoIndex!=1) {
				
			//}
			
		}
	}

	public void initDesign() {
		JPanel p = new JPanel();
		btnOpen = new JButton("사진열기");
		p.add(btnOpen);
		this.add("North",p);
		this.add("Center",draw);

		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog dlg = new FileDialog(Ex08_SwingImage.this,"파일열기",FileDialog.LOAD);
				dlg.setVisible(true); //다이얼로그 보이게 하기
				if(dlg.getDirectory()==null)
					return;
				String path = dlg.getDirectory()+dlg.getFile(); // 폴더이름 +파일 
				FileReader fr = null;
				BufferedWriter bw = null;
				try {
					fr = new FileReader(path);
					//bw = new BufferedWriter(bw);
					Image image = null;
					
					image = new ImageIcon(path).getImage();
					
					} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}




			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex08_SwingImage a = new Ex08_SwingImage("간단사진첩");
	}

}