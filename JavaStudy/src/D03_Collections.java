import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class D03_Collections {

	/*
		# Collections 클래스
		
		- 컬렉션을 편리하게 다룰 수 있는 다양한 기능들이 모여있는 클래스
	*/
	
	public static void main(String[] args) {
		
		ArrayList<String> foods = new ArrayList<>();
		
		foods.add("햄버거");
		foods.add("돈까스");
		foods.add("돈부리");
		foods.add("청국장");
		foods.add("카라아게");
		foods.add("짜장면");
		
		// 최대값, 최소값
		System.out.println("max food : " + Collections.max(foods)); //+ 가나다순.. 햄버거가 마지막, 처음은 돈까스
		System.out.println("min food : " + Collections.min(foods));
		
		// 정렬
		Collections.sort(foods);
		System.out.println("가나다순 정렬 : " + foods);
		
		int[] arr = {1, 7, 3, 5, 13, 1};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		//뒤섞기
		Collections.shuffle(foods);
		System.out.println("섞기 : " + foods);
		
		// 컬렉션에 한번에 여러개 추가하기
		Collections.addAll(foods, "감자튀김", "치즈스틱", "치킨너겟", "오징어튀김", "새우튀김");
		System.out.println("여러개 추가 : " + foods);
		
		foods.add("치킨너겟");
		foods.add("치킨너겟");
		foods.add("치킨너겟");
		
		// 해당 값이 몇 개 들어있는지를 쉽게 검사할 수 있다
		System.out.println(Collections.frequency(foods, "치킨너겟"));
		
		// 컬렉션을 뒤집는다 (= 꺼꾸로 바꾼다)
		Collections.reverse(foods);
		System.out.println(foods); //+ 마지막 추가한 것부터 처음 추가한거까지 출력 치킨너겟 > 햄버거..
		
		// 컬렉션 내부 두 값의 위치를 교환한다
		Collections.swap(foods, 0, 8);
		System.out.println(foods);
		
		// 입력한 숫자만큼 이동
		Collections.rotate(foods, 5); //+ 오른쪽으로 5칸 이동
		System.out.println(foods);
		
		Collections.rotate(foods, -10); //+ 왼쪽으로 10칸이동
		System.out.println(foods);
	}
}
