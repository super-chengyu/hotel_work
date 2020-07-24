package com.dj.hotel.pojo;

import lombok.Data;

@Data
public class MenuQuery {

    private String menuName;
    private Double minPrice;
    private Double maxPrice;
}
