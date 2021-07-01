package quiz;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import myobj.Student;
import myobj.sexual.SexualData;

public class D01_StudentList {

	/*
		학생 클래스를 요소로 갖는 ArrayList를 생성하고 학생을 30명 추가해보세요.
		
		1. 각 학생의 점수는 랜덤으로 설정
		
		2. 과목은 국/영/수
		
		3. 30명의 평균 점수를 출력
		
		4. 30명 중 가장 평균 점수가 높은 학생의 성적을 출력
	*/
	
	public static void main(String[] args) {

		ArrayList<Student> student_list = new ArrayList<>();
		
		for (int i = 0; i < 30; ++i) {
			student_list.add(new Student());
		}
		
		for (Student student : student_list) {
			System.out.println(student);
		}
		
		System.out.println("가장 높은 점수 : " + Student.best_avg);
		System.out.println("가장 높은 점수인 학생의 학번 : " + Student.best_avg_snum);
		
		// 내가 푼거..
//		double Aver = 0;
//		int studentID = 0;
//		ArrayList<SexualData> students = new ArrayList<>();
//		
//		for (int i = 0; i < 30; ++i) {
//			students.add(new SexualData());
//			System.out.printf("학번<%02d> : 평균점수[%.2f]\n", i+1, students.get(i).average());
//			if(students.get(i).average() > Aver) {
//				Aver = students.get(i).average();
//				studentID = i;
//			}
//		}
//		System.out.println("-----------------------------------");
//		System.out.printf("☆평균 점수 Top : 학번<%02d> [%.02f]점", studentID +1, Aver);
		
	}	
}
