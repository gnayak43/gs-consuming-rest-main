package com.example.consumingrest;

import java.util.List;

public class Session {

	String date;
	int available_capacity;
	int min_age_limit;
	String vaccine;
	List<String> slots;
	int available_capacity_dose1;
	int available_capacity_dose2;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAvailable_capacity() {
		return available_capacity;
	}

	public void setAvailable_capacity(int available_capacity) {
		this.available_capacity = available_capacity;
	}

	public int getMin_age_limit() {
		return min_age_limit;
	}

	public void setMin_age_limit(int min_age_limit) {
		this.min_age_limit = min_age_limit;
	}

	public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public List<String> getSlots() {
		return slots;
	}

	public void setSlots(List<String> slots) {
		this.slots = slots;
	}

	public int getAvailable_capacity_dose1() {
		return available_capacity_dose1;
	}

	public void setAvailable_capacity_dose1(int available_capacity_dose1) {
		this.available_capacity_dose1 = available_capacity_dose1;
	}

	public int getAvailable_capacity_dose2() {
		return available_capacity_dose2;
	}

	public void setAvailable_capacity_dose2(int available_capacity_dose2) {
		this.available_capacity_dose2 = available_capacity_dose2;
	}

	@Override
	public String toString() {
		return "Session [date=" + date + ", available_capacity=" + available_capacity + ", min_age_limit="
				+ min_age_limit + ", vaccine=" + vaccine + ", slots=" + slots + ", available_capacity_dose1="
				+ available_capacity_dose1 + ", available_capacity_dose2=" + available_capacity_dose2 + "]";
	}

	public String toStringCustom() {
		return "\ndate=" + date + "\navailable_capacity=" + available_capacity + "\navailable_capacity_dose1="
				+ available_capacity_dose1 + "\navailable_capacity_dose2=" + available_capacity_dose2
				+ "\nmin_age_limit=" + min_age_limit + "\nvaccine=" + vaccine;
	}
}
