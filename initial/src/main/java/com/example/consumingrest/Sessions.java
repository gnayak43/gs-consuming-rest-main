package com.example.consumingrest;

import java.util.List;

public class Sessions {

	List<Session> sessions;

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Sessions [sessions=" + sessions + "]";
	}
	
}
