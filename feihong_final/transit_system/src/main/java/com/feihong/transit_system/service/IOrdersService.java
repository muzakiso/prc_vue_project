package com.feihong.transit_system.service;

import com.feihong.transit_system.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DKH
 * @since 2024-08-19
 */
public interface IOrdersService extends IService<Orders> {
    //增
    void add(Orders orders);

    //删
    void delete(Integer ordersId);

    //改
    void update(Orders orders);


}
