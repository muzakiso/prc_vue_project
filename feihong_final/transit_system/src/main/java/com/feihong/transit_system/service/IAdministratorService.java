package com.feihong.transit_system.service;

import com.feihong.transit_system.entity.Administrator;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DKH
 * @since 2024-08-17
 */
public interface IAdministratorService extends IService<Administrator> {
    Administrator findByUser(String uname);
}
