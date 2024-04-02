package day0401;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex05_ClientChat extends JFrame implements ActionListener,Runnable{

	JButton btnConnect;
	JLabel lblMessage;
	JTextArea area;
	JTextField tfMessage;
	JButton btnSend;
	BufferedReader br;
	PrintWriter pw;
	String nickName; // 각자이름
	Socket socket;
	
	public Ex05_ClientChat(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(500,500); //창크기 
		this.getContentPane().setBackground(new Color(255,199,187));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);
		
	}
	//서버가 보내오는 메세지를 받아서 출력하기 위한 쓰레드 메소드
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//this.autoScroll();
		System.out.println("클라이언트 run");
		
		
		//서버가 보내는 매세지를 항상 대기하고 있다가
		//바로바로 받아서 채팅창에 출력을 해야한다.
		while(true) {
			//서버가 보내는 메세지 읽기
			try {
				String msg = br.readLine();
				//채팅창에 출력
				area.append(msg+"\n");
				this.autoScroll();  //항상 마지막 문자열이보이게 하기
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	//메세지 전송 텍스트필드와 전송버튼을 처리하기 위한 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		
		//메세지 입력창이거나 전송버튼일 경우 서버로 메세지 보내기
		if(ob==tfMessage || ob==btnConnect) {
			pw.write("2|"+tfMessage.getText()+"\n");
			pw.flush(); //서버로 메세지 전송
			//입력창의 데이터 지우고 커서 보내기
			tfMessage.setText("");
			tfMessage.requestFocus();// 커서 보내기
		}
	}
	
	public void initDesign() {
		this.setLayout(null); //기본 레이아웃 없애고 직접 좌표주기
		btnConnect = new JButton("서버 접속하기");
		btnConnect.setBounds(50,10,150,30);
		this.add(btnConnect);
		
		lblMessage = new JLabel("접속여부:접속안함");
		lblMessage.setBounds(200,10,100,30);
		this.add(lblMessage);
		
		area = new JTextArea();
		//area.setBounds(10,140,400,400);
		JScrollPane pane = new JScrollPane(area);
		pane.setBounds(20, 40, 460, 350);
		this.add(pane);
		
		tfMessage = new JTextField(30);
		tfMessage.setBounds(10,410,350,30);
		this.add(tfMessage);
		
		btnSend = new JButton("전송");
		btnSend.setBounds(370,410,100,30);
		this.add(btnSend);
		
		//현재 클래스 내에 구현한 메소드 호출
		tfMessage.addActionListener(this);
		btnSend.addActionListener(this);
		
		//서버 접속 이벤트
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String serverIp = JOptionPane.showInputDialog("접속할 서버 아이피를 입력하세요","192.168.0.59"); // 초기값은 로컬 ip
				nickName = JOptionPane.showInputDialog("접속할 닉네임을 입력하세요","박주용"); //초기값은 각자 자기 이름
				
				//서버 접속하기
				try {
					socket = new Socket(serverIp, 6000);
					System.out.println("서버 접속 성공!");
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					pw = new PrintWriter(socket.getOutputStream());
					//창 제목 닉 네임
					Ex05_ClientChat.this.setTitle(nickName+"님의 채팅창");
					//메세지 변경
					lblMessage.setText("서버접속중..."+nickName);
					
					
					//쓰레드 시작
					Thread th = new Thread(Ex05_ClientChat.this);
					th.start();//run 메소드 호출
					
					
					//서버 로 "1| 닉네임" 형태로 보내기
					pw.write("1|"+nickName+"\n");
					pw.flush();
					
					
					
					
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("서버 접속 오류 : "+e1.getMessage());
				}
			}
		});
	
		
		
		
	}

	public void autoScroll() {
		int n = area.getDocument().getLength() ;// 총 라인수
		area.setCaretPosition(n);// 마지막 줄로 위치 변경
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_ClientChat a = new Ex05_ClientChat("클라이언트");
	}

}
