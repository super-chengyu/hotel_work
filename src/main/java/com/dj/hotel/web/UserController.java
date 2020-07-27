package com.dj.hotel.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.hotel.common.ResultModel;
import com.dj.hotel.common.SendMailUtils;
import com.dj.hotel.common.SysConstant;
import com.dj.hotel.pojo.User;
import com.dj.hotel.pojo.UserQuery;
import com.dj.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
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
            if (user1.getIsDel() == 1){
                return new ResultModel<>().error("无权登录");
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
     * @Title: insertUserLevel5
     * @Description: 厨师注册
     * @Date: 2020年7月26日
     * @author: ck
     * @param: @param user
     * @param: @return
     * @return:
     * @throws
     */
    @RequestMapping("insertUserLevel5")
    public ResultModel<Object> insertUserLevel5(User user){
        try {
            userService.save(user);
            return new ResultModel<>().success("厨师注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error(e.getMessage());
        }
    }

    /**
     *
     * @Title: getEmail
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
     * @Title: show
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
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("level5UpdateDel")
    public ResultModel<Object> level5UpdateDel(User user){
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
     * @Title: updateUserLevel3
     * @Description: 通过绑定手机号升级用户为会员
     * @Title: showUserLevel5
     * @Description: 只展示用户等级为5的
     * @Date: 2020年7月24日
     * @author: ck
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("updateUserLevel3")
    public ResultModel<Object> updateUserLevel3(User user){
        try {
            user.setUserLevel(SysConstant.USER_LEVEL_THREE);
            user.setIsVip(SysConstant.IS_VIP2);
            userService.updateById(user);
            return new ResultModel<>().success();
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常");
        }
    }

    /**
     *
     * @Title: show
     * @Description: 展示用户
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
            queryWrapper.orderByDesc("is_vip");
            IPage<User> page = new Page<>(pageNo, SysConstant.USER_PAGE_SIZE);
            IPage<User> pageInfo = userService.page(page, queryWrapper);
            map.put("userList", pageInfo.getRecords());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<>().success(map);
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error(e.getMessage());
        }
    }

    /**
     *
     * @Title: getEmailCode
     * @Description: 获取验证码
     * @Date: 2020年7月25日
     * @author: csx
     * @param: @param userCode
     * @param: @return
     * @return: ResultModel<Object>
     * @throws
     */
    @RequestMapping("getEmailCode")
    public ResultModel<Object> getEmailCode(User user){
        try {
            if(StringUtils.isEmpty(user.getUserEmail())) {
                return new ResultModel<Object>().error("邮箱不能为空");
            }
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("user_email", user.getUserEmail());
            User user1 = userService.getOne(queryWrapper);
            if(null == user1) {
                return new ResultModel<Object>().error("该邮箱不存在");
            }
            int code = (int)((Math.random()*9+1)*100000);
            user1.setUserCode(String.valueOf(code));
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.MINUTE, SysConstant.CODE_TIME);
            user1.setCodeTime(calendar.getTime());
            userService.updateById(user1);
            SendMailUtils.sendEmail(user.getUserEmail(), "验证码", String.valueOf(code));
            return new ResultModel<Object>().success();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResultModel<>().error(e.getMessage());
        }
    }

    /**
     *
     * @Title: recovery
     * @Description: 判断邮箱是否存在
     * @Date: 2020年7月25日
     * @author: csx
     * @param: @param userCode
     * @param: @return
     * @return: ResultModel<Object>
     * @throws
     */
    @RequestMapping("recovery")
    public ResultModel<Object> recovery(User user){
        Map<String, Object> map = new HashMap<>();
        try {
            if(StringUtils.isEmpty(user.getUserEmail())
                    || StringUtils.isEmpty(user.getUserCode())) {
                return new ResultModel<Object>().error("邮箱验证码输入不能为空");
            }
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("user_email", user.getUserEmail());
            User user1 = userService.getOne(queryWrapper);
            if(null == user1) {
                return new ResultModel<Object>().error("邮箱验证码输入有误");
            }
            if(user1.getCodeTime().getTime() < new Date().getTime()) {
                return new ResultModel<Object>().error("验证码已超时，请重新获取");
            }
            map.put("userEmail", user1.getUserEmail());
            return new ResultModel<Object>().success(map);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResultModel<>().error(e.getMessage());
        }
    }

    /**
     *
     * @Title: newPwd
     * @Description: 重置密码
     * @Date: 2020年7月26日
     * @author: csx
     * @param: @param userCode
     * @param: @return
     * @return: ResultModel<Object>
     * @throws
     */
    @RequestMapping("newPwd")
    public ResultModel<Object> newPwd(User user, UserQuery userQuery){
        try {
            if (StringUtils.isEmpty(userQuery.getNewPwd()) || StringUtils.isEmpty(userQuery.getNewPwdTo())){
                return new ResultModel<Object>().error("您设置的密码不能为空，请重新设置");
            }
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("user_email", user.getUserEmail());
            User user1 = userService.getOne(queryWrapper);
            if (!userQuery.getNewPwd().equals(userQuery.getNewPwdTo())){
                return new ResultModel<Object>().error("请确认您输入的两次密码是否一致");
            }
            user1.setUserPwd(userQuery.getNewPwd());
            userService.updateById(user1);
            return new ResultModel<Object>().success();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResultModel<>().error(e.getMessage());
        }
    }

}
