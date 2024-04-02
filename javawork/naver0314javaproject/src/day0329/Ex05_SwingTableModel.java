package day0329;

import java.awt.Color;import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex05_SwingTableModel extends JFrame{
	
	JLabel lbltitle;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnDelete;
	
	
	public Ex05_SwingTableModel(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(800,500); //창크기 
		//this.getContentPane().setBackground(new Color(255,199,187));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);
		
	}
	
	public void initDesign() {
		//상단에는 제목
		lbltitle = new JLabel("학생 정보",JLabel.CENTER);
		lbltitle.setFont(new Font("",Font.BOLD,30));
		this.add("North",lbltitle);
		
		//테이블 행 갯수 0, ㅈㅔ목만 넣어서 생성 후 center 에 추가
		String []title = {"이름","나이","Java","Spring","Html","총점","평균","등급"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		this.addStudentFile();
//		this.process();
		//삭제 버튼 생성 및 이벤트
		btnDelete = new JButton("학생정보삭제");
		this.add("South",btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				System.out.println(row);
				
				if(row==-1) {
					JOptionPane.showMessageDialog(Ex05_SwingTableModel.this, "먼저 삭제할 행을 선택해주세요");
				}
				else 
					tableModel.removeRow(row);
			}
		});
	}
	
	//총점 평균계산해주는 메서드
//	public void process() {
//		for(int i = 0; i < tableModel.getRowCount(); i++) {
//			//각 행마다3과목의 점수를 읽어서 int로 변환
//			int java = Integer.parseInt(table.getValueAt(i, 2).toString());
//			int spring = Integer.parseInt(table.getValueAt(i, 3).toString());
//			int html = Integer.parseInt(table.getValueAt(i, 4).toString());
//			
//			int tot = java+spring+html;
//			table.setValueAt(tot, i, 5);
//			double avg = tot/3.0;
//			table.setValueAt(avg,i,6);
//		}
//	}
	public void addStudentFile() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr=new FileReader("/Users/macbook/Desktop/naver0314/student.txt");
			br=new BufferedReader(fr);
			while(true) {
				String s = br.readLine();
				if(s==null)
					break;
				String []data = s.split(",");
				tableModel.addRow(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			System.out.println("파일을 못찾음");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_SwingTableModel a = new Ex05_SwingTableModel("Student 파일 읽기");
	}

}







































