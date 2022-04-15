package com.ssafy.happyhouse.dto.address;

public class City {
	// 시도 객체
	private State state;
	// 동코드
	private String code;
	// 이름
	private String name;

	public City() {
		super();
	}

	public City(State state, String code, String name) {
		super();
		this.state = state;
		this.code = code;
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
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
		return "City [state=" + state + ", code=" + code + ", name=" + name + "]";
	}

}
