package gui.quiz.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangMan_sy {

	/*
	 	행맨을 만들어보세요
	 	
	 		1. 어떤 단어가 답인 경우 해당 단어의 길이만큼 _를 출력해준다.
	 		
	 			ex) apple 이 답인경우 _ _ _ _ _를 출력
	 		
	 		2. 사용자가 알파벳을 하나씩 입력하면 해당 알파벳이 포함되어 있다면 _를 알파벳으로 바꾼다.
	 		
	 			ex) 사용자가 p를 입력했다면 _ p p _ _를 출력
	 			
	 		3. 사용자가 모든 _를 제거하면 몇 번만에 맞췄는지 출력해주세요.
	 */
	
	
	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<>();
		
		File file = new File("./words.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while ((line = br.readLine()) != null) {
				words.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String answer = words.get((int)(Math.random() * (words.size())));
		
		gameStart(answer);
	}
	
	private static void gameStart(String word) {

		Scanner sc = new Scanner(System.in);
		char[] input = new char[word.length()];
		String c;
		char ch;
		int cnt = 0;
		
		int len = word.length();
		
		// _로 초기화.
		for(int i = 0; i < len; i++) {
			input[i] = '_';
		}
		
		while(!checkResult(word, input)) {
			
			printWord(input);
			
			System.out.print("input a character (try " + cnt + ") >> ");
			
			c = sc.next();
			ch = c.charAt(0);
			if(!Character.isAlphabetic(ch)) {
				System.out.println("no alphabet. input again.");
				continue;
			}
			cnt++;
			for (int i = 0; i < len; i++) {
				if(word.charAt(i) == ch) {
					input[i] = ch;
				}
			}
		}
		
		System.out.println("answer is " + word + ", try count: " + cnt);
		
	}
	
	private static boolean checkResult(String word, char[] input) {
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != input[i]) {
				return false;
			}
		}
		return true;
	}
	
	private static void printWord(char[] input) {
		for(char ch : input) {
			System.out.print(ch + " ");
		}
		System.out.println();
	}
}