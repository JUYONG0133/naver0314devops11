package day0408;
import db.common.DbConnect;

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
import java.util.Vector;

public class Ex02_DbSawon extends JFrame{
	DbConnect db = new DbConnect();
	JTable table;
	DefaultTableModel tableModel;
	JTextField tfName, tfScore;
	JButton btnAdd, btnDel;
	JComboBox<String> tfGender, tfBuseo , cbResult;
	JRadioButton rd[] = new JRadioButton[3];

	int order = 1;
	int rIndex = 1;


	public Ex02_DbSawon(String title) {
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
		this.add("North", p1);
		tfName = new JTextField(5);
		p1.add(tfName);
		p1.add(new JLabel("점수"));
		tfScore = new JTextField(5);
		p1.add(tfScore);
		p1.add(new JLabel("성별"));
		String[] gen = {"남자","여자"};
		tfGender = new JComboBox<>(gen);
		p1.add(tfGender);
		p1.add(new JLabel("부서"));
		String[] bus = {"홍보부","교육부","인사부"};
		tfBuseo = new JComboBox<>(bus);
		p1.add(tfBuseo);

		//////////////
		String[] title = {"시퀀스","이름","점수","성별","부서"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		//////////////




		JPanel p2 = new JPanel();
		btnAdd = new JButton("추가");
		btnDel = new JButton("삭제");
		p2.add(btnAdd);
		p2.add(btnDel);
		String[] cb = {"전체","홍보부","교육부","인사부"};
		cbResult = new JComboBox<>(cb);
		p2.add(cbResult);
		this.add("South",p2);
		cbResult.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				order = cbResult.getSelectedIndex()+1;

				writeSawon();
			}
		});
		ButtonGroup bg = new ButtonGroup();
		String rd_name[] = {"전체","남","여"};

		for(int i = 0; i < rd.length; i++) {
			final int n = i + 1;
			rd[i] = new JRadioButton(rd_name[i], i == (rIndex - 1) ? true : false);
			bg.add(rd[i]);
			p2.add(rd[i]);

			rd[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rIndex = n; // 선택된 라디오 버튼의 인덱스 업데이트

					// SQL 쿼리를 실행하여 데이터 가져오고 테이블에 표시하는 메소드 호출
					writeSawon();
				}
			});
		}
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfName.getText().length()==0){
					return;
				}
				if(tfScore.getText().length()==0){
					return;
				}
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;
				String sql = "insert into sawon values (null,?,?,?,?)";
                try {
                    pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, tfName.getText());
					pstmt.setInt(2,Integer.parseInt(tfScore.getText()));
					pstmt.setString(3,tfGender.getSelectedItem().toString());
					pstmt.setString(4,tfBuseo.getSelectedItem().toString());

					pstmt.execute();

					tfName.setText("");
					tfScore.setText("");

					writeSawon();
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
				int row = table.getSelectedRow();
				if(row == -1){
					JOptionPane.showMessageDialog(Ex02_DbSawon.this,"삭제할 행을 선택해주세요");
					return;
				}
				String num = table.getValueAt(row,0).toString();
				String sql = "delete from sawon where num = ?";
				Connection conn = db.getConnection();
				PreparedStatement pstmt = null;

                try {
                    pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,num);
					pstmt.execute();

					writeSawon();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }finally {
					db.dbClose(pstmt,conn);
				}

            }
		});

	}
	public void writeSawon() {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		// 선택된 라디오 버튼과 콤보 박스의 값에 따라 SQL 쿼리 구성
		if (rIndex == 1 && order == 1) {
			sql = "select * from sawon"; // 전체
		} else if (rIndex == 2 && order > 1) {
			sql = "select * from sawon where gender like '남자' and buseo like ?"; // 남자
		} else if (rIndex == 3 && order > 1) {
			sql = "select * from sawon where gender like '여자' and buseo like ?"; // 여자
		} else if (order > 1) {
			sql = "select * from sawon where buseo like ?"; // 부서명만 선택한 경우
		}

		try {
			pstmt = conn.prepareStatement(sql);
			if (order > 1) {
				pstmt.setString(1, cbResult.getSelectedItem().toString());
			}
			rs = pstmt.executeQuery();
			tableModel.setRowCount(0); // 테이블 모델 초기화

			// 결과 집합을 테이블에 추가
			while (rs.next()) {
				Vector<String> data = new Vector<>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("score"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("buseo"));

				tableModel.addRow(data); // 데이터 추가
			}
		} catch (SQLException e) {
			db.dbClose(pstmt, conn, rs); // 예외 처리
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_DbSawon a = new Ex02_DbSawon("db사원정보");
	}

}
