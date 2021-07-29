package gui.quiz.hangman;

import java.io.*;
import java.util.*;

import gui.*;

public class HangMan extends StudyFrame {

	/*
		 행맨을 만들어보세요
		 
		 1. 어떤 단어가 답인경우 해당 단어의 길이만큼 _를 출력해준다.
		 
		 ex) apple이 답인경우 _ _ _ _ _를 출력
		 
		 2. 사용자가 알파벳을 하나씩 입력하는 경우 해당 알파벳이 포함되어 있다면 _를 알파벳으로 바꾼다
		 
		 ex) 사용자가 p를 입력했다면 _ p p _ _를 출력
		 
		 3. 사용자가 모든 _를 제거하면 몇 번 만에 맞췄는지 출력해주세요
		 
		 4. 정답 단어는 단어들이 적혀있는 파일에서 하나를 랜덤으로 뽑아주세요
		 
		 ※ 콘솔로 만들기?
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
