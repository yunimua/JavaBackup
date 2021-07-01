package myobj;

public class Btv {
	
	boolean power;
	int channel;
	Btv_Favorites[] chan;
	int fav;
	final int MAX_CHANNEL = 6;

	Btv() {
		chan = new Btv_Favorites[MAX_CHANNEL];
	}
	void power() {
		power = !power;
	}
	
	void powerChk() {
		System.out.printf("BtvÀÇ Àü¿øÀº %s.\n", power ? "ÄÑÁ®ÀÖ½À´Ï´Ù" : "²¨Á®ÀÖ½À´Ï´Ù.");
	}
	
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
	
	boolean chkFavorites() {
		return fav == MAX_CHANNEL;
	}
	void fv1() {
		if (chkFavorites()) {
			System.out.println("Áñ°ÜÃ£±â ÀúÀå¼Ò°¡ °¡µæ Ã¡½À´Ï´Ù.");
			return;
		}
		chan[fav++] = new Btv_Favorites("TVN", 3);
	}
	void fv2() {
		if (chkFavorites()) {
			System.out.println("Áñ°ÜÃ£±â ÀúÀå¼Ò°¡ °¡µæ Ã¡½À´Ï´Ù.");
			return;
		}
		chan[fav++] = new Btv_Favorites("JTBC", 15);
	}
	void fv3() {
		if (chkFavorites()) {
			System.out.println("Áñ°ÜÃ£±â ÀúÀå¼Ò°¡ °¡µæ Ã¡½À´Ï´Ù.");
			return;
		}
		chan[fav++] = new Btv_Favorites("SBSPLUS", 28);
	}
}
