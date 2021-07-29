package gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class S02_BorderLayout extends JFrame { //+ �������� ��ӹ޾� �ڱ� �ڽ��� �������̵ȴ�.
	
	public S02_BorderLayout() { //+ �θ𿡴ٰ� �ٷ� ������ ������ �ϸ�, ��ӹ��� Ŭ������ �̰� �״�� ������ ���ԵǴ� ����
		super();
		
		// ���� super. �� ��� ������
		setLayout(new BorderLayout(50,15)); //��ư�� ��ư���� >> 50 : ����, 15: ���� ����
		//+ ��ư 5�� �߰�
		add(new JButton("Button1"), BorderLayout.NORTH); //��
		add(new JButton("Button2"), BorderLayout.EAST); //��
		add(new JButton("Button3"), BorderLayout.WEST); //��
		add(new JButton("Button4"), BorderLayout.SOUTH); //��
		add(new JButton("Button5"), BorderLayout.CENTER); //�߾�
		
		// ������ �� : this.setSize(500, 500); // this�� ������
		setSize(500, 500);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	/*
		# BorderLayout
		
		  - �������ϰ� ����� �̷���� ���̾ƿ�
		  - ������Ʈ�� �߰��� �� ��ġ�� �Բ� ������ �� �ִ�.
	*/
	
	public static void main(String[] args) {
		S02_BorderLayout frame = new S02_BorderLayout();

	}
}
