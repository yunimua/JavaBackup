package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class S06_JTable extends StudyFrame {
	
	public S06_JTable() {
		super();
		
		Container con = getContentPane();
		
		String[] columnNames = {"ID", "NAME", "J_ID", "D_Name"};
		String[][] data = {
				{"1", "Smith", "IT_PROG", "IT"},
				{"2", "Steven", "AD_PRES", "AD"},
				{"3", "Neena", "AD_VP", "AD"},
				{"4", "Lex", "AD_VP", "AD"},
				{"5", "Alexander", "IT_PROG", "IT"},
		};
		
		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);// table을 JScrollPane에 넣음..
		
		table.getTableHeader().setPreferredSize(new Dimension( // columnNames 칸너비가 변경, scrollPane에서 해당 크기를 직접 조정..
				scrollPane.getWidth(), 50
		));
		
		table.getTableHeader().setFont(new Font("Small Fonts", Font.BOLD, 25)); // columnNames 글자체, 글자크기 변경..
		
		table.setCellSelectionEnabled(true); // 셀 한칸만 선택되도록 설정
		table.setRowHeight(50); // data 칸의 크기만 조정되고 columnNames 칸은 그대로..
		table.setAlignmentY(JTable.TOP_ALIGNMENT);
		table.setShowGrid(true);
		table.setFont(new Font("Consolas",Font.PLAIN,20));
	
		con.add(scrollPane, "Center"); // scrollPane에 넣어야 상단에 컬럼이 표시된다
		
		/*
			인터페이스를 그대로 사용하면 인터페이스 내부의 모든 추상 메서드를 구현해야 한다.
			이런 경우에는 어댑터 클래스를 사용하면 구현하고 싶은 추상 메서드만 구현할 수 있다.
		*/
		
		table.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("테이블 헤더 클릭함");
			}
		});
		
		scrollPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("스크롤 페인 내부에서 드래그중......");
			}
			
		});
		
		table.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				System.out.println("테이블에서 마우스 휠이 굴러감");
				
			}
		});		
		/*
			각 컴포넌트들에만 존재하는 이벤트들도 있다.
		*/
		
		ListSelectionModel selection = table.getSelectionModel();
		
		// 아래설정을 하면, 열만 선택되는? 상태가됨
//		selection.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
//		table.setRowSelectionAllowed(false);
		
		selection.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) { // getValueIsAdjusting을 사용해야 2번 출력되지 않게 됨..(용어사전 =?  값 조정 중이 아닐때에만 출력)
					System.out.println("사용자가 다른 칸을 선택하면 발생하는 이벤트");
					System.out.println(
						table.getSelectedColumn()+ "열 / "+
						table.getSelectedRow() + "행이 선택되었습니다."
					);
					System.out.println("선택된 값: " + 
						table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())
					);
				}
			}
		});		
	}
	
	public static void main(String[] args) {
		S06_JTable frame = new S06_JTable();
		frame.setDefaultOptions();
	}
}
