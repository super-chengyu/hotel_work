package com.dj.hotel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Menu菜品表
 */
@Data
@TableName("menu")
public class Menu {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 菜名 */
    private String menuName;

    /** 菜品价格 */
    private Double menuPrice;

    /** 菜品介绍 */
    private String menuNote;

    /** 菜名状态 */
    private Integer menuStatus;

    /** 伪删除，0：正常，1：删除 */
    private Integer isDel;



}
