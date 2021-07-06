import java.time.*;
import java.time.format.*;

public class D11_Time {

	/*
		# java.time ��Ű��
		
		  - Calendar Ŭ�������� set()�� �ϸ� ���� �ν��Ͻ��� ���ع����ٴ� ������ ������ Ŭ����
		  - java.time ��Ű���� Ŭ�������� �ð��� ������ ���ο� �ν��Ͻ��� ��ȯ�ϴ� ����� ����
		  	���� �ν��Ͻ��� �״�� �����Ѵ�
		  - LocalDate, LoclaTime, LocalDateTime... ���� �ִ�
	*/
	
	public static void main(String[] args) {
		
		// now() : ���� �ð��� �ν��Ͻ��� �����ϴ� �޼���
		
		System.out.println("����ð� : " + LocalTime.now()); //+ �ð��� ����
		System.out.println("���� ��¥ : " + LocalDate.now()); //+ ��¥�� ���� 
		System.out.println("���� ��¥�� �ð� : " + LocalDateTime.now()); //+ ��¥�� �ð��� ����
		
		// of() : ���ϴ� �ð��� �ν��Ͻ��� �����ϴ� �޼���
		System.out.println(LocalTime.of(17, 7, 30, 123456789)); //+ ���ϴ� �ð����� ����(��,��,��) : 17:07:30.123456789
		System.out.println(LocalDate.of(2021, 3, 5)); //+ ���ϴ� ��¥�� ���� : 2021-03-05
		System.out.println(LocalDate.of(2021, Month.SEPTEMBER, 5)); //+ ���ϴ� ���� ���� : 2021-09-05
		
		//+ LocalTime.of�� ���� ���� �Է��� �Ҽ� ������, Month.�� ���� �ٸ� ���ڰ� �Էµ��� �ʰ� ������ �����ϴ�
		
		// Month Ŭ����
		System.out.println(Month.SEPTEMBER.name()); //+ SEPTEMBER
		System.out.println(Month.SEPTEMBER.getValue()); //+ 9
		
		// ����� �ð� �����ϱ�
		LocalDate now = LocalDate.now();
		LocalDate after3years = now.plusYears(3); //+ 3����
		LocalDate before1000years = now.minusYears(1000); //+ 1000����
		
		System.out.println(now);
		System.out.println(after3years); //+ 2024-07-02 : 3����
		System.out.println(before1000years.getDayOfWeek()); //+ TUESDAY : 1000���� ����
		System.out.println(now.getDayOfWeek()); //+ SATURDAY
		
		DayOfWeek dayofweek = now.getDayOfWeek();
		System.out.println("dayofweek : " + dayofweek); //+ dayofweek : SATURDAY
		
		
		// �ð��� ���ڿ��� �����ϱ�
		DateTimeFormatter my_date_format = DateTimeFormatter.ofPattern("y�� M�� d�� E����");
		//+ java.time.format�� ����ִ� �ʵ尪 
		
		String message = my_date_format.format(now);
		
		System.out.println("now : " + message); //+ now �������� 2021�� 7�� 2�� �ݿ���
		
		// �ð� ��ü���� ũ�� ���ϱ�
		int year = 2021;
		LocalDate ��̳� = LocalDate.of(year, 5, 5);
		LocalDate ũ�������� = LocalDate.of(2021, 12, 25);
		LocalDate ��̳�2 = LocalDate.of(2021, 5, 5);
		LocalDate now1 = LocalDate.now();
		
		System.out.println(��̳�.isAfter(ũ��������)); //+ ��̳��� ũ������������ �ڴ�? : false = �ƴϿ�
		System.out.println(��̳�.isBefore(ũ��������)); //+ ��̳��� ũ������������ ���̴�? : true = ��
		System.out.println(��̳�.equals(��̳�2)); //+ true
		System.out.println("(���ó�¥ + ��̳�) : " + ��̳�.equals(now1)); //+ true
		
		String date = "20210701";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate chkDay = LocalDate.parse(date, formatter);
        System.out.println(chkDay); //+ 2021-07-01
        
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("y/M/d E����");
        String check = date_format.format(chkDay);
		System.out.println(check); //+ 2021/7/1 �����
        
        

	}
}
