package com.feihong.transit_system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feihong.transit_system.entity.Cargo;
import com.feihong.transit_system.service.ICargoService;
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
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    private ICargoService cargoService;

    //分页
    @RequestMapping("/getByPage")
    public IPage<Cargo> getByPage(Integer currentPage,Integer pageSize){
        IPage<Cargo> page = cargoService.page(new Page<>(currentPage, pageSize));
        return page;
    }

    //增
    @RequestMapping("/add")
    public String add(Cargo cargo)
    {
        cargoService.add(cargo);
        return "success";
    }

    //删
    @RequestMapping("/delete")
    public String delete(Integer cargoId)
    {
        cargoService.delete(cargoId);
        return "success";
    }

    //改
    @RequestMapping("/update")
    public String update(@RequestBody Cargo cargo)
    {
        cargoService.update(cargo);
        return "success";
    }

    //查
    @RequestMapping("/getById")
    public List<Cargo> getById(Integer cargoId)
    {
        QueryWrapper<Cargo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cargo_id",cargoId);
        return cargoService.list(queryWrapper);
    }
}
