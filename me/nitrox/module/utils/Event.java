package me.nitrox.module.utils;

public class Event<T>  {
	
	public boolean cancelled;
	public EventType type;
	public EventDirection dir;
	
	public boolean isCancelled() {
		return cancelled;
	}
	
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	
	public EventType getType() {
		return type;
	}
	
	public void setType(EventType type) {
		this.type = type;
	}
	
	public EventDirection getDirection() {
		return dir;
	}
	
	public void setDirection(EventDirection dir) {
		this.dir = dir;
	}
	
	public boolean isPre() {
		if(type == null) 
			return false;
		
		return type == EventType.PRE;
		
	}
	
	public boolean isPost() {
		if(type == null)
			return false;
		
		return type == EventType.POST;
	}
	
	public boolean isIncoming() {
		if(dir == null) 
			return false;
		
		return dir == EventDirection.INCOMING;
		
	}
	
	public boolean isOutgoing() {
		if(dir == null)
			return false;
		
		return dir == EventDirection.OUTGOING;
	}

}
