
public class Employee extends TypeEmployee{

	private String name;
	private String employment;
	private double salary;
	
	Employee(String name, String employment, double salary) {
		this.name = name;
		this.employment = employment;
		this.salary = salary;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	

}
