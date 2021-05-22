package com.example.consumingrest;

import java.util.List;

public class States {

	List<State> states;

	public States() {
		// TODO Auto-generated constructor stub
	}

	public States(List<State> states) {
		super();
		this.states = states;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "States [states=" + states + "]";
	}

}
