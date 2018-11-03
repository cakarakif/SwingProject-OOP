
public interface TypeCustomer {
	
	public double addOrder(Order order);
	
	public double deleteOrder(String name);

	public Order[] getOrders();
	
	public int getCount();
	
	public void setCount(int count);
	
	public double getCost();
	
	public void setCost(int cost);
	
	public String getName();
	
	public void setName(String name);
	
	public int getCode();
	
	public void setCode(int code);
}
