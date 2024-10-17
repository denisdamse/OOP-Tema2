package ro.emanuel.pojo;

public class SpeedingTickets {
	private int id;
	private String driver;
	private String licensePlate;
	private int kmOverLimit;
	public SpeedingTickets(int id, String driver, String licensePlate, int kmOverLimit) {
		super();
		this.id = id;
		this.driver = driver;
		this.licensePlate = licensePlate;
		this.kmOverLimit = kmOverLimit;
	}
	
	public SpeedingTickets(String driver, String licensePlate, int kmOverLimit) {
		super();
		this.driver = driver;
		this.licensePlate = licensePlate;
		this.kmOverLimit = kmOverLimit;
	}

	public int getId() {
		return id;
	}
	public String getDriver() {
		return driver;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public int getKmOverLimit() {
		return kmOverLimit;
	}
	
}
