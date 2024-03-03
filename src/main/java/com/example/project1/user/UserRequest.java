package com.example.project1.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO{
        private String username;
        private String password;
        private String name;
        private String tel;
        private String birth;
        private String email;
        private String address;
        private String image;
        private Integer role;

    }

    @Data
    public static class LoginDTO{
        private String username;
        private String password;
    }
}
