package com.feihong.transit_system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feihong.transit_system.entity.Salary;
import com.feihong.transit_system.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private ISalaryService salaryService;

    //分页
    @RequestMapping("/getByPage")
    public IPage<Salary> getByPage(Integer currentPage,Integer pageSize){
        IPage<Salary> page = salaryService.page(new Page<>(currentPage,pageSize));
        return page;
    }

    //增加
    @RequestMapping("/add")
    public String add(Salary salary)
    {
        salaryService.add(salary);
        return "success";
    }

    //删
    @RequestMapping("/delete")
    public String delete(Integer salaryId)
    {
        salaryService.delete(salaryId);
        return "success";
    }

    //改
    @RequestMapping("/update")
    public String update(@RequestBody Salary salary)
    {
        salaryService.update(salary);
        return "success";
    }

    //查
    @RequestMapping("/getById")
    public List<Salary> getById(Integer salaryId)
    {
        QueryWrapper<Salary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("salary_id",salaryId);
        return salaryService.list(queryWrapper);
    }

    //查询所有
    @RequestMapping("/getAll")
    public List<Salary> getAll()
    {
        return salaryService.list();
    }
}
