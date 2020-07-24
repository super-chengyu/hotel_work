package com.dj.hotel.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.hotel.common.ResultModel;
import com.dj.hotel.common.SysConstant;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制层
 * 2020-07-23
 * @author 杨承雨
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @Title: loginByNameAndPwd
     * @Description: 用户登录
     * @Date: 2020年7月23日
     * @author: ycy
     * @param: @param user
     * @param: @return
     * @return:
     * @throws
     */
    @RequestMapping("loginByNameAndPwd")
    public ResultModel<Object> loginByNameAndPwd(User user, HttpSession httpSession){
        try {
            if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getUserPwd())){
                return new ResultModel<>().error("用户信息不能为空");
            }
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_name", user.getUserName());
            queryWrapper.eq("user_pwd", user.getUserPwd());
            User user1 = userService.getOne(queryWrapper);
            if (user1 == null){
                return new ResultModel<>().error("请核实您的信息");
            }
            httpSession.setAttribute("user", user1);
            return new ResultModel<>().success("登录成功");
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error(e.getMessage());
        }
    }

    /**
     *
     * @Title: registerUser
     * @Description: 用户注册
     * @Date: 2020年7月23日
     * @author: hhq
     * @param: @param user
     * @param: @return
     * @return:
     * @throws
     */
    @RequestMapping("registerUser")
    public ResultModel<Object> registerUser(User user){
        try {
            userService.save(user);
            return new ResultModel<>().success("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error(e.getMessage());
        }
    }

    /**
     *
     * @Title: getPhone
     * @Description: 邮箱去重
     * @Date: 2020年7月23日
     * @author: hhq
     * @param: @param user
     * @param: @return
     * @return:
     * @throws
     */
    @RequestMapping("getEmail")
    public boolean getEmail(String  userEmail){
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_email", userEmail);
            User user2 = userService.getOne(queryWrapper);
            return user2 == null ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     * @Title: userShow
     * @Description: 用户展示
     * @Title: showUserLevel5
     * @Description: 只展示用户等级为5的
     * @Date: 2020年7月24日
     * @author: ck
     * @param: @param home, pageNo
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("showUserLevel5")
    public ResultModel<Object> showUserLevel5(User user, Integer pageNo){
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_level", SysConstant.SHOW_USER_LEVEL5);
            queryWrapper.eq("is_del", SysConstant.IS_DEL);
            IPage<User> page = new Page<>(pageNo, SysConstant.HOME_PAGE_SIZE);
            IPage<User> pageInfo = userService.page(page, queryWrapper);
            map.put("userList", pageInfo.getRecords());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<>().success(map);
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常");
        }
    }

    /**
     *
     * @Title: level5UpdateDel
     * @Description: 用户展示
     * @Title: showUserLevel5
     * @Description: 只展示用户等级为5的
     * @Date: 2020年7月24日
     * @author: ck
     * @param: @param home, pageNo
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("level5UpdateDel")
    public ResultModel<Object> level5UpdateDel(User user, Integer pageNo){
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("is_del", SysConstant.IS_DEL);
            userService.updateById(user);
            return new ResultModel<>().success(queryWrapper);
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常");
        }
    }

    /**
     *
     * @Title: level5UpdateDel
     * @Description: 裁员修改isDel为1
     * @Date: 2020年7月24日
     * @author: csx
     * @param: @param user, pageNo
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("show")
    public ResultModel<Object> show(User user, Integer pageNo){
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("is_del", SysConstant.IS_DEL);
            IPage<User> page = new Page<>(pageNo, SysConstant.HOME_PAGE_SIZE);
            IPage<User> pageInfo = userService.page(page, queryWrapper);
            map.put("userList", pageInfo.getRecords());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<>().success(map);
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常");
        }
    }
}
