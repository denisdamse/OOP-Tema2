package ro.emanuel.pojo;

public class RubiksCube {
	private int id;
	private String brand;
	private double weight;
	private int sides;
	public RubiksCube(int id, String brand, double weight, int sides) {
		super();
		this.id = id;
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
	}
	
	public RubiksCube(String brand, double weight, int sides) {
		super();
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
	}

	public int getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}
	public double getWeight() {
		return weight;
	}
	public int getSides() {
		return sides;
	}
	
}
