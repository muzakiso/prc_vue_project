package com.feihong.transit_system.service.impl;

import com.feihong.transit_system.entity.Administrator;
import com.feihong.transit_system.mapper.AdministratorMapper;
import com.feihong.transit_system.service.IAdministratorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> implements IAdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator findByUser(String uname) {
        return administratorMapper.findByUser(uname);
    }
}
