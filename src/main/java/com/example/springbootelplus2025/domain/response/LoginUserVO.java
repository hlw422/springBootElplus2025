package com.example.springbootelplus2025.domain.response;

import lombok.Data;

@Data
public class LoginUserVO {

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户头像
     */
    private String useravatar;

    /**
     * 用户简介
     */
    private String userprofile;


    private String token;


}
