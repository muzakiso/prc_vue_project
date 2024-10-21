package com.feihong.transit_system.mapper;

import com.feihong.transit_system.entity.Administrator;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DKH
 * @since 2024-08-17
 */
public interface AdministratorMapper extends BaseMapper<Administrator> {
    @Select("select * from administrator where account = #{uname}")
    Administrator findByUser(String uname);
}
