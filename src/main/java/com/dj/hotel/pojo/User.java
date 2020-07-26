package com.dj.hotel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author 杨承雨
 */
@Data
@TableName("user")
public class User {

    /** 用户主键ID */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 用户姓名 */
    private String userName;

    /** 用户密码 */
    private String userPwd;

    /** 用户邮箱 */
    private String userEmail;

    /** 用户手机号 */
    private String userPhone;

    /** 用户职务 */
    private Integer userLevel;

    /** 用户验证码 */
    private String userCode;

    /** 验证码有效时间 */
    private Date codeTime;

    /** 用户伪删除 */
    private Integer isDel;

}
