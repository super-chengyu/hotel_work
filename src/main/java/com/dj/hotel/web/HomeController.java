package com.dj.hotel.web;

import com.dj.hotel.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * home的控制层
 * @author 杨承雨
 */
@RestController
@RequestMapping("/home/")
public class HomeController {

    @Autowired
    private HomeService homeService;
}
