package com.mmm.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mmm.sys.entity.TUsers;
import com.mmm.sys.service.ITUsersService;
import com.mmm.utils.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mmm13123
 * @since 2022-10-16
 */
@Controller
@RequestMapping("/sys/tUsers")
public class TUsersController {

    @Autowired
    private ITUsersService itUsersService;

    @Operation(summary = "通用结果查询测试")
    @RequestMapping("/listUser")
    @ResponseBody
    public ApiResult<List<TUsers>> listUser(){
        ApiResult apiResult = new ApiResult<>();
        apiResult.setCode(200);
        apiResult.setMessage("查询成功");
        apiResult.setResult(itUsersService.list());
        return apiResult;
    }

    @Operation(summary = "用户登录")
    @GetMapping("/login")
    @ResponseBody
    public ApiResult login(@RequestParam("userName") String userName, @RequestParam("password") String password){
        System.out.println("接收用户名==>"+ userName);
        System.out.println("接收密码==>"+ password);
        QueryWrapper<TUsers> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TUsers::getUsername, userName);
        queryWrapper.lambda().eq(TUsers::getPassword, password);
        TUsers users = itUsersService.getOne(queryWrapper);
        if (users == null){
            return ApiResult.error("用户不存在");
        }
        return ApiResult.success("登录成功");
    }


}
