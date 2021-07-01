package myobj.school;

public class MachinelearningStudent extends Student {

	int math;
	int ss;
	int pl;
	
	public MachinelearningStudent() {
		math = generateRandomScore();
		ss = generateRandomScore();
		pl = generateRandomScore();
	}
	
	int getSum() {
		return (kor + eng + math + ss + pl);
	}
	
	double getAverage() {
		return getSum() / 5.0;
	}
	
	@Override
	public void printGradeCard() {
		System.out.println("┌────────────────────────────────────────────────────┐");
		System.out.println("  이름 : " + name + " │ 총점 :" + getSum() + " 평균 : " + getAverage()); 
		System.out.println("  국어\t영어\t수학\t통계\tPL");
		System.out.println(" ≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡≡");
		System.out.printf("  %d\t%d\t%d\t%d\t%d\t\n", kor, eng, math, ss, pl);
		System.out.println("└────────────────────────────────────────────────────┘");
		
	}
}
