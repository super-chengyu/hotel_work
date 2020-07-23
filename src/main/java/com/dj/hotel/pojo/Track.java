package com.dj.hotel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Track轨迹表
 */
@Data
@TableName("track")
public class Track {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 记录表(recondite)的id */
    private Integer recoId;

    /** 菜品表(menu)的id */
    private Integer menuId;

    /** 菜品表(menu)的数量 */
    private Integer menuNum;

    /** 菜品表(menu)的价格 */
    private Double menuPrice;

    /** 菜品表(menu)的备注 */
    private String menuConfirm;


}
