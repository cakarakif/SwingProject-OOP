import java.util.Scanner;

public class Business {
	Scanner sc = new Scanner(System.in);
	private String businessName, temp;
	private Customer[] customers;
	private Employee[] employees;
	private double budget;
	private int dot, place, pot, tableNumber;
	private Order[] menu;

	Business(String businessName, int tableNumber, int employeeNumber, double budget) {
		this.businessName = businessName;
		this.tableNumber=tableNumber;
		menu = new Order[50];
		customers = new Customer[tableNumber];
		employees = new Employee[employeeNumber];
		this.budget = budget;
		dot = 0;
		pot = 0;
	}

	public void addMenu(double price,String temp) {
		Order order;
		order = new Order(temp, price);
		menu[dot] = order;
		dot++;

	}

	public void deleteMenu(String temp) {
		for (int i = 0; i < menu.length; i++) {
			if (menu[i] != null && menu[i].getName().equals(temp))
				menu[i] = null;
		}

	}

	public void addOrder() {
		for (int i = 0; i < customers.length; i++) {
			if (menu[i] != null && menu[i].getName().equals(temp)) {
				budget += customers[place].addOrder(menu[i]);
				break;
			}
		}
	}

	public void deleteOrder() {
		if (customers[place] != null)
			budget -= customers[place].deleteOrder(temp);
	}

	public double calculateCost() {
		if (customers[place] != null)
			return customers[place].getCost();
		return 0;
	}

	public void addCustomer(String name, int tableNo) {
		if (customers[tableNo] == null) {
			customers[tableNo] = new Customer(name, tableNo);
		} else
			System.err.println("Table is full!");
	}

	public void deleteCustomer(int code) {
		if (customers[code] != null) {
			customers[code] = null;
		} else
			System.err.println("Table is empty!");
	}

	public void showCustomers() {
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] != null)
				System.out.println("Name: " + customers[i].getName() + " Table Code: " + customers[i].getCode());
		}
	}

	public void showOrders() {
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] != null)
				customers[i].getOrders();
		}
	}

	public void addEmployee() {
		System.out.println("Enter The Name: ");
		temp = sc.next();
		System.out.println("Enter The Employment: ");
		String employment = sc.next();
		System.out.println("Enter The Salary: ");
		Double salary = sc.nextDouble();

		Employee employee = new Employee(temp, employment, salary);
		employees[pot] = employee;
		pot++;
	}

	public void deleteEmployee() {
		System.out.println("Enter The Name: ");
		temp = sc.next();
		System.out.println("Enter The Employment: ");
		String employment = sc.next();

		for (int i = 0; i < employees.length; i++) {
			if (employees[i] != null && employees[i].getName().equals(temp)
					&& employees[i].getEmployment().equals(employment)) {
				employees[i] = null;
				pot--;
			}
		}

	}

	public void showEmployees() {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] != null) {
				System.out.println("Name: " + employees[i].getName() + " Employment: " + employees[i].getEmployment()
						+ " Salary: " + employees[i].getSalary());
			}
		}

	}

	public void enterInfo() {
		System.out.println("Enter The Name: ");
		temp = sc.next();
		System.out.println("Enter The Table Code: ");
		place = sc.nextInt();
	}

	public void enterInfo(String temp, int place) {
		this.temp = temp;
		this.place = place;
	}

	public void changeOrderStatus() {
		if (customers[place] != null)
			customers[place].changeOrderStatus(temp);

	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getDot() {
		return dot;
	}

	public void setDot(int dot) {
		this.dot = dot;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public int getPot() {
		return pot;
	}

	public void setPot(int pot) {
		this.pot = pot;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Order[] getMenu() {
		return menu;
	}

	public void setMenu(Order[] menu) {
		this.menu = menu;
	}

}