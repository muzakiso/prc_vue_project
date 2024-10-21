package com.feihong.transit_system.service;

import com.feihong.transit_system.entity.Transport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DKH
 * @since 2024-08-17
 */
public interface ITransportService extends IService<Transport> {
    void add(Transport transport);

    //删
    void delete(Integer transportId);

    //改
    void update(Transport transport);
}
