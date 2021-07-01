import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import myobj.Student;

public class D06_TreeSet {

	/*
		# TreeSet
		
		  - 순서가 있는 Set (순서가 없는 것은 Hash의 특징)
		  - 중복은 허용하지 않는다 (Set의 특징)
		  - 처음 Set에 데이터를 추가할 때 값을 정렬해서 넣기 때문에 HashSet에 비해 저장 속도가 느리다
		  - 미리 정렬이 되어 있기 때문에 정렬된 순서로 값을 꺼내기 편리한 Set이다
		  - 해당 TreeSet 인스턴스에서 사용할 Comparator를 지정할 수 있다
	*/
	public static void main(String[] args) {
		TreeSet<Integer> numbers = new TreeSet<>();
		
		numbers.add(10);
		numbers.add(99);
		numbers.add(86);
		numbers.add(41);
		numbers.add(50);
		numbers.add(13);
		
		System.out.println(numbers); //+ [10, 13, 41, 50, 86, 99] : 크기 순서대로 정렬되어있음(넣은순서X)
		
		// TreeSet에 원하는 Comparator를 사용하기 (정수 내림차순)
		TreeSet<Integer> numbers2 = new TreeSet<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) { //+익명 이너클래스(내부) 방식
				/*
					자리를 바꾸고 싶다면 양수 리턴 //+ 큰수에서 작은 수를 빼면 양수가 되므로 자리가 바뀌어서 내림차순이 된다
					자리를 바꾸기 싫으면 음수 리턴
					두 값이 같은 값이면 0 리턴				
				*/
				return o2 - o1;
			}
		});
		
		numbers2.addAll(numbers);
		System.out.println(numbers2);  //+ [99, 86, 50, 41, 13, 10] 내림차순으로 정렬된다
		
		
		// * TreeSet은 Set의 일부분을 리턴하는데에 특화된 기능이 많다
		SortedSet<Integer> head = numbers.headSet(44);
		System.out.println(head); //+ [10, 13, 41]
		
		SortedSet<Integer> tail = numbers.tailSet(44);
		System.out.println(tail); //+ [50, 86, 99] : 입력한 값이 기준점이 된다
		
		// 미리 정렬해놓은 방향과 반대 방향인 Set 인스턴스를 반환한다
		NavigableSet<Integer> desc = numbers.descendingSet();
		System.out.println(desc); //+ [99, 86, 50, 41, 13, 10] : numbers2와 동일한 효과
		
		System.out.println("first ? " + numbers.first()); //+ first ? 10
		System.out.println("last ? " + numbers.last()); //+ last ? 99
		System.out.println("pollFirst ?" + numbers.pollFirst());
		System.out.println(numbers); //+ [13, 41, 50, 86, 99] : 가장 낮은 값을 지우고 null, 나머지 값만 표시
		System.out.println("pollFirst ?" + numbers.pollLast());
		System.out.println(numbers); //+ [13, 41, 50, 86] : 가장 높은 값을 지우고 null, 나머지 값만 표시
		
		//numbers.subSet(30, 70); //+ sub => 부분 집합, 30부터 70사이의 값을 반환받겠다
		System.out.println("subSet(30, 70) ? " + numbers.subSet(30, 70)); //+ subSet(30, 70) ? [41, 50]
			
		System.out.println(numbers.comparator()); //+ 어떤 분류기를 사용했는지 파악하기 위해 사용 (=자연스러운 순서를 사용하는 경우 null을 반환)
		System.out.println(numbers2.comparator()); //+ D06_TreeSet$1@1e81f4dc 주소값이 나옴..뽑아서 재활용가능? (장점), 수정불가, 익명 클래스 꺼내서 사용가능
		
		TreeSet<Integer> numbers3 = new TreeSet<>(numbers2.comparator()); //+ 다 내림차순으로 들어간다
		
		List<Integer> list = new ArrayList<>(numbers);
		Collections.sort(list, numbers2.comparator());
		
		System.out.println("list : " + list); //+  [86, 50, 41, 13]
		
		System.out.println("contains 41 ? " + list.contains(41)); //+ contains 41 ? true
		System.out.println("contains 41 ? " + list.contains(42)); //+ list에 42가 있니? : contains 41 ? false
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(41);
		
		// 아래의 코드가 true가 나오도록 null을 다른 것으로 바꿔보세요 (3가지 이상)
		//System.out.println(list.containsAll(null));
		// list, numbers, numbers3 / true , numbers2 / false
		
		System.out.println(list.containsAll(numbers2.subSet(43, 41)));
		System.out.println(list.containsAll(numbers));
		System.out.println(list.containsAll(list));
		
		// 학생 인스턴스를 100개 만들고, 트리셋에 평균 점수 순으로 저장한 후
		// 평균 점수가 50점에서 70점 사이인 학생이 모두 몇명인지 세어보세요
		
		TreeSet<Student> stu_set = new TreeSet<>();
		
		//stu_set.add(new Student()); // 이렇게넣으면 오류!!!, 비교가 안되니까 안됨 : public class Student implements Comparable<Student>{ 으로 변경
		
		for (int i = 0; i < 100; ++i) {
			stu_set.add(new Student());
		}
		
		System.out.println(stu_set);
		System.out.println("학생은 총 " + stu_set.size() + "명 입니다."); //+ 같은 사람을 제외시켜버려서 100명이 출력되지 않음
		
		Student from = new Student();
		Student to = new Student();
		
		from.avg = 50.0;
		to.avg = 70.0;
		
		System.out.println(stu_set.subSet(from, to).size());
		
		
		//내가 푼거..
		ArrayList<Student> students = new ArrayList<>();

		for (int i = 0; i < 100; ++i) {
			students.add(new Student());
		}

		TreeSet<Student> average = new TreeSet<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return (int) (o2.avg - o1.avg);
			}
		});
		
		average.addAll(students);
		System.out.println(average); // 평균 내림차순 정렬됨...
		
		System.out.println("check : " + average.subSet(new Student(70,70,70), new Student(49,49,49)).size());
		
		
		
		
		System.out.println("---------------------------------------------------------------------------------");
	}
}


