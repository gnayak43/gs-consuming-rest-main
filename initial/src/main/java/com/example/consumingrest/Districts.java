package com.example.consumingrest;

import java.util.List;

public class Districts {

	List<District> districts;

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	@Override
	public String toString() {
		return "Districts [districts=" + districts + "]";
	}

}
