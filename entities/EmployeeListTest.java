package entities;

public class EmployeeListTest {
	private Integer id;
	private String name;
	private double salary;

	public EmployeeListTest() {
	}

	public EmployeeListTest(Integer id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void increaseSalary(double perc) {
		this.salary += this.salary * perc / 100;
	}

	@Override
	public String toString() {

		return id+", " + name + ", " + String.format("%.2f", salary);
	}

}
