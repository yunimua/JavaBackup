package gui.quiz.puzzle;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;

import gui.quiz.puzzle.NumPad;

public class GridPuzzle extends JFrame {

	/*
		숫자 퍼즐
		버튼 : 다시하기, 시작하기, 섞기
		메뉴 만들기 : 사이즈 조절
	*/
	
	private ArrayList<JButton> num_pads;
	private ArrayList<Icon> icons;
	
	public GridPuzzle() throws IOException { 
		this(3);
	}
	
	public GridPuzzle(int gameSize) throws IOException { // gameSize : this(3);
		super(String.format("숫자퍼즐게임:%d%d", gameSize, gameSize)); // 타이틀 표시영역
		
		//"./image/y.jpg"

		JPanel num_penel = new JPanel(new GridLayout(gameSize, gameSize));
		JPanel menu_penel = new JPanel(new BorderLayout());
		
		num_pads = new ArrayList<>();
		icons = new ArrayList<>();
		
		BufferedImage image = ImageIO.read(new File("./image/y.jpg"));
		
		for (int y = 0, lenH = image.getHeight(), lenW = image.getWidth(); y < gameSize; y++) { // lenH:높이, lenW:너비
			for (int x = 0; x < gameSize; ++x) {
				icons.add(new ImageIcon((image.getSubimage(x *(lenW/gameSize), y * (lenH/gameSize), 
						(int)(lenW/gameSize), 
						(int)(lenH/gameSize))).getScaledInstance(700/gameSize, 700/gameSize, Image.SCALE_SMOOTH)));
				//Collections.shuffle(icons);
				
				// 1* (700/4):X, 1*(700/4):Y, 700/4 :너비, 700/4: 높이 (자른 이미지)
				// getScaledInstance: 너비, 높이, 테두리효과 (이미지 크기)
			}
		}
		
		for (int i = 0, len = gameSize*gameSize; i < len; ++i) {
			// numPads.add(new NumPad(i, gameSize, num_Pads)); : 첨에 작성했던거..
			NumPad new_pad = new NumPad(i, gameSize, num_pads);
			if (i != len-1) {
				new_pad.setIcon(icons.get(i));
			}
			num_pads.add(new_pad);
			num_penel.add(new_pad);
		}
		add(num_penel, "Center");
		add(menu_penel, "East");
		
		//shuffle();

		setIconImage(ImageIO.read(new File("./image/GridNumberPuzzle.jpg")));
//		setSize(700,700);
//		setLocation(900, 100);
		// 위 두가지를 합친것 : setBounds (setLocation + setSize)
		setBounds(800, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void shuffle() {
		for (int i = 0; i < 100; ++ i) {
			int ran_x = (int)(Math.random() * num_pads.size());
			int ran_y = (int)(Math.random() * num_pads.size());
			
			String temp = num_pads.get(ran_x).getText();
			num_pads.get(ran_x).setText(num_pads.get(ran_y).getText());
			num_pads.get(ran_y).setText(temp);
		}
	}

	public static void main(String[] args) {
		try {
			new GridPuzzle(4);
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("아이콘을 찾을 수 없습니다.");
		}
	}
}

/*
		ArrayList<ImageIcon> gaon = new ArrayList<>();
        try {
            final BufferedImage source = ImageIO.read(new File("./image/gaon.jpg"));
            source.getScaledInstance(gameSize * 100, gameSize * 100, Image.SCALE_SMOOTH);
            for (int y = 0; y < source.getHeight(); y += 100) {
                for (int x = 0; x < source.getWidth(); x += 100) {
                    gaon.add(new ImageIcon(source.getSubimage(x, y, 100, 100)));
                }
            }
        } catch (IOException e) {
            System.out.println("사진을 찾을 수 없습니다.");
            e.printStackTrace();
        }
*/
