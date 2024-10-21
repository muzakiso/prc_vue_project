package com.feihong.transit_system.service.impl;

import com.feihong.transit_system.entity.Cargo;
import com.feihong.transit_system.mapper.CargoMapper;
import com.feihong.transit_system.service.ICargoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DKH
 * @since 2024-08-19
 */
@Service
public class CargoServiceImpl extends ServiceImpl<CargoMapper, Cargo> implements ICargoService {
    @Resource
    private CargoMapper cargoMapper;

    //增
    @Override
    public void add(Cargo cargo) {
        cargoMapper.add(cargo);
    }

    //删
    @Override
    public void delete(Integer cargoId) {
        cargoMapper.delete(cargoId);
    }

    //改
    @Override
    public void update(Cargo cargo) {
        cargoMapper.update(cargo);
    }
}
