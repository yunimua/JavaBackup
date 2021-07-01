package myinterface;

public class Starex implements Vehicle {

	int speed;
	int max_seat = 10;
	int passengers = 0;
	
	
	@Override
	public int acceleration() {
		return speed += 20;
	}

	@Override
	public int deceleration() {
		return speed -= 50;
	}

	@Override
	public boolean ride() {
		if (passengers == max_seat) { //+ 최대인원일 경우 false
			return false;
		}else {
			passengers++; //+ 탑승 인원 1명씩 증가
			return true;
		}
	}	
}
