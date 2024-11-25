package com.snwolf.mianshi.domain.dto.user;

import lombok.Data;

/**
 * @author <a href="https://github.com/SnowWolf68">SnowWolf68</a>
 * @Version: V1.0
 * @Date: 11/25/2024
 * @Description:
 */
@Data
public class UserDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 微信开放平台id
     */
    private String unionId;

    /**
     * 公众号openId
     */
    private String mpOpenId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     */
    private String userProfile;

    /**
     * 用户简介
     * 用户角色：user/admin/ban
     */
    private String userRole;
}
