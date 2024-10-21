package com.feihong.transit_system.controller;


import com.feihong.transit_system.Result.Result;
import com.feihong.transit_system.entity.Administrator;
import com.feihong.transit_system.service.IAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DKH
 * @since 2024-08-17
 */
@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private IAdministratorService administratorService;

    @RequestMapping("/login")
    public Result log(@RequestBody Administrator user){
        // 提取用户名和密码
        String uname = user.getAccount();
        String pword = user.getPassword();
        // 根据用户名查找用户
        Administrator byUser = administratorService.findByUser(uname);
        if (byUser == null){
            // 如果用户名不存在，则返回用户名错误信息
            return Result.error("用户名错误或不存在");
        }
        if (pword.equals(byUser.getPassword())){
            // // 如果密码匹配，则登录成功
            return Result.success();
        }
        // 如果密码不匹配，则返回密码错误信息
        return Result.error("密码错误！");
    }

}
