package day0329;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex04_SwingTable extends JFrame{
	JTable table;
	JLabel lblMessge;
	
	
	public Ex04_SwingTable(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(1300,800); //창크기 
		this.getContentPane().setBackground(new Color(255,199,187));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);
		
	}
	
	public void initDesign() {
		String []title = {"이름","나이","혈액형","핸드폰","주소"};
		String [][]data = {
				{"이영자","32세","B","010-1234-1234","서울"},
				{"강호동","45세","O","010-2345-2345","부산"},
				{"유재석","29세","AB","010-3456-3456","제주"},
				{"제니","23세","A","010-4567-4567","뉴욕"},
		};
		table = new JTable(data, title);
		this.add("North",new JLabel("701멤버 현황",JLabel.CENTER));
		//프레임 센터에 추가
		this.add("Center",new JScrollPane(table));
		lblMessge = new JLabel("결과 나올곳 .. ",JLabel.CENTER);
		lblMessge.setFont(new Font("",Font.BOLD,20));
		this.add("South",lblMessge);
		//테이블 이벤트
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				//선택한 행 번호
				int rowIndex = table.getSelectedRow();
				System.out.println(rowIndex);
				//클릭한 곳에서 이름,나이,주소정도만얻어서 메세지에 출력해보자
				String name = table.getValueAt(rowIndex, 0).toString();
				String age = table.getValueAt(rowIndex, 1).toString();
				String addr = table.getValueAt(rowIndex, 4).toString();
				
				String m = name+"님은 "+age+" 이며 "+addr+"에 살고 있어요";
				lblMessge.setText(m);
			}
		});
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_SwingTable a = new Ex04_SwingTable("table");
	}

}
