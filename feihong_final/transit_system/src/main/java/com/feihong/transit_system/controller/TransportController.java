package com.feihong.transit_system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feihong.transit_system.entity.Transport;
import com.feihong.transit_system.service.ITransportService;
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
@RequestMapping("/transport")
public class TransportController {
    @Autowired
    private ITransportService transportService;

    //分页
    @RequestMapping("/getByPage")
    public IPage<Transport> getByPage(Integer currentPage, Integer pageSize){
        IPage<Transport> page = transportService.page(new Page<>(currentPage, pageSize));
        return page;
    }

    //增
    @RequestMapping
    public String add(Transport transport)
    {
        transportService.add(transport);
        return "success";
    }

    //删
    @RequestMapping("/delete")
    public String delete(Integer transportId)
    {
        transportService.delete(transportId);
        return "success";
    }

    //改
    @RequestMapping("/update")
    public String update(@RequestBody Transport transport)
    {
        transportService.update(transport);
        return "success";
    }

    //查
    @RequestMapping("/getById")
    public List<Transport> getById(Integer transportId)
    {
        QueryWrapper<Transport> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("transport_id",transportId);
        return transportService.list(queryWrapper);
    }
}
