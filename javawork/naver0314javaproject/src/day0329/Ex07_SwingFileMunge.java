package day0329;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Ex07_SwingFileMunge extends JFrame {
    JButton btnAdd, btnDelete;
    DefaultTableModel tableModel;
    JTable table;
    JTextField tfName;
    JComboBox<String> comboBlood, comboLocation, comboGrade;

    public Ex07_SwingFileMunge(String title) {
        super(title);
        this.setLocation(100, 100); // 시작위치
        this.setSize(500, 400); // 창크기
        this.getContentPane().setBackground(new Color(255, 199, 187));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료
        this.initDesign(); // 각종 컴포넌트 생성
        this.setVisible(true);
    }

    public void initDesign() {
        JPanel pTop = new JPanel();
        btnAdd = new JButton("사원정보추가");
        btnDelete = new JButton("사원정보삭제");
        pTop.add(btnAdd);
        pTop.add(btnDelete);
        this.add("North", pTop);

        // 테이블 추가
        String[] title = {"이름", "혈액형", "지역", "직급"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table));

        // 하단 입력 컴포넌트들
        tfName = new JTextField(7);
        comboBlood = new JComboBox<>(new String[]{"---", "A형", "B형", "AB형", "O형"});
        comboLocation = new JComboBox<>(new String[]{"---", "서울", "경기", "경상", "전라", "인천", "강원"});
        comboGrade = new JComboBox<>(new String[]{"---", "사장", "이사", "책임", "선임"});
        JPanel pBottom = new JPanel();
        pBottom.add(new JLabel("이름"));
        pBottom.add(tfName);
        pBottom.add(new JLabel("혈액형"));
        pBottom.add(comboBlood);
        pBottom.add(new JLabel("지역"));
        pBottom.add(comboLocation);
        pBottom.add(new JLabel("직급"));
        pBottom.add(comboGrade);
        this.add("South", pBottom);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });
    }

    private void addEmployee() {
        String name = tfName.getText();
        String bloodType = comboBlood.getSelectedItem().toString();
        String location = comboLocation.getSelectedItem().toString();
        String grade = comboGrade.getSelectedItem().toString();

        if (name.isEmpty() || bloodType.equals("---") || location.equals("---") || grade.equals("---")) {
            JOptionPane.showMessageDialog(this, "모든 정보를 입력해주세요.");
            return;
        }

        // 테이블에 새로운 행으로 추가
        Vector<String> row = new Vector<>();
        row.add(name);
        row.add(bloodType);
        row.add(location);
        row.add(grade);
        tableModel.addRow(row);

        // 입력 필드 초기화
        tfName.setText("");
        comboBlood.setSelectedIndex(0);
        comboLocation.setSelectedIndex(0);
        comboGrade.setSelectedIndex(0);
    }

    private void deleteEmployee() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요.");
            return;
        }

        // 선택된 행 삭제
        tableModel.removeRow(selectedRow);
    }

    public static void main(String[] args) {
        Ex07_SwingFileMunge a = new Ex07_SwingFileMunge("사원정보");
    }
}
