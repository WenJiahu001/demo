package com.wjh.demo.controller;


import com.wjh.demo.entity.User;
import com.wjh.demo.service.impl.TestService;
import com.wjh.demo.utils.ReturnUtils;
import com.wjh.demo.vo.PageInfo;
import com.wjh.demo.vo.PageVO;
import com.wjh.demo.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:UserController
 * Package:
 *
 * @Date:2020/7/26 21:01
 * @Author:WenJiahu
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试接口")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/getList")
    @ApiOperation("获取用户列表")
    public ResultVO<PageInfo<User>> getList(PageVO pageVO, User user) {
        PageHelper.startPage(pageVO.getPi(), pageVO.getPs());
        List<User> userList = testService.queryAll(user);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return ReturnUtils.success("", pageInfo);
    }

    @PostMapping("/add")
    @ApiOperation("/添加用户")
    public ResultVO add(@RequestBody User user) {
        User existData = new User();
        existData.setName(user.getName());
        if (testService.isExist(existData))
            return ReturnUtils.failed("已经存在同名【" + user.getName() + "】无法添加");

        boolean b = testService.insert(user);
        if (b) return ReturnUtils.success("添加成功");
        return ReturnUtils.failed("添加失败");

    }

    @PostMapping("/modify")
    @ApiOperation("/modify")
    public ResultVO modify(@RequestBody User user) {
        User existData = new User();
        existData.setName(user.getName());
        if (testService.isExistExId(existData, user.getId()))
            return ReturnUtils.failed("已经存在同名【" + user.getName() + "】无法修改");
        boolean b = testService.update(user);
        if (b) return ReturnUtils.success("修改成功");
        return ReturnUtils.failed("修改失败");

    }

}
