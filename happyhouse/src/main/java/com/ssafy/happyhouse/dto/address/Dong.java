package com.ssafy.happyhouse.dto.address;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.MemberDto;

import java.time.LocalDateTime;

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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		// 시도 객체
		private City city;
		// 동코드
		private String code;
		// 이름
		private String name;

		public Builder city(City city) {
			this.city = city;
			return this;
		}

		public Builder code(String code) {
			this.code = code;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Dong build() {
			return new Dong(city, code, name);
		}
	}
}
