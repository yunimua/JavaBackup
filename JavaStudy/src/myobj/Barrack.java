package myobj;

public class Barrack {
	
	final int MAX_QUEUE_SIZE = 5;
	
	Barrack_Unit[] queue;
	int queue_index; // 0이니까
	
	Barrack(){
		queue = new Barrack_Unit[MAX_QUEUE_SIZE];
	}
	
	boolean checkMaxQueue() {
		return queue_index == MAX_QUEUE_SIZE;
	}
	
	void createSheep() {
		if (checkMaxQueue()) {
			System.out.println("생산 대기열이 가득 찼습니다! 양을 생산할 수 없습니다!");
			return; 
			// void  타입 함수도 return을 할 수 있다
			// 호출한 곳에 값을 돌려주지는 않고 함수만 종료된다
		}
		queue[queue_index++] = new Barrack_Unit("양", 5);
		System.out.println("양 생산");
	}
	
	void createCow() {
		if (checkMaxQueue()) {
			System.out.println("생산 대기열이 가득 찼습니다! 소를 생산할 수 없습니다!");
			return;
		}
		queue[queue_index++] = new Barrack_Unit("소", 7);
		System.out.println("소 생산");
	}
}
