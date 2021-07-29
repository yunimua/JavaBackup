package gui.quiz.GridPuzzle;

import java.awt.*;

import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;

import gui.quiz.*;

public class GridPuzzle extends JFrame {

	/*
		숫자 퍼즐
		버튼, 메뉴 만들기
	*/
	
	private ArrayList<JButton> num_pads;
	private String image_path;
	
	public GridPuzzle() throws IOException { 
		this(3);
	}
	
	public GridPuzzle(int gameSize) throws IOException {
		super(String.format("숫자퍼즐게임:%d%d", gameSize, gameSize));
		
		image_path = "./image/cat01.jpg";

		JPanel num_penel = new JPanel(new GridLayout(gameSize, gameSize));
		JPanel menu_penel = new JPanel(new BorderLayout());
		
		num_pads = new ArrayList<>();
		
		for (int i = 0, len = gameSize*gameSize; i < len; ++i) {
			NumPad new_pad = new NumPad(
					i, 
					gameSize, 
					num_pads, 
					resizedBufferedImage()); 
			num_pads.add(new_pad);
			num_penel.add(new_pad);
		}
		add(num_penel, "Center");
		add(menu_penel, "East");
		
		// shuffle();
		
		setResizable(false);
		setIconImage(ImageIO.read(new File("./image/GridNumberPuzzle.jpg")));
		setBounds(800, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private BufferedImage resizedBufferedImage() throws IOException {
		BufferedImage img = ImageIO.read(new File(image_path));
		int oriW = img.getWidth();
		int oriH = img.getHeight();
		int newW = 700;
		int newH = 700; 
		BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
		Graphics2D g = dimg.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
						RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(img, 0, 0, newW, newH, 0, 0, oriW, oriH, null);
		g.dispose();
		return dimg;
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// 내가풀었던거..
//	public GridPuzzle() {
//		super();
//		
//		JMenuBar bar = new JMenuBar();
//		JMenu option = new JMenu("Game option");
//		
//		JMenuItem option_menu1 = new JMenuItem("New Game");
//		JMenuItem option_menu2 = new JMenuItem("Shuffle");
//		JMenuItem option_menu3 = new JMenuItem("reset");
//		
//		setJMenuBar(bar);
//		bar.add(option);
//		
//		option.add(option_menu1);
//		option.add(option_menu2);
//		option.add(option_menu3);
//		
//		
//		// 버튼 이동이 아니라 텍스트를 맞바꾼다..
//		setLayout(new BorderLayout());
//		JPanel center_panel = new JPanel();
//		
//		add(center_panel, "Center");
//		
//		center_panel.setLayout(new GridLayout(3,3));
//		
//		// 버튼에 이름넣기		
//		ArrayList<JButton> btns = new ArrayList<>();
//		for (int i = 1; i < 9; ++i) {
//			JButton btn = new JButton("" + i);
//			//btn.setFont(new Font("고딕체", Font.BOLD, 20));
//			btns.add(btn);
//			center_panel.add(btn);
//		}
//		btns.add(new JButton(" ")); // btns.get(8) 추가..
//		center_panel.add(btns.get(8));
//		
//		
//		
//		btns.get(7).addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (btns.get(8).equals(btns.get(7))) {
//					btns.get(7).setText("8");
//					btns.get(8).setText(" ");	
//				}else {
//					btns.get(7).setText(" ");
//					btns.get(8).setText("8");
//				}
//				
//			}
//		});
//	}
//	
//	public static void main(String[] args) {
//		GridPuzzle frame = new GridPuzzle();
//		frame.setDefaultOptions();
//	}
//}
