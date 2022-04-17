package com.ssafy.happyhouse.dto.address;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.MemberDto;

import java.time.LocalDateTime;

public class State {
    // 시도 코드
    private String code;
    // 시도 이름
    private String name;

    public State() {
        super();
    }

    public State(String code, String name) {
        super();
        this.code = code;
        this.name = name;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        // 시도 코드
        private String code;
        // 시도 이름
        private String name;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public State build() {
            return new State(code, name);
        }
    }
}
