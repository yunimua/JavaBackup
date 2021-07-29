package gui.quiz;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class PuzzleChange implements ActionListener {
	
	ArrayList<JButton> btns;
	
	public PuzzleChange(ArrayList<? extends JButton> btns) {
		this.btns = (ArrayList<JButton>) btns; 
	}
	
	private void change_backcolor() {
		for (JButton btn : btns) {
			btn.setBackground(new Color((int)(Math.random() * 0xFFFFFF)));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		change_backcolor();
	}
}
