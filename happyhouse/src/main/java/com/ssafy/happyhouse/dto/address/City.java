package com.ssafy.happyhouse.dto.address;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.MemberDto;

import java.time.LocalDateTime;

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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        // 시도 객체
        private State state;
        // 동코드
        private String code;
        // 이름
        private String name;

        public Builder state(State state) {
            this.state = state;
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

        public City build() {
            return new City(state, code, name);
        }
    }
}
