package com.feihong.transit_system.service.impl;

import com.feihong.transit_system.entity.Transport;
import com.feihong.transit_system.mapper.TransportMapper;
import com.feihong.transit_system.service.ITransportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DKH
 * @since 2024-08-17
 */
@Service
public class TransportServiceImpl extends ServiceImpl<TransportMapper, Transport> implements ITransportService {
    @Resource
    private TransportMapper transportMapper;

    //增
    @Override
    public void add(Transport transport) {
        transportMapper.add(transport);
    }

    //删
    @Override
    public void delete(Integer transportId) {
        transportMapper.delete(transportId);
    }

    //改
    @Override
    public void update(Transport transport) {
        transportMapper.update(transport);
    }
}
