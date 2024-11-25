package com.snwolf.mianshi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.snwolf.mianshi.domain.dto.user.UserLoginDTO;
import com.snwolf.mianshi.domain.dto.user.UserRegisterDTO;
import com.snwolf.mianshi.domain.entity.User;
import com.snwolf.mianshi.exception.CheckPasswordException;

public interface UserService extends IService<User> {
    void register(UserRegisterDTO userRegisterDTO) throws CheckPasswordException;

    String login(UserLoginDTO userLoginDTO);
}
