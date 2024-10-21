package com.feihong.transit_system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feihong.transit_system.entity.Orders;
import com.feihong.transit_system.entity.Salary;
import com.feihong.transit_system.service.IOrdersService;
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
 * @since 2024-08-19
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    //分页
    @RequestMapping("/getByPage")
    public IPage<Orders> getByPage(Integer currentPage, Integer pageSize){
        IPage<Orders> page = ordersService.page(new Page<>(currentPage, pageSize));
        return page;
    }

    //增
    @RequestMapping("/add")
    public String add(Orders orders)
    {
        ordersService.add(orders);
        return "success";
    }

    //删
    @RequestMapping("/delete")
    public String delete(Integer ordersId)
    {
        ordersService.delete(ordersId);
        return "success";
    }

    //改
    @RequestMapping("/update")
    public String update(@RequestBody Orders orders)
    {
        ordersService.update(orders);
        return "success";
    }

    //查
    @RequestMapping("/getById")
    public List<Orders> getById(Integer ordersId)
    {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("orders_id",ordersId);
        return ordersService.list(queryWrapper);
    }
    //查询所有
    @RequestMapping("/getAll")
    public List<Orders> getAll()
    {
        return ordersService.list();
    }
}
