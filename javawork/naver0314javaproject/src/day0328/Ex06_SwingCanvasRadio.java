package day0328;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex06_SwingCanvasRadio extends JFrame{
	final static String PHOTO1 = "/Users/macbook/Desktop/naver0314/workall/image/image/19.jpg";
	final static String PHOTO2 = "/Users/macbook/Desktop/naver0314/workall/image/image/18.jpg";
	final static String PHOTO3 = "/Users/macbook/Desktop/naver0314/workall/image/image/15.jpg";
	final static String PHOTO4 = "/Users/macbook/Desktop/naver0314/workall/image/image/2.jpg";

	Color boxColor = new Color(67,196,207);  //초기 박스 색상
	JRadioButton rbBox1,rbBox2,rbBox3,rbBox4;
	JRadioButton []rbPhoto = new JRadioButton[4];
	int photoIndex = 1; //19.jpg
	MyDraw draw = new MyDraw();


	public Ex06_SwingCanvasRadio(String title) {

		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(400,500); //창크기 
		this.getContentPane().setBackground(new Color(255,199,187));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);

	}
	//캔버스 내부 클래스
	class MyDraw extends Canvas{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.setColor(boxColor);
			g.fillRect(40, 40, 320, 320);
			//이미지
			//Image image = new ImageIcon();
			Image image = null;
			switch(photoIndex) {
			case 1 :
				image = new ImageIcon(PHOTO1).getImage();
				break;
			case 2 :
				image = new ImageIcon(PHOTO2).getImage();
				break;
			case 3 :
				image = new ImageIcon(PHOTO3).getImage();
				break;
			case 4 :
				image = new ImageIcon(PHOTO4).getImage();
				break;
			}
			g.drawImage(image, 90, 70, 220, 260, this);
		}
	}

	public void initDesign() {
		this.add("Center",draw);
		//상단에 색상 라디오 버튼 추가
		JPanel pTop = new JPanel();
		ButtonGroup bg1 = new ButtonGroup();
		rbBox1 = new JRadioButton("초록색");
		bg1.add(rbBox1);
		pTop.add(rbBox1);

		rbBox2 = new JRadioButton("하늘색",true);
		bg1.add(rbBox2);
		pTop.add(rbBox2);

		rbBox3 = new JRadioButton("분홍색");
		bg1.add(rbBox3);
		pTop.add(rbBox3);

		rbBox4 = new JRadioButton("오렌지색");
		bg1.add(rbBox4);
		pTop.add(rbBox4);

		//rbBox1에 대한 이벤트
		rbBox1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor = Color.GREEN;

				draw.repaint();
			}
		});
		rbBox2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor =  new Color(67,196,207);

				draw.repaint();
			}
		});
		rbBox3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor = Color.PINK;

				draw.repaint();
			}
		});
		rbBox4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boxColor = Color.ORANGE;

				draw.repaint();
			}
		});

		//프레임 상단에 panel 추가
		this.add("North",pTop);

		//프레임 하단에 사진선택하는 라디오 버튼 추가
		JPanel pBottom = new JPanel();
		ButtonGroup bg2 = new ButtonGroup();
		String []s = {"수지","신세경","설현","김우빈"};
		for(int i = 0; i < rbPhoto.length; i++) {
			final int n=i+1;
			rbPhoto[i] = new JRadioButton(s[i],i==(photoIndex-1)?true:false);
			//그룹변수에 추가
			bg2.add(rbPhoto[i]);
			pBottom.add(rbPhoto[i]);
			rbPhoto[i].addActionListener(new ActionListener() {
				Image image = null;
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					photoIndex=n;
					draw.repaint(); //캔버스 내부 클래스의 paint 메소드 강제 호출

				}

			});


		}


		this.add("South",pBottom);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex06_SwingCanvasRadio a = new Ex06_SwingCanvasRadio("캔버스2");
	}

}
