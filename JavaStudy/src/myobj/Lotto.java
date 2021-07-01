package myobj;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
	
	static Set<Integer> lottonum;
	static Set<Integer> lottopick;

	static int[] count;
	
	final private static int MAX_NUMBER = 45;
	
	public static Set<Integer> winningLotto() { //당첨 번호
		Set<Integer> lottoNum = new HashSet<>();
		
		while(lottoNum.size() < 7) {
			lottoNum.add((int)(Math.random()*MAX_NUMBER+1));
		}
		//System.out.println("당첨 번호 : " + lottoNum);
		return lottoNum;
	}
	
	public static Set<Integer> pickLotto() { //당첨 번호
		Set<Integer> pickNum = new HashSet<>();
		
		while(pickNum.size() < 6) {
			pickNum.add((int)(Math.random()*MAX_NUMBER+1));
		}
		//System.out.println("선택한 번호 : " + pickNum);
		return pickNum;
	}	
}
