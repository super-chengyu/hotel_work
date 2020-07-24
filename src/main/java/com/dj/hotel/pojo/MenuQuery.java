package com.dj.hotel.pojo;

import lombok.Data;

/**
 * 菜品查询虚拟表
 */
@Data
public class MenuQuery {

    /** 菜品名 */
    private String menuName;
    /** 菜品最小价格 */
    private Double minPrice;
    /** 菜品最大价格 */
    private Double maxPrice;
}
