package com.feihong.transit_system.service;

import com.feihong.transit_system.entity.Cargo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DKH
 * @since 2024-08-19
 */
public interface ICargoService extends IService<Cargo> {
    //增
    void add(Cargo cargo);

    //删
    void delete(Integer cargoId);

    //改
    void update(Cargo cargo);

}
