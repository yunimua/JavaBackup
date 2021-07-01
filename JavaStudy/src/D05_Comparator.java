import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class D05_Comparator {

	/*
		# Comparable
		
		  - 이 인터페이스를 구현한 클래스는 서로 크기가 비교 가능한 클래스가 된다
		  - 이 인터페이스를 구현한 클래스는 Collections의 정렬 기능을 이용할 수 있다	
		  
		# Comparator
		
		  - 이 인터페이스를 구현한 클래스는 비교의 기준으로 사용된다
	*/
	
	public static void main(String[] args) {
		
		//+ Snack 타입이다 = 새로운 타입 : 문자열이 아니다
		Snack s1 = new Snack("허니버터칩", "롯데", "허니버터맛", 600, 2000);
		Snack s2 = new Snack("프링글스", "한국P&G", "양파맛", 800, 2000);
		Snack s3 = new Snack("칸쵸", "롯데", "초코", 250, 1000);
		Snack s4 = new Snack("홈런볼", "해태제과", "초코", 359, 1750);
		Snack s5 = new Snack("포스틱", "농심", "감자맛", 700, 1200);	
		
		Snack s6 = new Snack("죠리퐁", "크라운제과", "감자맛", 445, 590);	
		Snack s7 = new Snack("바나나킥", "농심", "바나나맛", 150, 1200);	
		Snack s8 = new Snack("꼬북칩", "오리온", "초코츄러스맛", 790, 883);	
		
		//System.out.println(s1 > s2); // 크기비교를 하려면? 그냥 타입 이름으로는 비교 불가
		
		ArrayList<Snack> snacks = new ArrayList<>();
		
		Collections.addAll(snacks, s1, s2, s3, s4, s5);
		
		System.out.println(snacks); //+ 그냥 출력하면 주소값, toString 오버라이드해서 내용 추가
		
		Collections.sort(snacks, new 과자진열대());
		System.out.println(snacks);
		
		Collections.sort(snacks, new 과자분류기());
		System.out.println(snacks);
		
		Comparator<Snack> reversed_과자분류기 = Collections.reverseOrder(new 과자분류기());
		
		//+ Collections.sort(snacks, new 과자분류기_내림차순());
		//+ 아래와 같이 설정가능
		Collections.sort(snacks, reversed_과자분류기);
		System.out.println(snacks);
		
		Collections.addAll(snacks, s6, s7, s8);
		
		Collections.sort(snacks, new 제조사());
		System.out.println(snacks);
		
	}
}

class Snack implements Comparable<Snack>{
	String name;
	String company;
	String taste;
	int calorie;
	int price;
	
	// 생성자만들기
	public Snack(String name, String company, String taste, int calorie, int price) {
		this.name = name;
		this.company = company;
		this.taste = taste;
		this.calorie = calorie;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s/%s/%dKcal/%d원", name, company, taste, calorie, price);
	}

	@Override
	public int compareTo(Snack o) {
		if(this.price > o.price) {
			return 1; // 1 바꾼다
		}else if (this.price < o.price) {
			return -1; // -1 안바꾼다
		}else {
			return this.name.compareTo(o.name); //같을 경우 이름순으로 가져다 쓴다
		}
	}

	public String getName() {
		return name;
	}
	
	public String getCompany() {
		return company;
	}
	
	public int compareTo_(Snack snack) {
		return this.company.compareTo(snack.company);
	}
}
/*
	제조사 이름 기준 내림차순 정렬을 하되, 같은 제조사라면 과자의 이름으로 오름차순 정렬을 해주세요
	(과자 3개만 더 추가해보기)
*/

class 제조사 implements Comparator<Snack> {

	@Override
	public int compare(Snack o1, Snack o2) {
		if (o1.getCompany().equals(o2.getCompany())) {
			return o1.getName().compareTo(o2.getName());		
		}else {
			return o2.getCompany().compareTo(o1.getCompany());	
		}
	}
}



class 과자분류기_내림차순 implements Comparator<Snack> { 

	@Override
	public int compare(Snack o1, Snack o2) {
		if (o1.calorie > o2.calorie) {
			return -1;
		}else if (o1.calorie < o2.calorie) {
			return 1;
		}else {
			return 0;
		}	
	}
}


class 과자분류기 implements Comparator<Snack> { //+칼로리 기준으로 정렬할수있다 : Collections.sort를 이용하여..

	@Override
	public int compare(Snack o1, Snack o2) {
		if (o1.calorie > o2.calorie) {
			return 1;
		}else if (o1.calorie < o2.calorie) {
			return -1;
		}else {
			return 0;
		}	
	}
}

class 과자진열대 implements Comparator<Snack> {
	
	/*
	 	# Compare 규칙
	 	
			두 값의 자리를 바꾸고 싶으면 1을 리턴
			두 값의 자리를 바꾸지 않고 유지하고 싶으면 -1을 리턴
			두 값이 서로 같은 값이라면 0을 리턴
	*/

	@Override // 과자 진열대가 있다
	public int compare(Snack o1, Snack o2) {
		if (o1.price > o2.price) {
			return 1;
		}else if (o1.price < o2.price) {
			return -1;
		}else {
			return 0;
		}		
	}
}