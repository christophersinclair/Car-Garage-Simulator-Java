// The Garage class stores information about the number of cars in the garage as well as
// the amount of empty spots. To keep it simple, we just have a count of the number of cars,
// and if the count is greater than the amount of empty spots on a certain floor, then obviously
// the next floor is being used. Sometimes its easier to work smarter, not harder.

public class Garage {
	
	// Singleton instance object creation
	private static Garage garage = new Garage();
	
	private int numberOfCars = 0; // stores number of cars in the garage
	private int emptySpots = 900; // stores the number of empty spots, we will assume 150 spots per floor
	
	// Singleton instance return
	public static Garage GetInstance() {
		return garage;
	}
	
	// Returns the amount of vacant parking spaces in the garage
	public final int GetAmountVacant() {
		return emptySpots;
	}
	
	// Decreases vacancy when a new car arrives and increments the total number of cars
	public void DecreaseVacancy() {
		emptySpots--;
		numberOfCars++;
	}
	
	// Increases the vacancy when a car departs and decrements the total number of cars
	public void IncreaseVacancy() {
		emptySpots++;
		numberOfCars--;
	}
	
	// Returns the total number of cars
	public final int GetTotalCars() {
		return numberOfCars;
	}
	
	// Returns the total number of floors being used based on the number of cars present in the garage 
	public final int GetUsedFloors() {
		if(numberOfCars > 750) {
			return 6;
		} else if(numberOfCars > 600) {
			return 5;
		} else if(numberOfCars > 450) {
			return 4;
		} else if(numberOfCars > 300) {
			return 3;
		} else if(numberOfCars > 150) {
			return 2;
		} else {
			return 1;
		}
	}
}
