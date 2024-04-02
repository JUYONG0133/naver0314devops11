package day0329;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ex03_ComboboxCanvas extends JFrame{
	JComboBox<String> combo ;
	String []comboLabel = {"선","원","사각형","문자열","이미지"};
	Draw draw = new Draw();
	int selectCombo = 5; //이미지 기본값
	final static String PATH =  "/Users/macbook/Desktop/naver0314/workall/image/image/";
	Random rd = new Random();


	public Ex03_ComboboxCanvas(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(1300,1300); //창크기 
		this.getContentPane().setBackground(new Color(255,199,187));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);

	}
	public Color getRandomColor() {
		int r = rd.nextInt(256);
		int b = rd.nextInt(256);
		int g = rd.nextInt(256);
		return new Color(r,b,g);
	}

	class Draw extends Canvas{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(5));


			if(selectCombo==1) {
				//int line = rd.nextInt(50)+1;
				for(int i = 1; i <= 50; i++) {
					int x = rd.nextInt(1300);
					int y = rd.nextInt(1300);
					int x1 = rd.nextInt(1300);
					int y1 = rd.nextInt(1300);
					Color color = getRandomColor();
					g.setColor(color);
					g.drawLine(x, y, x1, y1);
				}
			}
			else if(selectCombo==2) {
				for(int i = 1; i <= 50; i++) {
					int x = rd.nextInt(1300);
					int y = rd.nextInt(1300);
					int w = rd.nextInt(100)+20;
					//int h = rd.nextInt(1300);
					Color color = getRandomColor();
					g.setColor(color);
					g.fillOval(x, y, w, w);
				}
			}
			else if(selectCombo==3) {
				for(int i = 1; i <= 50; i++) {
					int x = rd.nextInt(1300);
					int y = rd.nextInt(1300);
					int w = rd.nextInt(100)+20;
					//int h = rd.nextInt(1300);
					Color color = getRandomColor();
					g.setColor(color);
					g.fillRect(x, y, w, w);
				}
			}
			else if(selectCombo==4) {
				String msg = "Have a Nice Day";
				g.setFont(new Font("Comic Sans Ms",Font.BOLD,30));
				for(int i = 1; i <=50; i++) {
					Color color = getRandomColor();
					g.setColor(color);
					int x = rd.nextInt(1000);
					int y = rd.nextInt(1000);
					g.drawString(msg, x, y);
				}
			}
			else if(selectCombo==5) {
				int nan = rd.nextInt(19)+1;
				String filename = PATH+nan+".jpg";
				Image image = new ImageIcon(filename).getImage();
				g.drawImage(image, 0, 0, getWidth(),getHeight(),this);

			}

		}
	}
	public void initDesign() {
		JPanel p = new JPanel();
		combo = new JComboBox<String>(comboLabel);
		p.add(new JLabel("메뉴를 선택하세요"));
		p.add(combo);
		combo.setSelectedIndex(selectCombo-1); //콤보박스 초기값 지정

		//이벤트추가
		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				selectCombo = combo.getSelectedIndex()+1;
				//paint 호출
				draw.repaint();
			}
		});

		//프레임에 패널추가
		this.add("North",p);

		//중앙에는 캔버스를 배치
		this.add("Center",draw);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex03_ComboboxCanvas a = new Ex03_ComboboxCanvas("콤보박스메뉴");
	}

}






























