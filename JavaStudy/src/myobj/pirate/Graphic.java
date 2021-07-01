package myobj.pirate;

public class Graphic {
	
	public static void printTong(MrTong tong) { //+ (boolean[] stabbed)을 넣고 생성했었음(1안)
		
		boolean[] stabbed = tong.getStabbed();
		
		for (int i = 0, len = stabbed.length; i < len; ++i) {
			
			System.out.print(!stabbed[i] ? "O " : "X "); // false가 O로 표시, true는 X표시
			
			if (i % 15 == 14) {
				System.out.println();
			}
		}
	}
}
