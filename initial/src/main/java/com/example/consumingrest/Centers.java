package com.example.consumingrest;

import java.util.List;

public class Centers {

	List<Center> centers;

	public List<Center> getCenters() {
		return centers;
	}

	public void setCenters(List<Center> centers) {
		this.centers = centers;
	}

	@Override
	public String toString() {
		return "Centers [centers=" + centers + "]";
	}

}
