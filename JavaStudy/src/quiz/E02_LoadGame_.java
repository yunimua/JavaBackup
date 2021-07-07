package quiz;

import java.io.*;
import java.util.*;

public class E02_LoadGame_ {
	static Random ran = new Random();		
	static Scanner sc = new Scanner(System.in);
	static String save = "game_result.txt";

	static int[] score = {0, 0, 0}; // draw, win, lose 값을 저장할 배열
	
	public static void main(String[] args) {		
		loadGame();
		
		myGame();

		saveGame();	
		
	}
	
	public static void loadGame() {
		try {
			FileInputStream in = new FileInputStream(save);
			
			byte[] buffer = new byte[1024]; // 저장된 파일을 가져와서 배열에 저장
			int len = in.read(buffer); // 파일 정보를 읽어온다
			System.out.println("[result] : " + new String(buffer, 0, len)); //첫글자에서 마지막 글자까지 출력

			String[] score_list = new String(buffer, 0, 5).split("-"); // 첫글자에서 5번째 글자까지 저장된 기호(-)로 자름
			
			score[0] = Integer.parseInt(score_list[0]); // String 으로 저장한 것을 숫자로 변환 : String "1"을 1로 변환..
			score[1] = Integer.parseInt(score_list[1]);
			score[2] = Integer.parseInt(score_list[2]);
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveGame() {
		try {
			FileOutputStream out = new FileOutputStream(save);

			String str = score[0] + "-" + score[1] + "-" + score[2];
			out.write(str.getBytes());
			
			out.write(("\n draw : " + score[0]).getBytes());
			out.write(("\n user win : " + score[1]).getBytes());
			out.write(("\n computer win : " + score[2]).getBytes());

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
		
		while(playCount < 5) { // 게임 플레이는 5회만 실행..
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
			System.out.println("[result]");	
			System.out.println(" draw : " + score[0]);
			System.out.println(" user win : " + score[1]);
			System.out.println(" computer win : " + score[2]);
			System.out.println("");	
		}
		return score;
	}
}
