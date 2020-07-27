package com.wjh.demo.controller;

import com.wjh.demo.entity.User;
import com.wjh.demo.service.impl.UserService;
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
 * 账号表(User)表控制层
 *
 * @author wjh
 * @since 2020-07-27 17:51:08
 */
@Api(tags = "账号表接口")
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    @GetMapping("getDetail")
    @ApiOperation("获取账号表详情")
    public User getDetail(Integer id) {
        return this.userService.queryById(id);
    }
    
    @GetMapping("/getList")
    @ApiOperation("获取账号表列表")
    public ResultVO<PageInfo<User>> getList(PageVO pageVO, User user) {
        PageHelper.startPage(pageVO.getPi(), pageVO.getPs());
        List<User> userList = userService.queryAll(user);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return ReturnUtils.success("", pageInfo);
    }

    @PostMapping("/add")
    @ApiOperation("添加账号表")
    public ResultVO add(@RequestBody User user) {
        User existData = new User();
        existData.setName(user.getName());
        if (userService.isExist(existData))
            return ReturnUtils.failed("已经存在同名【" + user.getName() + "】无法添加");

        boolean b = userService.insert(user);
        if (b) return ReturnUtils.success("添加成功");
        return ReturnUtils.failed("添加失败");

    }

    @PostMapping("/modify")
    @ApiOperation("修改账号表")
    public ResultVO modify(@RequestBody User user) {
        User existData = new User();
        existData.setName(user.getName());
        if (userService.isExistExId(existData, user.getId()))
            return ReturnUtils.failed("已经存在同名【" + user.getName() + "】无法修改");
        boolean b = userService.update(user);
        if (b) return ReturnUtils.success("修改成功");
        return ReturnUtils.failed("修改失败");

    }
}