package ro.emanuel.pojo;

public class CostcoProducts {
	private int id;
	private String name;
	private String location;
	private int price;
	public CostcoProducts(int id, String name, String location, int price) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.price = price;
	}
	
	public CostcoProducts(String name, String location, int price) {
		super();
		this.name = name;
		this.location = location;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public int getPrice() {
		return price;
	}
	
}
