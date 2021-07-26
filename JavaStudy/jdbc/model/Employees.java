package jdbc.model;

public class Employees {

	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String job_id;
	private int salary;
	private int department_id;
	
	public Employees(int employee_id, String first_name, String last_name, 
			String email, String job_id, int salary, int department_id) {
		
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.job_id = job_id;
		this.salary = salary;
		this.department_id = department_id;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getJob_id() {
		return job_id;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public int getDepartment_id() {
		return department_id;
	}

	@Override
	public String toString() {
		return String.format("사원번호: %d/이름: %s%s/이메일: %s/직책: %s/월급: %d/부서번호: %d", 
				employee_id, last_name, first_name, email, job_id, salary, department_id);
	}
}
