package com.dj.hotel.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.hotel.common.ResultModel;
import com.dj.hotel.common.SysConstant;
import com.dj.hotel.pojo.Home;
import com.dj.hotel.pojo.Recondite;
import com.dj.hotel.pojo.User;
import com.dj.hotel.service.HomeService;
import com.dj.hotel.service.ReconditeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * home的控制层
 * @author 杨承雨
 */
@RestController
@RequestMapping("/home/")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private ReconditeService reconditeService;

    /**
     *
     * @Title: showHome
     * @Description: 座位或包间的展示
     * @Date: 2020年7月23日
     * @author: ycy
     * @param: @param home, pageNo
     * @param: @return
     * @return: map
     * @throws
     */
    @RequestMapping("showHome")
    public ResultModel<Object> showHome(Home home, Integer pageNo){
        Map<String, Object> map = new HashMap<>();
        try {
            QueryWrapper<Home> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("is_del", SysConstant.IS_DEL);
            IPage<Home> page = new Page<>(pageNo, SysConstant.HOME_PAGE_SIZE);
            IPage<Home> pageInfo = homeService.page(page, queryWrapper);
            map.put("homeList", pageInfo.getRecords());
            map.put("pages", pageInfo.getPages());
            return new ResultModel<>().success(map);
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常");
        }
    }

    /**
     *
     * @Title: updateHomeStatus
     * @Description: 挑选包间后修改包间状态
     * @Date: 2020年7月24日
     * @author: ycy
     * @param: @param id
     * @param: @return
     * @return: resultModel
     * @throws
     */
    @RequestMapping("updateHomeStatus")
    public ResultModel<Object> updateHomeStatus(Integer id, @SessionAttribute User user){
        try {
            Home home = new Home()
                    .setId(id)
                    .setHomeStatus(SysConstant.HOME_STATUS);
            homeService.updateById(home);
            Recondite recondite = new Recondite()
                    .setHomeId(id)
                    .setUserId(user.getId())
                    .setStartTime(LocalDateTime.now())
                    .setEatStatus(SysConstant.ARRIVED);
            reconditeService.save(recondite);
            return new ResultModel<>().success("选择成功");
        } catch (Exception e){
            e.printStackTrace();
            return new ResultModel<>().error(e.getMessage());
        }
    }
}
