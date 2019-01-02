// The Car class handles updating the Scheduler and notifying the Monitor
// and Garage when it arrives and departs. It utilizes random numbers to
// determine how long it should stay in the garage (1 - 50 minutes) as well
// as how long it takes for the next car to arrive (1 - 8 minutes).

import java.util.Random;


public class Car {
	private int arrivalTime;
	private int departureTime;
	
	private int GetTimeToNextCar(int startingTime) {
		Random rand = new Random();
		int timeToNextCar = rand.nextInt(7) + 1;
		return startingTime + timeToNextCar;
	}
	
	private int GetDepartureTime(int startingTime) {
		Random rand = new Random();
		int departureAddition = rand.nextInt(50) + 1;
		return startingTime + departureAddition;
	}
	
	public void LogArrival() {
		arrivalTime = Schedule.GetInstance().GetTime();
		
		// Get time to next car and set it on the schedule
		Event nextCar = new Event();
		nextCar.SetEventTime(GetTimeToNextCar(arrivalTime));
		nextCar.SetEventType(3);
		Schedule.GetInstance().AddEvent(nextCar);
	}
	
	public void TryToPark() {
		
		// Determine if garage is full
		if(Garage.GetInstance().GetAmountVacant() == 0) {
			Monitor.GetInstance().LogLostCustomer();
		} else {
			// Log stay with monitor and garage
			Monitor.GetInstance().LogStay();
			Garage.GetInstance().DecreaseVacancy();
			
			// Determine departure time
			departureTime = GetDepartureTime(arrivalTime);
			
			// Create departure event and add it to schedule
			Event departure = new Event();
			departure.SetEventTime(departureTime);
			departure.SetEventType(2);
			Schedule.GetInstance().AddEvent(departure);
		}
	}
	
	public void Arrive() {
		LogArrival();
		TryToPark();
	}
	
	public void Departure() {
		Garage.GetInstance().IncreaseVacancy();
		Monitor.GetInstance().LogDeparture();
	}
}
