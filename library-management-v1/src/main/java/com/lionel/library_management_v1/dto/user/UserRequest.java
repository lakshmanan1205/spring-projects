package com.lionel.library_management_v1.dto.user;

import org.springframework.stereotype.Component;

@Component
public class UserRequest {
//    @JsonProperty("user_name")
    private String userName;
    private String password;
    private String email;
    private int walletAmount;

    public UserRequest() {
    }

    public UserRequest(String userName, String password, String email, int walletAmount) {

        this.userName = userName;
        this.password = password;
        this.email = email;
        this.walletAmount = walletAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(int walletAmount) {
        this.walletAmount = walletAmount;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", walletAmount=" + walletAmount +
                '}';
    }
}
