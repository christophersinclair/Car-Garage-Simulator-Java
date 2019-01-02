// This is the scheduling system for the garage. Using a priority queue, it handles
// all of the event management, invocation, and world clock updating.

import java.util.Comparator;
import java.util.PriorityQueue;


//import java.util.List;

public class Schedule {
	
	// Singleton object of Schedule
	private static Schedule schedule = new Schedule();
	private int worldTime = 0;
	
	// Schedule is a priority queue of events
	private static Comparator<Event> comparator = new EventComparator();
	private static PriorityQueue<Event> eventQueue = new PriorityQueue<Event>(10, comparator);
	
	
	// Returns the singleton instance of the schedule
	public static Schedule GetInstance() {
		return schedule;
	}
	
	// Returns the event list
	public static PriorityQueue<Event> GetEventQueue() {
		return eventQueue;
	}
	
	public void AddEvent(Event event) {
		eventQueue.add(event);
	}
	
	// Take and invoke the next event
	public void TakeNextEvent() {
		Event nextEvent = eventQueue.remove();
		worldTime = nextEvent.GetEventTime();
		
		int nextEventType = nextEvent.GetEventType();
		
		if (nextEventType == 1) { // arrival
			Car newCar = new Car();
			newCar.Arrive();
		} else if (nextEventType == 2) { // departure
			Car oldCar = new Car();
			oldCar.Departure();
		} else if (nextEventType == 3) { // next car arrival
			Car newCar = new Car();
			newCar.Arrive();
		}
	}
	
	public int GetTime() {
		return worldTime;
	}
	
	public void SetTime(int time) {
		worldTime = time;
	}
}
