package decomp.sales;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import decomp_enum.OrderStatus;


public class Order {
	// Instance a format mask to dates
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	// Instance a list of items
	private List<OrderItem> items = new ArrayList<>();
	
	// do not initiate a list by a constructor
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	// Getters and Setters
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	// insert a new item in a items's list
	public void addItem(OrderItem item) {
		items.add(item); // list of items adding an item
	}
	
	//removing an item of items list 	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	// total function
	public double total() {
		double sum = 0.0;
		for (OrderItem item : items) {// for a list of items do:
			sum += item.subTotal(); // sum = sum + Function subTotal (from OrderItem Class)
		}
		return sum;
	}
	
	@Override // this tag show it is a super position of function
	public String toString() {
		StringBuilder sb = new StringBuilder();// String Builder function to concatenate in a better way
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		
		sb.append("Order status: ");
		sb.append(status + "\n");
		
		sb.append("Client: ");
		sb.append(client + "\n\n");
		
		sb.append("Order items:\n");
		
		for (OrderItem item : items) { //for each item in a list, do: 
			sb.append(item + "\n"); // jump a line
		}
		
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
