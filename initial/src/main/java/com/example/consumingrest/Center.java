package com.example.consumingrest;

import java.util.List;

public class Center {

	String district_name;
	String name;
	String address;
	String block_name;
	long pincode;
	String from;
	String to;
	String fee_type;
	List<Session> sessions;

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlock_name() {
		return block_name;
	}

	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Center [district_name=" + district_name + ", pincode=" + pincode + ", name=" + name + ", address="
				+ address + ", block_name=" + block_name + ", from=" + from + ", to=" + to + ", fee_type=" + fee_type
				+ ", sessions=" + sessions + "]";
	}

	public String toStringCustom() {
		return "district_name=" + district_name + "\npincode=" + pincode + "\nname=" + name + "\naddress=" + address
				+ "\nfee_type=" + fee_type;
	}
}
