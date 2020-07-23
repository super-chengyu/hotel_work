package com.dj.hotel.web.page;

import com.dj.hotel.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * home的pageController
 * @author 杨承雨
 */
@Controller
@RequestMapping("/home/")
public class HomePageController {

    @Autowired
    private HomeService homeService;

}
