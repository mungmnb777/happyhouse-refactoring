package com.ssafy.happyhouse.dto;

import java.time.LocalDateTime;

public class MemberDto {
    // 멤버 ID
    private String id;
    // 멤버 비밀번호
    private String password;
    // 멤버 이름
    private String name;
    // 멤버 닉네임
    private String nickname;
    // 멤버 이메일
    private String email;
    // 멤버 생성 날짜
    private LocalDateTime cdate;
    // 멤버 수정 날짜
    private LocalDateTime udate;
    // 멤버 전화번호
    private String tel;
    // 멤버 권한
    private String role;

    public MemberDto() {
        super();
    }

    public MemberDto(String id, String password, String name, String nickname, String email, LocalDateTime cdate, LocalDateTime udate,
                     String tel, String role) {
        super();
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.cdate = cdate;
        this.udate = udate;
        this.tel = tel;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCdate() {
        return cdate;
    }

    public void setCdate(LocalDateTime cdate) {
        this.cdate = cdate;
    }

    public LocalDateTime getUdate() {
        return udate;
    }

    public void setUdate(LocalDateTime udate) {
        this.udate = udate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname
                + ", email=" + email + ", cdate=" + cdate + ", udate=" + udate + ", tel=" + tel + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        // 멤버 ID
        private String id;
        // 멤버 비밀번호
        private String password;
        // 멤버 이름
        private String name;
        // 멤버 닉네임
        private String nickname;
        // 멤버 이메일
        private String email;
        // 멤버 생성 날짜
        private LocalDateTime cdate;
        // 멤버 수정 날짜
        private LocalDateTime udate;
        // 멤버 전화번호
        private String tel;
        // 멤버 권한
        private String role;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder cdate(LocalDateTime cdate) {
            this.cdate = cdate;
            return this;
        }

        public Builder udate(LocalDateTime udate) {
            this.udate = udate;
            return this;
        }

        public Builder tel(String tel) {
            this.tel = tel;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public MemberDto build() {
            return new MemberDto(id, password, name, nickname, email, cdate, udate, tel, role);
        }
    }
}
