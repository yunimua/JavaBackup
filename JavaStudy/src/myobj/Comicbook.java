package myobj;

import java.util.Random;
import java.util.TreeSet;

public class Comicbook implements Comparable<Comicbook>{
	
	public int price;
	public int number;
	public double discount;
	
	final private double DISCOUNT_PRICE = 7;
	final private int MAX_PRICE = 15000;
	final private int MIN_PRICE = 1000;
	
	private static int buy_snum = 0;
	private static Random ran = new Random();
	
	public Comicbook() {
		number = buy_snum++; 
		price = (MIN_PRICE) + ran.nextInt(MAX_PRICE +1);
		discount = price / DISCOUNT_PRICE;
	}
	
	@Override
	public int compareTo(Comicbook o) {
		return Double.compare(this.discount, o.discount) != 0 ? 
				Double.compare(this.discount, o.discount) : Integer.compare(number, o.number);
	}
	
	@Override
	public String toString() {
		return String.format("No. : %d, 가격 : %d, 할인 : %.2f\n", number, price, discount);
	}
	
	public static void main(String[] args) {
		
		TreeSet<Comicbook> comic_list = new TreeSet<>();
		
		for (int i = 0; i < 100; ++i) {
			comic_list.add(new Comicbook());
		}

		System.out.println(comic_list.size() + "권");
		System.out.println(comic_list);
		
		Comicbook from = new Comicbook();
		Comicbook to = new Comicbook();
		
		from.discount = 800;
		to.discount = 1100;
	
		System.out.println(comic_list.subSet(from, to).size() + "권");
	}
}
