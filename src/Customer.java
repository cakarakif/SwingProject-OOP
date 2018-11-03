
public class Customer implements TypeCustomer{
	private String name;
	private int code, count;
	private double cost;
	private Order[] orders;

	Customer(String name, int code) {
		this.name = name;
		this.code = code;
		orders = new Order[10];
		cost = 0;
		count = 0;
	}

	public double addOrder(Order order) {
		orders[count] = order;
		cost += order.getPrice();
		count++;
		return order.getPrice();
	}

	public double deleteOrder(String name) {
		double price = 0;
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] != null && orders[i].getName().equals(name)) {
				price = orders[i].getPrice();
				cost -= price;
				orders[i] = null;
				return price;
			}
		}
		return 0;
	}

	public void changeOrderStatus(String name){
		for (int i = 0; i < orders.length; i++) {
			if (orders[i] != null && orders[i].getName().equals(name)) {
				orders[i].setStatus(true);
				break;
			}
		}
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setOrders(Order[] orders) {
		this.orders = orders;
	}

	public Order[] getOrders() {
		return orders;
	}
	

}
