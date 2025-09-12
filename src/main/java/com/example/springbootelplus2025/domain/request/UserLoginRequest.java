package com.example.springbootelplus2025.domain.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    /**
     * 账号
     */
    private String useraccount;

    /**
     * 密码
     */
    private String userpassword;
}
