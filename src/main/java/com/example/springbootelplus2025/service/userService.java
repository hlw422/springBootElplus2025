package com.example.springbootelplus2025.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootelplus2025.domain.response.LoginUserVO;
import com.example.springbootelplus2025.domain.user;
import jakarta.servlet.http.HttpServletRequest;

/**
* @author hlw
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-09-09 15:34:29
*/
public interface userService extends IService<user> {

    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);


    LoginUserVO getLoginUserVO(user user);

    long userRegister(String userAccount, String userPassword, String checkPassword);
}
