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
		JScrollPane scrollPane = new JScrollPane(table);// table�� JScrollPane�� ����..
		
		table.getTableHeader().setPreferredSize(new Dimension( // columnNames ĭ�ʺ� ����, scrollPane���� �ش� ũ�⸦ ���� ����..
				scrollPane.getWidth(), 50
		));
		
		table.getTableHeader().setFont(new Font("Small Fonts", Font.BOLD, 25)); // columnNames ����ü, ����ũ�� ����..
		
		table.setCellSelectionEnabled(true); // �� ��ĭ�� ���õǵ��� ����
		table.setRowHeight(50); // data ĭ�� ũ�⸸ �����ǰ� columnNames ĭ�� �״��..
		table.setAlignmentY(JTable.TOP_ALIGNMENT);
		table.setShowGrid(true);
		table.setFont(new Font("Consolas",Font.PLAIN,20));
	
		con.add(scrollPane, "Center"); // scrollPane�� �־�� ��ܿ� �÷��� ǥ�õȴ�
		
		/*
			�������̽��� �״�� ����ϸ� �������̽� ������ ��� �߻� �޼��带 �����ؾ� �Ѵ�.
			�̷� ��쿡�� ����� Ŭ������ ����ϸ� �����ϰ� ���� �߻� �޼��常 ������ �� �ִ�.
		*/
		
		table.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("���̺� ��� Ŭ����");
			}
		});
		
		scrollPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("��ũ�� ���� ���ο��� �巡����......");
			}
			
		});
		
		table.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				System.out.println("���̺��� ���콺 ���� ������");
				
			}
		});		
		/*
			�� ������Ʈ�鿡�� �����ϴ� �̺�Ʈ�鵵 �ִ�.
		*/
		
		ListSelectionModel selection = table.getSelectionModel();
		
		// �Ʒ������� �ϸ�, ���� ���õǴ�? ���°���
//		selection.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
//		table.setRowSelectionAllowed(false);
		
		selection.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) { // getValueIsAdjusting�� ����ؾ� 2�� ��µ��� �ʰ� ��..(������ =?  �� ���� ���� �ƴҶ����� ���)
					System.out.println("����ڰ� �ٸ� ĭ�� �����ϸ� �߻��ϴ� �̺�Ʈ");
					System.out.println(
						table.getSelectedColumn()+ "�� / "+
						table.getSelectedRow() + "���� ���õǾ����ϴ�."
					);
					System.out.println("���õ� ��: " + 
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
