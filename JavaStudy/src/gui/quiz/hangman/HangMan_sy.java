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
	 	����� ��������
	 	
	 		1. � �ܾ ���� ��� �ش� �ܾ��� ���̸�ŭ _�� ������ش�.
	 		
	 			ex) apple �� ���ΰ�� _ _ _ _ _�� ���
	 		
	 		2. ����ڰ� ���ĺ��� �ϳ��� �Է��ϸ� �ش� ���ĺ��� ���ԵǾ� �ִٸ� _�� ���ĺ����� �ٲ۴�.
	 		
	 			ex) ����ڰ� p�� �Է��ߴٸ� _ p p _ _�� ���
	 			
	 		3. ����ڰ� ��� _�� �����ϸ� �� ������ ������� ������ּ���.
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
		
		// _�� �ʱ�ȭ.
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