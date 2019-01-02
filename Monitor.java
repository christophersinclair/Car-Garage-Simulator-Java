// The monitor runs all of the garage statistics and logs
public class Monitor {

	private static Monitor monitor = new Monitor();
	
	private int lostCustomers = 0;
	private int carsInGarage = 0;
	private int revenue = 0;
	private int greatestFloor;
	
	public static Monitor GetInstance() {
		return monitor;
	}
	
	public void LogLostCustomer() {
		lostCustomers++;
	}
	
	public void LogStay() {
		revenue++;
		carsInGarage++;
	}
	
	public void LogDeparture() {
		carsInGarage--;
	}
	
	public final int TotalRevenue() {
		return revenue * 2;
	}
	
	public final int floorsInUse() {
		greatestFloor = Garage.GetInstance().GetUsedFloors();
		return greatestFloor;
	}
	
	public final int TotalLostCustomers() {
		return lostCustomers;
	}
	
	public final int CarsLeftInGarage() {
		return carsInGarage;
	}
}
