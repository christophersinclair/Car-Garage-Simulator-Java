
public class CarGarageSimulator {
	public static void main(String[] args) {
		
		System.out.println("Welcome to the car garage simulator!\nPlease let the simulation run and you will see the output shortly!");
		
		// Kick off simulation by adding a car arrival to the event queue
		Event initialEvent = new Event();
		initialEvent.SetEventTime(0); // set world time of 0
		initialEvent.SetEventType(1); // set type of 1
		
		Schedule.GetInstance().AddEvent(initialEvent);
		
		// Run through the event loop
		while(Schedule.GetInstance().GetEventQueue().peek() != null) {
			Schedule.GetInstance().TakeNextEvent();
		}
		
		
		// After simulation runs, print results
		System.out.println("Final simulation results...");
		
		StringBuilder resultString = new StringBuilder()
				.append("Total revenue: ")
				.append(Monitor.GetInstance().TotalRevenue())
				.append("\nHighest Floor Used: ")
				.append(Monitor.GetInstance().floorsInUse())
				.append("\nTotal lost customers: ")
				.append(Monitor.GetInstance().TotalLostCustomers())
				.append("\n\nThanks for using the simulation!");
		
		System.out.println(resultString);
	}
}
