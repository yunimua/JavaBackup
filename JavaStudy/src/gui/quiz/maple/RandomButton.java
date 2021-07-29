package gui.quiz.maple;

import java.util.*;

import javax.swing.*;

public class RandomButton extends JButton{
	
	static String[] stat_labels = {"힘", "민첩", "지능", "행운", "공격력"}; // 스텟 배열
	static int[] max_stats = {7, 7, 7, 7, 3}; // 스텟 최대치 배열
	
	Random ran; // 랜덤생성

	public RandomButton() {
		super("None");
		ran = new Random();
	}
	
	public void roll() {
		int value = ran.nextInt(stat_labels.length);
		setText(stat_labels[value] + " " + (ran.nextInt(max_stats[value]) + 1));
		// stat_labels[value] : 앞에 스텟이름이 붙고 + ran.nextInt(max_stats[value]) + 1)으로 최대치 스텟이 랜덤하게 1~7, 1~3이 붙는다
	}
	
}
