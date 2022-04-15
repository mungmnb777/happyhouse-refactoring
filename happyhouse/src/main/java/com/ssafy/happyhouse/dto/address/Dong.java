package com.ssafy.happyhouse.dto.address;

public class Dong {
	private City city;
	private String code;
	private String name;

	public Dong() {
		super();
	}

	public Dong(City city, String code, String name) {
		super();
		this.city = city;
		this.code = code;
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dong [city=" + city + ", code=" + code + ", name=" + name + "]";
	}

}
