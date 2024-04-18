package day0408;
import db.common.DbConnect;
import oracle.jdbc.proxy.annotation.Pre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Vector;

public class Ex01_SwingDbStudent extends JFrame{
	DbConnect db = new DbConnect();
	JTable table;
	DefaultTableModel tableModel;
	JTextField tfName, tfJava, tfHtml, tfSpring;
	JButton btnAdd, btnDel;
	JComboBox<String> cbResult;
	int order = 1;

	public Ex01_SwingDbStudent(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(600,800); //창크기
		this.getContentPane().setBackground(new Color(255,199,187));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
		this.initDesign(); //각종 컴포넌트 생성
		this.setVisible(true);
	}
	
	public void initDesign() {
		JPanel p1 = new JPanel();
		p1.add(new JLabel("이름"));
		tfName = new JTextField(5);
		p1.add(tfName);

		p1.add(new JLabel("Java"));
		tfJava = new JTextField(5);
		p1.add(tfJava);

		p1.add(new JLabel("Html"));
		tfHtml = new JTextField(5);
		p1.add(tfHtml);

		p1.add(new JLabel("Spring"));
		tfSpring = new JTextField(5);
		p1.add(tfSpring);

		this.add("North", p1);
		////////////////////////
		String[] title = {"시퀀스", "이름", "Java", "Html", "Spring", "총점", "평균"};
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));

		JPanel p2 = new JPanel();
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		p2.add(btnAdd);
		p2.add(btnDel);

		String[] cb = {"추가순", "이름순", "총점높은순", "총점낮은순"};
		cbResult = new JComboBox<>(cb);
		p2.add(new JLabel("출력순서"));
		p2.add(cbResult);
		this.add("South", p2);
		// 콤보박스 이벤트
		cbResult.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				order=cbResult.getSelectedIndex()+1;

				//다시 출력
				writeStudent();
			}
		});
		//추가 버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//입력안했을경우 이벤트 종료
				if (tfName.getText().length() == 0) {
					return;
				}
				if (tfJava.getText().length() == 0) {
					return;
				}
				if (tfHtml.getText().length() == 0) {
					return;
				}
				if(tfSpring.getText().length()==0) {
					return;
				}
				//입력란에 db insert
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;
				String sql = "insert into student values (null,?,?,?,?,now())";

                try {
                    pstmt = conn.prepareStatement(sql);
					//??개수만큼 바인딩
					pstmt.setString(1, tfName.getText());
					pstmt.setInt(2,Integer.parseInt(tfJava.getText()));
					pstmt.setInt(3,Integer.parseInt(tfHtml.getText()));
					pstmt.setInt(4,Integer.parseInt(tfSpring.getText()));

					//실행
					pstmt.execute();
					//입력값 초기화
					tfName.setText("");
					tfJava.setText("");
					tfHtml.setText("");
					tfSpring.setText("");
					//다시 출력
					writeStudent();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }finally {
					db.dbClose(pstmt,conn);
				}
            }
				});

		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//테이블의 선택한 행번호 row를 얻는다.
				int selectedRow = table.getSelectedRow();
				//row가 -1이면 경고메세지후 이벤트 종료
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(Ex01_SwingDbStudent.this, "삭제할 행을 선택해주세요.");
					return;
				}
				//row행의 0번열에 있는 시퀀스 값을 얻는다. getValueAt
				String num = table.getValueAt(selectedRow,0).toString();
				//그 시퀀스에 해당하는 db데이터를 삭제하는 sql문 작성
				String sql = "delete from student where num = ?";
				//Conn,Prepar 생성후 sql 문 실행
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;

                try {
					pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1,num);
					pstmt.execute(); //db에서 삭제

					//db 다시 불러오기
					writeStudent();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }finally {
					db.dbClose(pstmt,conn);
				}
            }
		});


		//출력 메소드 호출
		writeStudent();
	}

		//출력메소드
		public void writeStudent(){
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "";
			if(order == 1){
				sql = "select *,java+html+spring tot from student order by num asc";
			}
			else if(order == 2){
				sql = "select *,java+html+spring tot from student order by name asc";
			}
			else if(order == 3){
				sql = "select *,java+html+spring tot from student order by tot desc";
			}
			else if(order == 4){
				sql = "select *,java+html+spring tot from student order by tot asc";
			}

            try {
                pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				tableModel.setRowCount(0);


				while(rs.next()){
					Vector<String> data = new Vector<>();
					data.add(rs.getString("num"));
					data.add(rs.getString("name"));
					data.add(rs.getString("java"));
					data.add(rs.getString("html"));
					data.add(rs.getString("spring"));
					data.add(rs.getString("tot"));

					//평균구하기
					NumberFormat nf = NumberFormat.getInstance();
					nf.setMaximumFractionDigits(2);
					double avg = rs.getInt("tot")/3.0;
					data.add(String.valueOf(nf.format(avg)));

					tableModel.addRow(data);
				}
            } catch (SQLException e) {
                db.dbClose(pstmt,conn,rs);
            }
        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01_SwingDbStudent a = new Ex01_SwingDbStudent("학생관리DB");
	}

}
