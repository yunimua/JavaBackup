package myinterface;

public class FootballPlay implements FootballPlayer {

	int tackles;
	int slidings;
	int shoots;
	
	@Override
	public void tackle() {
		System.out.println("태클을 합니다.");
		tackles++;
	}

	@Override
	public void sliding() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lobbing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void thru() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pass() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void heading() {
		// TODO Auto-generated method stub
		
	}

}
