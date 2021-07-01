package myobj.pirate;

public class MrTong {
	
	//true : 해당 구멍은 찔린 적 있음
	//false : 해당 구멍은 찔린 적 없음
	boolean[] stabbed;
	boolean[] launch;
	
	//+구멍이 랜덤하게 설정되어야 함
	//int[] launch; //+랜덤 배열 생성
	
	// launched가 true면 통아저씨가 발사된 상태, 발사가 되면 true가 된다
	public boolean launched;
	
	public MrTong(int size) { //+만들때 사이즈가 정해진다
		stabbed = new boolean[size]; //+사이즈는 모두 false로 초기화 될 예정이다
		launch = new boolean[size];
		
		//정답을 우선 1~4개 생성
		for (int i = 0; i < 4 ; ++i) {
			launch[(int)(Math.random() * size)] = true;
		}
	}	

	// 이미 찔린 곳이라면  return false, 아니라면 찌르고 잘 찔렀다며 return true;
	public boolean stab(int index) { //+몇번째를 찌를 것인가, index를 전달받으면 true
		if (stabbed[index]) {//+ 이미 선택된 숫자를 체크하여(index 배열에 담고) false로 담아둔다
			return false; 
		}else {
			stabbed[index] = true;
			launched = launch[index]; //+이하 같은 내용 주석처리되어있음
			return true; //+ 잘찔렀다 (안찔린데다)
		}
	}
	
	public boolean[] getStabbed() { //+가져가서 활용하도록 작성하는 형태로 변경, 얘는 쓰이지 않았네!
		return stabbed;
	}

	
//			 // launched = launch[index]; 과 같은 내용이다!!!!! 
//			if (launch[index] == true) {
//				launched = true;
//			}else {
//				launched = false;
//			}

	
	//+위와 같이 체크할 수 있다...
//	for (int i = 0, len = (int)(Math.random() * 4 + 1); i < len; ++i) {
//		launch[i] = true;
//	} // 이렇게 쓰려면 섞기가 필요함!
	// 위 내용 수정으로 변경
//	launch = new int[(int)(Math.random() * 4 + 1)];
//	
//	int index = 0;
//	while (index < launch.length) {
//		
//		launch[index] = (int)(Math.random() * size);
//		
//		for (int i = 0; i < index; ++i) {
//			
//		}
//	}
	
//	for (int i = 0, len = launch.length; i < len; ++i) {
//		launch[i] = (int)(Math.random() * size);
//	}
//}
	
	//1000번 섞음
//	for (int i = 0; i < 1000; ++i) {
//		int x = (int)(Math.random() * size);
//		int y = (int)(Math.random() * size);
//		
//		boolean temp = launch[x];
//		launch[x] = launch[y];
//		launch[y] = temp;
//	}
	

	//위 조건 내용 수정으로 삭제됨
	//else {
		//stabbed[index] = true; // 이하내용이었음
//	for (int answer : launch) {
//		if (answer == index) {
//			launched = true;
//			return true;
//		}
//	}	

	
	
//	//+찌를 수 있는 번호를 알려주는 배열(제외)
//	public int[] notyet() { //+찔리지 않은 구멍을 리턴해준다
//		//+개수를 세는 방법은? count에 true가 누적된다??
//		int count = 0;
//		
//		// for each //+(a:b) : b에 있는걸 a로 꺼낸다, 1개씩 순차적으로
//		for(boolean stab : stabbed) { //+stabbed에 있는 값을 1개씩 꺼내서 stab에 넣는다(사용한다)
//			if(stab) {
//				count++;
//			}
//		}
//		return null;
//	}
}
