package day0328;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex04_SwingButton extends JFrame{
	JButton btn1,btn2;
	JButton []btnArray  = new JButton[6];	//각 배열의 값 null
	String []btnLabel = {"초록","빨강","분홍","주황","노랑","랜덤"};
	
	public Ex04_SwingButton(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(1300,700); //창크기 
		this.getContentPane().setBackground(new Color(109, 101, 201));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);

	}

	public void initDesign() {
		this.setLayout(null);  //모든 레이아웃 없애기
		//버튼1 생성
		btn1=new JButton("Hello");
		//프레임에 추가
		btn1.setBounds(10, 10, 100, 30);
		this.add(btn1);
		//btn1 에 이벤트 추가 - 익명 내부 클래스 형태로 이벤트 구현
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(Ex04_SwingButton.this,"버튼 1 클릭");
			}
		});
		btn2 = new JButton("Bye");
		btn2.setBounds(100,10,100,30);
		this.add(btn2);
		btn2.addActionListener(new Button2Event());
		
		//btnArray 배열 변수를 생성 후 프레임에 추가
		int yPos = 50;
		for(int i = 0; i < btnArray.length; i++) {
			btnArray[i] = new JButton(btnLabel[i]);
			btnArray[i].setBounds(10,yPos,100,30);
			this.add(btnArray[i]);
			yPos+=35;
			
			//익명 내부 클래스 형태로 이벤트 구현
			btnArray[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//Object ob = e.getSource(); //이벤트가 발생한 오브젝트
					JButton ob = (JButton)e.getSource();
					System.out.println(ob.getText());
					//System.out.println(ob.getLabel());
					switch(ob.getText()) {
						case "빨강" :
							//부모 컴포넌트 인스턴스 변수인 this를 통해서 배경색 변경
							Ex04_SwingButton.this.getContentPane().setBackground(new Color(255, 66, 66));
							break;
						case "초록" :
							//부모 컴포넌트 인스턴스 변수인 this를 통해서 배경색 변경
							Ex04_SwingButton.this.getContentPane().setBackground(new Color(64, 255, 92));
							break;
						case "분홍" :
							//부모 컴포넌트 인스턴스 변수인 this를 통해서 배경색 변경
							Ex04_SwingButton.this.getContentPane().setBackground(new Color(255, 138, 222));
							break;
						case "주황" :
							//부모 컴포넌트 인스턴스 변수인 this를 통해서 배경색 변경
							Ex04_SwingButton.this.getContentPane().setBackground(Color.orange);
							break;
						case "노랑" :
							//부모 컴포넌트 인스턴스 변수인 this를 통해서 배경색 변경
							Ex04_SwingButton.this.getContentPane().setBackground(Color.yellow);
							break;
						case "랜덤" :
						{
							int r = (int) (Math.random()*255);
							int g = (int) (Math.random()*255);
							int b = (int) (Math.random()*255);
						
							Ex04_SwingButton.this.getContentPane().setBackground(new Color(r,b,g));
						}
							break;
					}
				}
			});
		}
	}
	class Button2Event implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(Ex04_SwingButton.this,"버튼 2 클릭");
		}
		
	}
	
//		btn2.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(Ex04_SwingButton.this,"버튼 2 클릭");
//			}
//		});
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_SwingButton a = new Ex04_SwingButton("스윙버튼");
	}

}
