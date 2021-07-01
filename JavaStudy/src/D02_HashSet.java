import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class D02_HashSet { //+ List, Set은 콜렉션이다

	/*
		# Set
		  
		  - 집합을 구현해놓은 클래스
		  - 요소로 같은 값이 들어오는 것을 허용하지 않는다
		  
		# Hash 
		
		  - 이름에 Hash가 붙어있는 클래스는 Hash 알고리즘을 사용한다. //+ 비밀번호 저장시에 많이 사용함..입력한 값을 변환해버리기 때문에 되돌릴 수 없음
		  - 같은 값을 넣으면 항상 일정한 값이 나오는 알고리즘
		  - 비슷한 다른 값을 넣더라도 전혀 예측 불가능한 값이 나와야 한다
		  - Hash 알고리즘으로 구현된 클래스들은 순서가 존재하지 않는다
		  - 중복 체크시에 뛰어난 성능을 보인다
	*/
	
	public static void main(String[] args) {
		
		HashSet<Integer> numbers = new HashSet<>();
		
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		numbers.add(50);
		numbers.add(50);
		numbers.add(50);
		numbers.add(60);
		
		System.out.println(numbers); //+ [50, 20, 40, 10, 60, 30] 출력
		
		// HashSet에는 index가 없기 때문에 값으로만 지울 수 있다
		numbers.remove(50); //+ 50이 지워짐 나머지만 출력됨 1개씩
		
		// HashSet은 index가 없기 때문에 for-each만 사용할 수 있다
		for(Integer number : numbers) {
			System.out.println(number + "-------");
		}
		
		//컬렉션끼리는 변환이 자유롭다
		ArrayList<Integer> number_list = new ArrayList<>(numbers); //+ ()에 numbers을 넣을 수 있다		
		System.out.println(number_list); //+ [20, 40, 10, 60, 30]	
		
		// 컬렉션은 아주 쉽게 크기순으로 정렬할 수 있다
		Collections.sort(number_list); 		
		System.out.println("정렬 후 : " + number_list); //+ 정렬 후 : [10, 20, 30, 40, 60]
		
		// Collections.addAll(Collections) 컬렉션의 모든 내용을 다른 컬렉션에 추가하기 	
		ArrayList<String> animals_list = new ArrayList<>(); //+ String은 상속이 막혀있다
		HashSet<String> animals = new HashSet<>();
		
		animals_list.add("dog");
		animals_list.add("cat");
		animals_list.add("cow");
		animals_list.add("lion");
		animals_list.add("tiger");
		
		animals.add("lion");
		animals.add("tiger");
		animals.add("horse");
		animals.add("zebra");
		animals.add("giraffe");
		
		animals_list.addAll(animals); //+ animals_list에 animals을 추가한다 == 합집합
		//animals.addAll(animals_list); //+ (2)
		
		System.out.println(animals_list); //+ [dog, cat, cow, lion, tiger, horse, zebra, giraffe, tiger, lion]
		//+ ㄴ 중복제거 안되고 순서대로 출력됨
		System.out.println(animals); //+ [horse, zebra, giraffe, cat, cow, tiger, dog, lion]
		//+ ㄴ 중복제거가 되고 불규칙하게 출력됨(2)
		
		
		// Collections.removeAll(Collections) : 전달한 컬렉션과 같은 내용을 모두 제거 == 차집합
		animals_list.removeAll(animals); 
		System.out.println(animals_list); //+ [dog, cat, cow]

		// Collections.retainAll(Collections) : 두 컬렉션에 모두 존재하는 값만 남김 == 교집합
		HashSet<Double> avg = new HashSet<>();
		HashSet<Double> avg2 = new HashSet<>();
		
		avg.add(1.8);
		avg.add(1.9);
		avg.add(2.0);
		
		avg2.add(2.0);
		avg2.add(38.8);
		avg2.add(40.1);
		
		System.out.println(avg.retainAll(avg2)); //+ true, avg값을 avg2과 비교하여 존재하는 값만 남김
		System.out.println(avg); //+[2.0] , 겹치는 값이 2.0만 있기 때문에 2.0만 출력됨
		
		
	}
}
