package gui.quiz.puzzle;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class SlidingPuzzle implements MouseListener {
	public static void main(String[] args) {
		SlidingPuzzle myGame = new SlidingPuzzle();
		myGame.go();
	}
	
	JFrame myFrame;
	ArrayList<PuzzleTile> myList = new ArrayList<PuzzleTile>();
	PuzzleTile[] square;

	public void go(){
		myFrame = new JFrame("Numeric Sliding Puzzle");
		square = new PuzzleTile[9];
		myFrame.setLayout(new GridLayout(3,3));
		for(int i=0; i < 9; i++){
			PuzzleTile aTile = new PuzzleTile(i);
			myList.add(aTile);
		}
		for(int i=0; i<9; i++ ){
			int index= (int)(Math.random()*myList.size()-1);
			square[i] = myList.get(index);
			square[i].addMouseListener(this); 
			myFrame.getContentPane().add(square[i]);
			myList.remove(index);
		}
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(400,400);
		myFrame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int num = 0, choice = 0;
		boolean done = true;
		int x = e.getComponent().getX();
		int y = e.getComponent().getY();
		for(int i=0; i<9; i++ ){
			if (square[i].getBackground()==Color.WHITE){
				num = i;
			}
		}
		int x2 = square[num].getX();
		int y2 = square[num].getY();
		if((Math.abs(x-x2)< 140 && Math.abs(x-x2)>1 && y==y2) || (Math.abs(y-y2)<140 && Math.abs(y-y2)>1 && x==x2)){
			e.getComponent().setBackground(Color.WHITE);
			square[num].setNumber(((PuzzleTile)e.getComponent()).getNumber());
			square[num].setBackground(Color.darkGray);
		}
		for(int i=0; i<9; i++ ){
			if (square[i].getBackground() == Color.WHITE){
				continue;
			}
			if (!square[i].getNumber().equals("" + i)){
				done = false;
				break;
			}
		}
		if (done == true){
			choice = JOptionPane.showConfirmDialog (null, "Would you like to play again?", "You have won!!", 
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (choice == JOptionPane.YES_OPTION){
				myFrame.setVisible(false);
				SlidingPuzzle myGame = new SlidingPuzzle();
				myGame.go();
			}
			if (choice == JOptionPane.NO_OPTION){
				System.exit(0);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getComponent().getBackground()!= Color.WHITE){
			e.getComponent().setBackground(Color.GRAY);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getComponent().getBackground()!= Color.WHITE){
			e.getComponent().setBackground(Color.darkGray);
		}
	}

}
