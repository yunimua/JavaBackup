package gui.quiz.maple;

import java.util.*;

import javax.swing.*;

public class RandomButton extends JButton{
	
	static String[] stat_labels = {"��", "��ø", "����", "���", "���ݷ�"}; // ���� �迭
	static int[] max_stats = {7, 7, 7, 7, 3}; // ���� �ִ�ġ �迭
	
	Random ran; // ��������

	public RandomButton() {
		super("None");
		ran = new Random();
	}
	
	public void roll() {
		int value = ran.nextInt(stat_labels.length);
		setText(stat_labels[value] + " " + (ran.nextInt(max_stats[value]) + 1));
		// stat_labels[value] : �տ� �����̸��� �ٰ� + ran.nextInt(max_stats[value]) + 1)���� �ִ�ġ ������ �����ϰ� 1~7, 1~3�� �ٴ´�
	}
	
}
