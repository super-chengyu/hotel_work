package com.dj.hotel.web.page;
import com.dj.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author 杨承雨
 */
@Controller
@RequestMapping("/index/")
public class IndexPageController {

	@Autowired
	public UserService userService;

	
	@RequestMapping("toIndex")
	private String toIndex() {
		return "index/index";
	}
	
	@RequestMapping("toTop")
	private String toTop() {
		return "index/top";
	}
	
	@RequestMapping("toLeft")
	private String toLeft() {
		return "index/left";
	}
	
	@RequestMapping("toRight")
	private String toRight() {
		return "index/right";
	}
	
	@RequestMapping("toEsc")
	private String toEsc() {
	  	return "user/login";
	 }
}
