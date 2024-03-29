package day0328;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex08_SwingImage extends JFrame {
	final static String PHOTO = "/Users/macbook/Desktop/naver0314/workall/image/image/1.jpg";
	JButton btnOpen;
	MyDraw draw = new MyDraw();

	public Ex08_SwingImage(String title) {
		super(title);
		this.setLocation(100, 100);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initDesign();
		this.setVisible(true);
	}

	class MyDraw extends Canvas {
		Image image=null;

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			if (image == null) {
				image = new ImageIcon(PHOTO).getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
			else if (image != null) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		}
	}

	public void initDesign() {
		JPanel panel = new JPanel();
		btnOpen = new JButton("사진 열기");
		panel.add(btnOpen);
		this.add("North", panel);


		this.add("Center", draw);

		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dig = new FileDialog(Ex08_SwingImage.this, "사진 열기", FileDialog.LOAD);
				dig.setVisible(true);

				if (dig.getDirectory() == null) 
					return;
				String filepath = dig.getDirectory() + dig.getFile();
			
					FileReader file = null;
					try {
						file = new FileReader(filepath);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (file!=null) {
						Image image = new ImageIcon(filepath).getImage();
						draw.image = image;
						draw.repaint();
					} 
			}

		});
	}

	public static void main(String[] args) {
		Ex08_SwingImage a = new Ex08_SwingImage("간단 이미지 뷰어");
	}
}
