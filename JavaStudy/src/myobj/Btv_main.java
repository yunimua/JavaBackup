package myobj;

public class Btv_main {
	
	public static void main(String[] args) {
		Btv tv = new Btv();
		
		tv.power();
		tv.powerChk();
		System.out.println("-------");
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		System.out.println("현재 채널은 " + tv.channel + "입니다.");
		tv.fv1();
		System.out.println("즐겨찾기에 " + tv.chan[0].name + "을 추가하였습니다.");
		tv.channelUp();
		tv.channelUp();
		tv.channelDown();
		System.out.println("현재 채널은 " + tv.channel + "입니다.");
	}
}
