package jdbc.model;

public class Departments {

	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
	
	public Departments(int department_id, String department_name, int manager_id, int location_id) {
		this.department_id = department_id;
		this.department_name = department_name;
		this.manager_id = manager_id;
		this.location_id = location_id;
	}
	
	//+ get 쓰고 Ctrl+스페이스를 누르면 자동완성이 된다
	public int getDepartment_id() {
		return department_id;
	}
	
	public String getDepartment_name() {
		return department_name;
	}
	
	public int getLocation_id() {
		return location_id;
	}
	
	public int getManager_id() {
		return manager_id;
	}
	
	@Override
	public String toString() {
		return String.format("%d/%s/%d/%d", department_id, department_name, manager_id, location_id);
	}
}
