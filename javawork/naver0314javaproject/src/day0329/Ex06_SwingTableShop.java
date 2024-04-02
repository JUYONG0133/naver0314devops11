package day0329;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import day0327.MemberDto;

public class Ex06_SwingTableShop extends JFrame{
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd,btnDelete,btnOpen;
	JTextField tfSang,tfSu,tfDan;
	Vector<Object> v = new Vector<Object>(10);
//	Vector<Integer> vi = new Vector<Integer>(10);
	final static String FILENAME= "/Users/macbook/Desktop/naver0314/myshop.txt";
	
	public Ex06_SwingTableShop(String title) {
		super(title);
		this.setLocation(100, 100); //시작위치
		this.setSize(500,800); //창크기 
		this.getContentPane().setBackground(new Color(255,199,187));

	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료
	}
		public void shopFileRead() {
			FileReader fr = null;
			BufferedReader br =null;

			try {
				fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);

				while(true) {
					String s = br.readLine();
					if(s==null) {
						break;
					}
					String []a = s.split(",");
					tableModel.addRow(a);

				//	table.add(dto);
				}
			//	System.out.println("총 "+table.+"명의 멤버 정보를 읽어왔습니다.");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//System.out.println("읽어올 멤버 정보가 없습니다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					br.close();
					fr.close();
				} catch (IOException | NullPointerException e) {
					// TODO Auto-generated catch block
					//	e.printStackTrace();

				}
			}
		
		//윈도우 종료시 테이블의 내용을 파일에 저장후 종료하자
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				FileWriter fw = null;
				try {
					fw = new FileWriter(FILENAME);
					
					for(int i=0;i<table.getRowCount();i++) {
						String sang = table.getValueAt(i, 0).toString();
						String su = table.getValueAt(i, 1).toString();
						String dan = table.getValueAt(i, 2).toString();
						String tot = table.getValueAt(i, 3).toString();
						
						String s = sang+","+su+","+dan+","+tot+"\n";
						fw.write(s);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				System.exit(0);
			}
			
		});
		this.initDesign(); //각종 컴포넌트 생성
		this.shopFileRead();
		this.setVisible(true);
		
		
	}
	
	public void initDesign() {
		//상단 추가, 삭제 버튼
		JPanel pTop = new JPanel();
		btnAdd = new JButton("상품정보추가");
		btnDelete = new JButton("상품정보삭제");
		pTop.add(btnAdd);
		pTop.add(btnDelete);
		this.add("North",pTop);
		//중간 테이블 추가
		String []title = {"상품명","수량","단가","총금액"};
		tableModel = new DefaultTableModel(title,0);
		table = new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		//하단 입력 컴포넌트들
		tfSang = new JTextField(7);
		tfSu = new JTextField(4);
		tfDan = new JTextField(7);
		JPanel pBottom = new JPanel();
		pBottom.add(new JLabel("상품명"));
		pBottom.add(tfSang);
		pBottom.add(new JLabel("수량"));
		pBottom.add(tfSu);
		pBottom.add(new JLabel("단가"));
		pBottom.add(tfDan);
		this.add("South",pBottom);
		//추가버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//입력안했읅경우 종료
				if(tfSang.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "상품명을 입력하세요");
					return;
				}
				if(tfSu.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "수량을 입력하세요");
					return;
				}
				if(tfDan.getText().length()==0) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "단가를 입력하세요");
					return;
				}
				
				
				String sang = tfSang.getText();
				int su=0,dan=0;
				try {
				su = Integer.parseInt(tfSu.getText());
				dan = Integer.parseInt(tfDan.getText());
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "수량, 단가는 숫자로만 입력하세요");
					return;
				}
				int total = su*dan;
				v.add(sang);
				v.add(su);
				v.add(dan);
				v.add(total);
				tableModel.addRow(v);
				tfSang.setText(null);
				tfSu.setText(null);
				tfDan.setText(null);
				
			}
		});
		//삭제 버튼 이벤트
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				System.out.println(row);
				
				if(row==-1) {
					JOptionPane.showMessageDialog(Ex06_SwingTableShop.this, "먼저 삭제할 행을 선택해주세요");
				}
				else 
					tableModel.removeRow(row);
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex06_SwingTableShop a = new Ex06_SwingTableShop("상품등록및삭제");
	}

}
