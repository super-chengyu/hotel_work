package com.dj.hotel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author 成素鑫
 */
@Data
public class UserQuery {

    /** 新密码  (虚拟字段)*/
    private String newPwd;

    /** 确认新密码  (虚拟字段)*/
    private String newPwdTo;

}
