
	/*
		1. 각 반의 정원은 30명이다
		
		2-1. 프로그래밍 반 학생들은 각자의 국어, 영어, 수학, 프로그래밍 언어, 알고리즘, 자료구조 점수가 있다
		
		2-2. 네트워크 반 학생들은 각자의 국어, 영어, 리눅스, 네트워크, CCNA 점수가 있다
		
		2-3. 머신러닝 반 학생들은 각자의 국어, 영어, 수학, 통계학, 프로그래밍 언어 점수가 있다
		
		3. 모든 학생의 과목별 점수와 이름을 랜덤으로 생성한다
		   학번은 중복없이 순차적으로 생성되어야 한다.(또는 중복없이 랜덤도 가능)
		
		4. 성적표 메서드를 통해 각 학생의 이름/총점/평균점수를 볼 수 있어야 한다.
	
	*/
package quiz;

import myobj.school.ProgrammingStudent;
import myobj.school.Student;
import myobj.school.MachinelearningStudent;
import myobj.school.NetworkStudent;

public class C07_School {
	
	public static void main(String[] args) {
		
		Student[] school = new Student[30];
		
		for(int i = 0; i < school.length; ++i) {
			school[i] = new ProgrammingStudent(); //+ 배열안에 30명의 학생이 들어감
			school[i].printGradeCard();
		}
		
		for(int i = 0; i < school.length; ++i) {
			school[i] = new NetworkStudent();
			school[i].printGradeCard();
		}
		
		for(int i = 0; i < school.length; ++i) {
			school[i] = new MachinelearningStudent();
			school[i].printGradeCard();
		}

	}
	
	
}
//	String[] first_Name = {"김", "이", "서", "도", "최", "박", "윤", "구", "장"};
//	String[] last_Name = {"하나","두나","세나","혜나","지나","영주","민주","지용","수용","기용"};	
//	String[] class_name = {"programming", "network", "Machinelearning"};	
//	String[] class_programming = new String[30];
//	String[] class_network = new String[30];
//	String[] class_Machinelearning = new String[30];
//	
//	//이하는 성적
//	int[] kor = new int[30];
//	int[] mat = new int[30];
//	int[] eng = new int[30];
//	int[] programming = new int[30];
//	int[] algorithm = new int[30];
//	int[] data_structure = new int[30];
//	int[] linux = new int[30];
//	int[] network = new int[30];
//	int[] ccna = new int[30];
//	int[] statistics = new int[30];
//	
//	void name_Produce() {
//		System.out.print("<시험 과목>" + "\t");
//		for(int i = 0; i < 30; ++i) {
//			int first = (int)(Math.random() * 9);
//			int last = (int)(Math.random() * 9);
//			class_programming[i] = first_Name[first] + last_Name[last];
//			System.out.printf("[%02d]%s\t", i+1, class_programming[i]);
//		}
//		System.out.println();
//	}
//	
//	void kor_record() {
//		System.out.print("국어 "+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			kor[i] = (int)(Math.random() * 101);
//			System.out.print(kor[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	void eng_record() {
//		System.out.print("영어"+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			eng[i] = (int)(Math.random() * 101);
//			System.out.print(eng[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	void mat_record() {
//		System.out.print("수학"+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			mat[i] = (int)(Math.random() * 101);
//			System.out.print(mat[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	void algo_record() {
//		System.out.print("알고리즘"+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			algorithm[i] = (int)(Math.random() * 101);
//			System.out.print(algorithm[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	void program_record() {
//		System.out.print("프로그래밍"+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			programming[i] = (int)(Math.random() * 101);
//			System.out.print(programming[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	void date_record() {
//		System.out.print("자료구조"+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			data_structure[i] = (int)(Math.random() * 101);
//			System.out.print(data_structure[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	void record_total() {
//		for(int i = 0; i < 30; ++i) {
//			int total = kor[i] + eng[i] + mat[i] + algorithm[i] + programming[i]+ data_structure[i];
//			int average = total / 6; 
//			System.out.printf("[%s]의 총점은[%d], 평균점수는[%d]입니다.\n", 
//					class_programming[i], total, average);
//		}
//		System.out.println();
//	}
//}
//
//class network extends C07_School {
//	
//	void name_Produce() {
//		System.out.print("<시험 과목>" + "\t");
//		for(int i = 0; i < 30; ++i) {
//			int first = (int)(Math.random() * 9);
//			int last = (int)(Math.random() * 9);
//			class_network[i] = first_Name[first] + last_Name[last];
//			System.out.printf("[%02d]%s\t", i+31, class_network[i]);
//		}
//		System.out.println();
//	}
//	
//	void linux_record() {
//		System.out.print("리눅스"+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			linux[i] = (int)(Math.random() * 101);
//			System.out.print(linux[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	
//	void network_record() {
//		System.out.print("네트워크"+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			network[i] = (int)(Math.random() * 101);
//			System.out.print(network[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	
//	void ccna_record() {
//		System.out.print("CCNA"+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			ccna[i] = (int)(Math.random() * 101);
//			System.out.print(ccna[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	void record_total() {
//		for(int i = 0; i < 30; ++i) {
//			int total = kor[i] + eng[i] + linux[i] + network[i]+ ccna[i];
//			int average = total / 5; 
//			System.out.printf("[%s]의 총점은[%d], 평균점수는[%d]입니다.\n", 
//					class_network[i], total, average);
//		}
//		System.out.println();
//	}
//}
//
//class machinelearning extends C07_School {
//	
//	machinelearning() {
//		
//	}
//	
//	void name_Produce() {
//		System.out.print("<시험 과목>" + "\t");
//		for(int i = 0; i < 30; ++i) {
//			int first = (int)(Math.random() * 9);
//			int last = (int)(Math.random() * 9);
//			class_Machinelearning[i] = first_Name[first] + last_Name[last];
//			System.out.printf("[%02d]%s\t", i+61, class_Machinelearning[i]);
//		}
//		System.out.println();
//	}
//	
//	void statistics_record() {
//		System.out.print("통계학"+"\t"+"\t");
//		for(int i = 0; i < 30; ++i) {
//			statistics[i] = (int)(Math.random() * 101);
//			System.out.print(statistics[i] + "\t" + "\t"); 
//		}
//		System.out.println();
//	}
//	
//	void record_total() {
//		for(int i = 0; i < 30; ++i) {
//			int total = kor[i] + eng[i] + mat[i]+ statistics[i] + programming[i];
//			int average = total / 5; 
//			System.out.printf("[%s]의 총점은[%d], 평균점수는[%d]입니다.\n", 
//					class_Machinelearning[i], total, average);
//		}
//		System.out.println();
//	}
//}