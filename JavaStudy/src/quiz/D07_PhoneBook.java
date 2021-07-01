package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class D07_PhoneBook {

	public static class Info implements Comparable<Info>{
		String name;
		int bookNumber;
		
		public void info(String name, int bookNumber) {
			this.name = name;
			this.bookNumber = bookNumber;
		}

		@Override
		public int compareTo(Info o) {
			return this.name.compareTo(o.name) != 0 ? 
					this.name.compareTo(o.name) : Integer.compare(this.bookNumber, o.bookNumber);
		}
		
		@Override
		public String toString() {
			return String.format(name, bookNumber);
		}
	}

	HashMap<String, HashMap<String, Info>> phonebook; //+ 그룹명 < 전화번호, info>
	public D07_PhoneBook() {
		phonebook = new HashMap<>();
	}
	
	/*
		# HashMap을 이용해 전화번호부를 구현해보세요
		
		1. phonebook에는 그룹/ 전화번호 / 정보를 저장할 수 있다
		2. 그룹명을 키값으로 넣으면 해당 그룹에 해당하는 HashMap을 꺼낼 수 있다
		3. 꺼낸 HashMap에 전화번호를 넣으면 그 사람의 정보를 꺼낼 수 있다	
		
		# 구현해야 할 메서드
		
		1. 새로운 그룹을 추가하는 메서드
		2. 그룹에 새로운 전화번호를 등록하는 메서드
		3. 등록된 모든 번호를 선택한 항목(info의 필드?) 기준으로 오름/내림차순으로 보여주는 메서드
		4. 이름의 일부를 입력하면 일치하는 모든 정보가 출력되는 메서드
		5. 전화번호의 일부를 입력하면 일치하는 모든 정보가 출력되는 메서드
	*/
	
	public void addGroup(String group) {
		if(!phonebook.containsKey(group)) { //+ containsKey : phonebook맵에 (group)키값이 있는지 확인
			phonebook.put(group, new HashMap<String, Info>());
		}else {
			System.out.println("-----동일한 그룹명이 있습니다.-----");	
		}
	}

	public void addTel(String group, String tel, Info info) {
		phonebook.get(group).put(tel, info);
	}
	
	public static void main(String[] args) {
		D07_PhoneBook pb = new D07_PhoneBook();		
		String group;
		String tel;
		String name;
		int bookNumber;

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("그룹명 입력 > ");
			group = sc.nextLine();
			pb.addGroup(group);
		}
	}
}
