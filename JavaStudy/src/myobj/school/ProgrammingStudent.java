package myobj.school;

public class ProgrammingStudent extends Student {
	
	int math;
	int pl; //+프로그래밍 언어
	int al; //+알고리즘
	int ds; //+자료구조
	
	public ProgrammingStudent() {
		super(); //+부모의 생성자를 부른다, 생략 가능함
		math = generateRandomScore();
		pl = generateRandomScore();
		al = generateRandomScore();
		ds = generateRandomScore();
	}
	
	int getSum() {
		return (kor + eng + math + pl + al + ds);
	}
	
	double getAverage() {
		return getSum() / 6.0;
	}
	
	@Override
	public void printGradeCard() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("  이름 : " + name + " │ 총점 :" + getSum() + " 평균 : " + getAverage()); 
		//+ 자식클래스에 name이 없기 때문에 super.name으로 적지 않아도 된다
		System.out.println("  국어\t영어\t수학\tPL\tAL\tDS");
		System.out.println("------------------------------------------------------");
		System.out.printf("  %d\t%d\t%d\t%d\t%d\t%d\t\n", kor, eng, math, pl, al, ds);
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}


}
