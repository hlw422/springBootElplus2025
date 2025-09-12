package com.example.springbootelplus2025.controller;

import com.example.springbootelplus2025.common.BaseResponse;
import com.example.springbootelplus2025.common.ErrorCode;
import com.example.springbootelplus2025.common.ResultUtils;
import com.example.springbootelplus2025.domain.request.UserLoginRequest;
import com.example.springbootelplus2025.domain.request.UserRegisterRequest;
import com.example.springbootelplus2025.domain.response.LoginUserVO;
import com.example.springbootelplus2025.exception.BusinessException;
import com.example.springbootelplus2025.service.userService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/test")
    public String UserTest(@RequestBody Map<String, String> map) {
        return "SUCCESS";
    }


    @Resource
    private userService userService;
    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @param request
     * @return
     */
    @PostMapping("/login")
    public BaseResponse<LoginUserVO> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userLoginRequest.getUseraccount();
        String userPassword = userLoginRequest.getUserpassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        LoginUserVO loginUserVO = userService.userLogin(userAccount, userPassword, request);
        loginUserVO.setToken(UUID.randomUUID().toString());
        return ResultUtils.success(loginUserVO);
    }
    /**
     * 用户注册
     *
     * @param userRegisterRequest
     * @return
     */
    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
                return  ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }
}
