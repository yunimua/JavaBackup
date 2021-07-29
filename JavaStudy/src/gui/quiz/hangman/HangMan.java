package gui.quiz.hangman;

import java.io.*;
import java.util.*;

import gui.*;

public class HangMan extends StudyFrame {

	/*
		 ����� ��������
		 
		 1. � �ܾ ���ΰ�� �ش� �ܾ��� ���̸�ŭ _�� ������ش�.
		 
		 ex) apple�� ���ΰ�� _ _ _ _ _�� ���
		 
		 2. ����ڰ� ���ĺ��� �ϳ��� �Է��ϴ� ��� �ش� ���ĺ��� ���ԵǾ� �ִٸ� _�� ���ĺ����� �ٲ۴�
		 
		 ex) ����ڰ� p�� �Է��ߴٸ� _ p p _ _�� ���
		 
		 3. ����ڰ� ��� _�� �����ϸ� �� �� ���� ������� ������ּ���
		 
		 4. ���� �ܾ�� �ܾ���� �����ִ� ���Ͽ��� �ϳ��� �������� �̾��ּ���
		 
		 �� �ַܼ� �����?
	*/
	public static void wordCheck() {
		
		ArrayList<String> word_list = new ArrayList<>();
		
		File word = new File("./words.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(word))){
			String line;
			while ((line = br.readLine()) != null) {
				word_list.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Random ran = new Random();
		
		
		
	}

	public static void main(String[] args) {

	}
}
