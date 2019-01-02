import java.util.Comparator;

// Comparator for event priority queue located in scheduler
public class EventComparator implements Comparator<Event> {
	public int compare(Event a, Event b) {
		return b.GetEventTime() - a.GetEventTime();
	}
}