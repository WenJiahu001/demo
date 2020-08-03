package com.wjh.demo.controller;

import com.wjh.demo.entity.UserMaster;
import com.wjh.demo.entity.vo.UserMasterVO;
import com.wjh.demo.entity.dto.UserMasterDTO;
import com.wjh.demo.entity.edto.UserMasterEDTO;
import com.wjh.demo.service.impl.UserMasterService;
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
 * 账号表(UserMaster)表控制层
 *
 * @author wjh
 * @since 2020-08-03 09:29:36
 */
 
@Api(tags = "账号表接口")
@RestController
@RequestMapping("/userMaster")
public class UserMasterController {
    /**
     * 服务对象
     */
    @Autowired
    private UserMasterService userMasterService;

    @GetMapping("getUserMasterDetail")
    @ApiOperation("获取账号表详情")
    public UserMasterVO getUserMasterDetail(  Integer id) {
        return this.userMasterService.queryDetailById(id);
    }
    
    @GetMapping("/getUserMasterList")
    @ApiOperation("获取账号表列表")
    public ResultVO<PageInfo<UserMasterVO>> getUserMasterList(PageVO pageVO, UserMasterDTO dto) {
        PageHelper.startPage(pageVO.getPi(), pageVO.getPs());
        UserMaster data = new UserMaster();
        data.setName(dto.getName());
        data.setPwd(dto.getPwd());

        List<UserMasterVO> userMasterList = userMasterService.queryAllDetail(dto);
        PageInfo<UserMasterVO> pageInfo = new PageInfo<>(userMasterList);
        return ReturnUtils.success("", pageInfo);
    }

    @PostMapping("/addUserMaster")
    @ApiOperation("添加账号表")
    public ResultVO addUserMaster(@RequestBody UserMasterEDTO edto) {
        UserMaster existData = new UserMaster();
        existData.setName(edto.getName());
        if (userMasterService.isExist(existData))
            return ReturnUtils.failed("已经存在同名【" + edto.getName() + "】无法添加");
        
        UserMaster data = new UserMaster();
        data.setName(edto.getName());
        data.setPwd(edto.getPwd());
        
        boolean b = userMasterService.insert(data);
        if (b) return ReturnUtils.success("添加成功");
        return ReturnUtils.failed("添加失败");

    }

    @PostMapping("/modifyUserMaster")
    @ApiOperation("修改账号表")
    public ResultVO modifyUserMaster(@RequestBody UserMasterEDTO edto) {
        UserMaster existData = new UserMaster();
        existData.setName(edto.getName());
        if (userMasterService.isExistExId(existData, edto.getId()))
            return ReturnUtils.failed("已经存在同名【" + edto.getName() + "】无法修改");
        UserMaster data = new UserMaster();
        data.setId(edto.getId());
        data.setName(edto.getName());
        data.setPwd(edto.getPwd());
       
        boolean b = userMasterService.update(data);
        if (b) return ReturnUtils.success("修改成功");
        return ReturnUtils.failed("修改失败");

    }
}