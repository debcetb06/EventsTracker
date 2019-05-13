package com.debasis.repoeventstracker.model;

public class EventType {

	private long id;

	private String eventType;

	public EventType(long id, String eventType) {
		this.id = id;
		this.eventType = eventType;
	}

	public long getId() {
		return id;
	}

	public String getEventType() {
		return eventType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventType other = (EventType) obj;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
