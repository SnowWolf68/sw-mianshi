package com.snwolf.mianshi.controller;

import cn.hutool.core.bean.BeanUtil;
import com.snwolf.mianshi.annotation.CheckRole;
import com.snwolf.mianshi.domain.dto.user.UserLoginDTO;
import com.snwolf.mianshi.domain.dto.user.UserRegisterDTO;
import com.snwolf.mianshi.domain.entity.User;
import com.snwolf.mianshi.domain.vo.UserVO;
import com.snwolf.mianshi.result.Result;
import com.snwolf.mianshi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(tags = "用户相关接口")
public class UserController {

    private final UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO){
        userService.register(userRegisterDTO);
        return Result.success();
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<String> login(@RequestBody UserLoginDTO userLoginDTO){
        String token = userService.login(userLoginDTO);
        return Result.success(token);
    }

    @GetMapping("/list")
    @ApiOperation("查询用户列表")
    @CheckRole(role = "admin")
    public Result<List<UserVO>> list(){
        List<User> userList = userService.list();
        List<UserVO> userDTOList = userList.stream().map(user -> BeanUtil.copyProperties(user, UserVO.class)).collect(Collectors.toList());
        return Result.success(userDTOList);
    }
}
