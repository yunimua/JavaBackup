import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import myobj.Student;

public class D07_HashMap {

	/*
		 # Map
		 
		   - 데이터를 key와 Value 한 쌍으로 저장하는 방식의 자료구조
		   - key 값을 통해 Value에 접근할 수 있다
		   - key는 중복을 허용하지 않는다
	*/
	
	public static void main(String[] args) {
		
		// 첫 번째 제네릭은 Key 타입이고, 두번째 제네릭은 Value의 타입니다
		HashMap<String, String> addr = new HashMap<>();
		
		// Map.put(key, value) : 맵에 데이터를 추가한다
		// Map.putAll(Map) : 다른 맵의 데이터를 모두 추가한다
		// Map.putIfAbsent() : 해당 키값이 비어있으면 넣고, 뭔가 있으면 꺼내준다. 넣은 경우 null을 리턴한다
		
		addr.put("우리집", "서울특별시 동작구 노량진1동 ...");  //+ put : 해당 맵에 key와 value를 넣는다
		addr.put("직장", "서울특별시 강남구 강남대로84길 16");
		addr.put("직장2", "서울특별시 종로구 종로3가");
		
		System.out.println(addr.putIfAbsent("우리집", "넣을 수 있다")); //+ 서울특별시 동작구 노량진1동 ...
		System.out.println(addr.putIfAbsent("우리집2", "넣을 수 있다")); //+ null
		
		// 이미 존재하는 키에 값을 추가하면 value를 수정한다
		addr.put("직장", "없어짐"); //+ 직장주소를 덮어쓰기해서 value는 없어짐으로 출력됨
		
		System.out.println(addr.get("우리집"));
		System.out.println(addr.get("직장"));
		System.out.println(addr.get("직장2")); //+ 서울특별시 종로구 종로3가 => value가 나온다..
		System.out.println(addr.get("우리집2")); //+ 넣을 수 있다
		
		// 직접 정의한 타입도 사용할 수 있다 (ex)Student
		HashMap<Integer, Student> students = new HashMap<>(); //+ Collection이 아니라서 사용불가
		
		students.put(1, new Student());
		students.put(2, new Student());
		
		System.out.println(students.get(1)); //+ [1000]번 학생의 평균 점수는 55.33입니다. => 이 출력됨
		System.out.println(students.get(2)); 
		
		// 여러가지 타입을 사용할 수 있다
		HashMap<String, Object> info = new HashMap<>();
		
		info.put("이름", "홍길동");
		info.put("나이", 23);
		info.put("전화번호", "010-1234-1234");
		info.put("좋아하는 것", new String[] {"영화", "운동", "햄버거"});
		info.put("친구 목록", new ArrayList<>());
		
		// 연습문제 : 친구 목록에 데이터를 3개만 추가해보세요.
		//ArrayList<String> friends = (ArrayList<String>) info.get("친구 목록"); //+ 다운캐스팅...
		
//		friends.add("철수");
//		friends.add("영희");
//		friends.add("민수");
		
		((ArrayList<String>) info.get("친구 목록")).add("철수");
		((ArrayList<String>) info.get("친구 목록")).add("영희");
		((ArrayList<String>) info.get("친구 목록")).add("민수");
				
		System.out.println(info.get("친구 목록"));
		
		/*
			# 반복문으로 Map타입 활용하기
			
			  - Map.keySet() : key들로 이루어진 Set을 반환한다
			  - Map.values() : 값들로 이루어진 Set을 반환한다
			  - Map.entrySet() : Entry<key, value>로 이루어진 Set을 반환한다
		*/
		
		System.out.println(info.keySet()); //+ [친구 목록, 좋아하는 것, 이름, 전화번호, 나이] : 넣은 순서가 일정하지않다(HashSet과 같은효과)
		
		for (String key : info.keySet()) { //+ 하나씩 순차적으로 꺼내서 출력할 수 있다
			System.out.println("반복문으로 꺼낸 내용 : " + info.get(key));
		}
		
		System.out.println("--------------------------------------------------------------------");
		
		System.out.println(info.values()); //+ Collection 타입으로 출력됨
		
		List value_list = new ArrayList<>(info.values()); //+ 위와 동일
		System.out.println(value_list);
		
		for (Object value : info.values()) { //+ 순차적으로 꺼낼수 있음
			System.out.println(value);
		}
		
		for (Entry<String, Object> entry : info.entrySet()) { //+ import java.util.Map.Entry (class안에 class가 있다) 필요...
			System.out.print(entry.getKey() + "\t: "); //+ key만 꺼내온다
			System.out.println(entry.getValue()); //+ value만 꺼내온다
		}
	}
}
