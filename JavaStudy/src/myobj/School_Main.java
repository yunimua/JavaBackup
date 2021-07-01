package myobj;

public class School_Main {

	public static void main(String[] args) {
		
		School s = new School();
		Network n = new Network();
		Machinelearning m = new Machinelearning();
		
		System.out.println("==========" + s.class_name[0] + "==========");
		s.Print_title();
		s.programming_class();
		System.out.println();
		System.out.println("==========" + s.class_name[1] + "==========");
		n.Print_title();
		n.Network_class();
		System.out.println();
		System.out.println("==========" + s.class_name[2] + "==========");
		m.Print_title();
		m.Machinelearning_class();
	}
}
