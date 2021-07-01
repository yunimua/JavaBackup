import java.util.ArrayList;

public class D01_ArrayList {

	/*
		# Java Collections
		
		  - 자바에서 기본적으로 제공하는 자료구조 인터페이스
		  - Collections 인터페이스를 구현한 클래스는 List, Set 등이 있다
		  
		  
		# Java.util.ArrayList
		
		  - 배열과 유사하지만 크기가 자동으로 조절되는 자료구조 클래스
		  - 배열처럼 데이터를 순차적으로 저장한다
		  - 순차적으로 모든 데이터에 접근해야 할 때 가장 유리하다
	*/
	
	public static void main(String[] args) {
		
		/*
			# 타입을 지정하며 ArrayList 생성하기
			 - 타입을 지정할 때 사용하는 <>를 제네릭(Generic)이라고 부른다
			 - 해당 클래스 내부의 아직 지정되지 않은 타입을 지정하는 문법이다
			 - 제네릭에는 기본형 타입을 사용할 수 없다 (ex : int byte..)
		*/
		ArrayList<String> fruits = new ArrayList<>();//+ String타입만 들어올 수 있는 ArrayList 이다
		ArrayList<Integer> numbers = new ArrayList<>(); //+ Integer : 기본형 타입의 참조타입 (int는 쓸수없다)
		ArrayList<Character> chars = new ArrayList<>();
		ArrayList<Character> chars2 = new ArrayList<>();
		
		chars.add('A');
		chars.add('B');
		chars.add('한');
		chars.add('뙗');
		
		chars2.add('A');
		chars2.add('B');
		chars2.add('한');
		chars2.add('뙗');
		
//		if (chars == chars2) {
//			System.out.println("일치");
//		}else {
//			System.out.println("불일치");
//		} // 같은 값이 들어있어도 일치하지않으므로 if 문 사용 불가
			
		// add(item) : 리스트의 맨 뒤에 원하는 데이터를 추가한다
		fruits.add("apple");
		fruits.add("apple");
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("banana"); //+ 마지막줄 기준, [apple, apple, apple, banana, banana] 출력됨	
			
		// add(index, item) : 리스트의 원하는 위치에 데이터를 추가한다
		numbers.add(0, 10);
		numbers.add(0, 20);
		numbers.add(0, 99);
		numbers.add(0, 40);
		numbers.add(0, 0);
		numbers.add(0, 60);
		//+ [10, 20, 99, 40, 0, 60] 순차적으로 데이터를 저장한다 (숫자 정렬을 하지않음)
		//+ 0, 을 추가하면 [60, 0, 40, 99, 20, 10] 으로 출력된다
		
		System.out.println(fruits);
		System.out.println(numbers);
		
		// get(index) : 리스트에서 해당 인덱스의 데이터를 하나 반환한다
		System.out.println(fruits.get(3)); //+ banana (4번째꺼)
		System.out.println(fruits.get(0)); //+ apple (1번째꺼)
		
		// size() : 해당 컬렉션의 크기를 반환한다
		System.out.println("현재 들어있는 과일 개수 : " + fruits.size()); //+현재 들어있는 과일 개수 : 5
		
		// remove(index) : 해당 번째 데이터를 삭제한다. 방금 지운 데이터를 반환한다.	
		System.out.println(fruits.remove(0));

//		//+ 예외처리		
//		try {
//			while (true) {
//				System.out.println(fruits.remove(0));
//			}
//		}catch (IndexOutOfBoundsException e) {
//			System.out.println("다 꺼냈네요.");
//		}
		
		// remove(item) : 해당 값을 삭제한다. 삭제 성공 여부를 반환한다.
		System.out.println(fruits.remove("kiwi")); //+ false : 키위없음
		System.out.println(fruits.remove("banana")); // + true : 바나나 있음
		
		System.out.println(fruits); //+ 인덱스로 애플 1개 삭제, 바나나 1개 삭제되어 [apple, apple, banana] 가 출력
	}
}
