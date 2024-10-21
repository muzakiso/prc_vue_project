package com.feihong.transit_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feihong.transit_system.entity.Salary;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DKH
 * @since 2024-08-17
 */
public interface ISalaryService extends IService<Salary> {
    void add(Salary salary);

    //删
    void delete(Integer salaryId);

    //改
    void update(Salary salary);


}
