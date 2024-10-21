package com.feihong.transit_system.service.impl;

import com.feihong.transit_system.entity.Orders;
import com.feihong.transit_system.mapper.OrdersMapper;
import com.feihong.transit_system.service.IOrdersService;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {
    @Resource
    protected OrdersMapper ordersMapper;

    //增
    @Override
    public void add(Orders orders) {
        ordersMapper.add(orders);
    }

    //删
    @Override
    public void delete(Integer ordersId) {
        ordersMapper.delete(ordersId);
    }

    //改
    @Override
    public void update(Orders orders) {
        ordersMapper.update(orders);
    }

}
