package com.boy.domain.vo;

import java.io.Serializable;

public class LoginResultByVo implements Serializable {
    String token;
    Integer role;

    public LoginResultByVo() {
    }

    public LoginResultByVo(String token, Integer role) {
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginResultByVo{" +
                "token='" + token + '\'' +
                ", role=" + role +
                '}';
    }
}
