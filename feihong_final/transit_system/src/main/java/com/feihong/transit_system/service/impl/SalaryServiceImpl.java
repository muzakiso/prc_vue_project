package com.feihong.transit_system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feihong.transit_system.entity.Salary;
import com.feihong.transit_system.mapper.SalaryMapper;
import com.feihong.transit_system.service.ISalaryService;
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
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements ISalaryService {
    @Resource
    private SalaryMapper salaryMapper;

    //增
    @Override
    public void add(Salary salary) {
        salaryMapper.add(salary);
    }

    //删
    @Override
    public void delete(Integer salaryId) {
        salaryMapper.delete(salaryId);
    }

    //改
    @Override
    public void update(Salary salary) {
        salaryMapper.update(salary);
    }


}
