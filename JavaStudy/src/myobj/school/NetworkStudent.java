package myobj.school;

public class NetworkStudent extends Student {

	int linux;
	int nw;
	int ccna;
	
	public NetworkStudent() {
		linux = generateRandomScore();
		nw = generateRandomScore();
		ccna = generateRandomScore();
	}
	
	int getSum() {
		return (kor + eng + linux + nw + ccna);
	}
	
	double getAverage() {
		return getSum() / 5.0;
	}
	
	@Override
	public void printGradeCard() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("  檜葷 : " + name + " 弛 識薄 :" + getSum() + " ゎ敕 : " + getAverage()); 
		System.out.println("  措橫\t艙橫\tLN\tNW\tCA");
		System.out.println();
		System.out.printf("  %d\t%d\t%d\t%d\t%d\t\n", kor, eng, linux, nw, ccna);
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
	}

}
