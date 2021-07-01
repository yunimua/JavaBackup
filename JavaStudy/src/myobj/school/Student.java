package myobj.school;

public abstract class Student {
	
	final static int MAX_SCORE = 100;

	static String[] lastNameArray = {
			"강", "고", "구", "권", "김", "나", "박", "이", 
			"최", "남궁", "제갈", "배", "서", "현", "안", "임", "유",
			"백", "오", "신", "양", "진", "독고"};
	
	static String[] firstNameArray = {
			"수환", "의성", "종윤", "지수", "천혁", "소영", "은철", "승모",
			"수빈", "승민", "수영", "덕중", "지호", "한나", "소윤", "두식", 
			"웅빈", "진호"
	};
	
	static String generateRandomName() {
		return lastNameArray[(int)(Math.random() * lastNameArray.length)] 
				+ firstNameArray[(int)(Math.random() * firstNameArray.length)];
	}
	//+ 생성되기 전부터 생성되어 있는 애들은 public Student()에서 바로 사용가능하다
	//+ 처음부터 존재하는 생성자는 static을 붙여 사용할 수 있다
	
	static int generateRandomScore() {
		return (int)(Math.random() * (MAX_SCORE +1));
	}
	
	String name;
	int kor; //+ 국어와 영어는 공통 과목이므로 부모 클래스에 설정
	int eng;
	
	public Student() {
		name = generateRandomName(); //+ 랜덤하게 생성된 이름을 가져온다
		kor = generateRandomScore(); //+ 랜덤하게 생성된 점수를 가져온다
		eng = generateRandomScore();
	}
	
	abstract public void printGradeCard();
	
	public String getName() { //+ 다른패키지에서 import를 할 때 public 설정이 필요하다
		return name;
	}
	
}
