package quiz;

import java.io.*;
import java.util.*;

public class E01_SaveGame {

	 /*
		간단한 컴퓨터와의 가위바위보 게임을 하나 만들고, 전적을 파일에 저장해보세요
	
	*/
	static Random ran = new Random();		
	static Scanner sc = new Scanner(System.in);
	static String save = "game_result.txt";

	static int[] score = {0, 0, 0};
	
	public static void main(String[] args) {				
		myGame();

		saveGame();	
	}
	
	public static void saveGame() {
		try {
			FileOutputStream out = new FileOutputStream(save);
			
			String str = score[0] + "/" + score[1] + "/" + score[2];
			out.write(str.getBytes());
			
			out.write(("[result]" + Arrays.toString(score) + "\n").getBytes());
			out.write(("\n draw : " + score[0]).getBytes());
			out.write(("\n user win : " + score[1]).getBytes());
			out.write(("\n user lose : " + score[2]).getBytes());

			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public static String resultStr(int user) {
		String srp = "";
		
		if(user == 0) {
			srp = "가위";
		}else if (user == 1) {
			srp = "바위";
		}else if (user == 2) {
			srp = "보";
		}
		return srp;
	}
	
	public static int[] myGame() {
		
		int playCount = 0;
		
		while(playCount < 10) { // 게임 플레이는 5회만 실행..
			playCount++;
			System.out.println("┏━━━━━━━ [ Game Start ] ━━━━━━━┓");
			System.out.print("[scissors(0), rock(1), paper(2)]\n숫자를 입력하세요. > ");
			int user = sc.nextInt();
			int com = ran.nextInt(3); //(0~2사이 중 선택)
			
			if(user > 2) { // 2 이상 입력할 경우 다시 입력..
				System.out.println("다시 숫자를 선택해주세요.");
				continue;
			}else {
				System.out.println("-----[choice]----- ");
				System.out.print("[user] : " + resultStr(user) + ", [computer] : " + resultStr(com));
				System.out.println("\n------------------");
			}
			
			if(user == com) {
				System.out.println("<<result>> draw");
				score[0]++;
			}else if ((user == 0 && com == 2) || (user == 1 && com == 0) || (user == 2 && com == 1)){
				System.out.println("<<result>> [user] win!!");
				score[1]++;
			}else if ((user == 0 && com == 1) || (user == 1 && com == 2) || (user == 2 && com == 0)) {
				System.out.println("<<result>> computer win!!\n[user] lose..");
				score[2]++;
			}else {
				System.out.println("<<result>> error!!!");
			}
			System.out.println("┗━━━━━━━ [ Game Start ] ━━━━━━━┛");
			System.out.print("[result]" + Arrays.toString(score) + "\n");
			System.out.println(" draw : " + score[0]);
			System.out.println(" user win : " + score[1]);
			System.out.println(" user lose : " + score[2]);
			System.out.println("");	
		}
		return score;
	}
}
