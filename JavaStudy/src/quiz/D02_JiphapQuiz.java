package quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D02_JiphapQuiz<T> { //+ <T> : 아직 지정되지 않은 타입이다. 인스턴스가 생성될 때 타입이 결정된다

	/*
		1. 두 컬렉션을 매개 변수로 전달 받으면 두 컬렉션의 합집합을 Set 타입으로 반환하는 메서드
		
		[1, 2, 3, 4] 합집합 [3, 4, 5] => [1, 2, 3, 4, 5]
		
		2. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 교집합을 Set으로 반환하는 메서드
		
		[1, 2, 3, 4] 교집합 [3, 4, 5] => [3, 4]
		
		3. 두 컬렉션을 매개 변수로 전달 받으면 두 컬렉션의 차집합을 Set으로 반환하는 메서드
		
		[1, 2, 3, 4] 차집합 [3, 4, 5] => [1, 2]
		[3, 4, 5] 차집합 [1, 2, 3, 4] => [5]
		
		를 만들고 테스트해보세요.
	*/
	
	static class Fruit {}
	
	static class Apple extends Fruit {}
	static class Banana extends Fruit {}
	static class Carrot {}
	
	
	public static void main(String[] args) {
		D02_JiphapQuiz<String> jiphap = new D02_JiphapQuiz<>();
		
		List<String> A = new ArrayList<>();
		Set<String> B = new HashSet<>();
		
		A.add("아메리카노");
		A.add("아메리카노");
		A.add("콜드브루");
		A.add("라떼");
		
		B.add("아메리카노");
		B.add("콜라");
		B.add("스프라이트");
		
		System.out.println(jiphap.union(A, B));
		System.out.println(jiphap.Intersection(A, B));
		System.out.println(jiphap.diff(A, B));

		
		D02_JiphapQuiz<Fruit> jiphap2 = new D02_JiphapQuiz<>();
		
		List<Apple> apple_list = new ArrayList<>();
		Set<Banana> apple_set = new HashSet<>();
			
		jiphap2.union(apple_list, apple_set);

	}
	
	//public HashSet<T> union(Collection<T> A, Collection<T> B) { //+ <T>를 쓰려면 static을 제거해야한다
	// + ㄴ T를 상속받은 무언가가 들어올수있다
	public HashSet<T> union(Collection<? extends T> A,Collection<? extends T> B) { //변경 가능		
		HashSet<T> union = new HashSet<>();
		//+합집합
		union.addAll(A);
		union.addAll(B);
		return union;
	}
	
	public HashSet<T> Intersection(Collection<? extends T> A,Collection<? extends T> B) { 
		HashSet<T> inter = new HashSet<>();
		//+교집합 : A와 B의 교집합만 남아있는다
		inter.addAll(A);
		inter.retainAll(B);
		return inter;
	}
	
	public HashSet<T> diff(Collection<? extends T> A,Collection<? extends T> B) { 
		HashSet<T> diff = new HashSet<>();
		//+차집합
		diff.addAll(A);
		diff.removeAll(B);
		return diff;
	}
	
	//+ <Integer> : 이걸 제네릭이라한다
	//+ <Integer>을 제거하면 모든 타입 사용이 가능하나, Object(모든 타입의 부모)가 된다.
	
	

		
		
		
		
//		ArrayList<String> trip_traffic = new ArrayList<>();
//		ArrayList<String> transportation = new ArrayList<>();
//		
//		trip_traffic.add("airplane");
//		trip_traffic.add("train");
//		trip_traffic.add("subway");
//		trip_traffic.add("ownCar");
//		trip_traffic.add("ship");
//		trip_traffic.add("boat");
//		trip_traffic.add("tourBus");
//		
//		transportation.add("bus");
//		transportation.add("texi");
//		transportation.add("subway");
//		transportation.add("motorcycle");
//		transportation.add("ownCar");
//		transportation.add("bicycle");
//		transportation.add("kickboard");
//		
//		System.out.println("1.합집합 : " + sum(trip_traffic, transportation));
//		System.out.println("2.교집합 : " + same(trip_traffic, transportation));
//		System.out.println("3.차집합 : " + differ(trip_traffic, transportation));
//		
//	}
//	
//	public static HashSet sum(Collection trip_traffic, Collection transportation) { //합집합
//		HashSet sum = new HashSet<>();
//		sum.addAll(trip_traffic);
//		sum.addAll(transportation);
//		return sum;
//	}
//	
//	public static HashSet same(Collection trip_traffic, Collection transportation) { //교집합
//		HashSet same = new HashSet<>();
//		same.addAll(trip_traffic);
//		same.retainAll(transportation);
//		return same;
//	}
//	
//	public static HashSet differ(Collection trip_traffic, Collection transportation) {
//		HashSet differ = new HashSet<>();
//		differ.addAll(trip_traffic);
//		differ.removeAll(transportation);
//		return differ;

}
