package myobj;

import java.util.ArrayList;

public class Jiphap {

	static ArrayList<String> vehicle;
	static ArrayList<String> trip_vehicle;
	
	public Jiphap() {
		vehicle = vehicle1();
		trip_vehicle = vehicle2();
	}
	
	static ArrayList<String> vehicle1() {
		ArrayList<String> trip_traffic = new ArrayList<>();
		trip_traffic.add("airplane");
		trip_traffic.add("train");
		trip_traffic.add("subway");
		trip_traffic.add("ownCar");
		trip_traffic.add("ship");
		trip_traffic.add("boat");
		trip_traffic.add("tourBus");
		trip_traffic.addAll(trip_traffic);
		
		return trip_traffic;
	}
	
	static ArrayList<String> vehicle2() {
		ArrayList<String> transportation = new ArrayList<>();
		transportation.add("bus");
		transportation.add("texi");
		transportation.add("subway");
		transportation.add("motorcycle");
		transportation.add("ownCar");
		transportation.add("bicycle");
		transportation.add("kickboard");
		transportation.addAll(transportation);
		
		return transportation;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Jiphap> vehicle_list = new ArrayList<>();
		vehicle_list.add(new Jiphap());
		System.out.println(vehicle_list);
		
	}
}
