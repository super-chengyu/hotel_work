package com.dj.hotel.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * BaseData基础数据
 */
@Data
@TableName("base_data")
public class BaseData {

    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Integer Id;

    /** 基础名字 */
    private String baseName;

    /** 父级id */
    private Integer parentId;

    /** 0:正常，1:删除 */
    private Integer isDel;


}
