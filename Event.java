// The event class holds the event type and time to kick off

public class Event {
	private int eventTime = 0;
	private int eventType = 0; // 1 for arrival (although not needed), 2 for departure, 3 for next arrival
	
	public final int GetEventTime() {
		return eventTime;
	}
	
	public void SetEventTime(int time) {
		eventTime = time;
	}
	
	public int GetEventType() {
		return eventType;
	}
	
	public void SetEventType(int type) {
		eventType = type;
	}
}


