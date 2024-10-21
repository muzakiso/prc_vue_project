package com.feihong.transit_system.mapper;

import com.feihong.transit_system.entity.Cargo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DKH
 * @since 2024-08-19
 */
public interface CargoMapper extends BaseMapper<Cargo> {
    @Insert("insert into cargo(cargo_id,cargo_name,status,weight,orders_id,notes) values(#{cargoId},#{cargoName},#{status},#{weight},#{ordersId},#{notes})")
    void add(Cargo cargo);

    //删
    @Delete("delete from cargo where cargo_id=#{cargoId}")
    void delete(Integer cargoId);

    //改
    @Update("update cargo set cargo_name=#{cargoName},weight=#{weight},status=#{status},orders_id=#{ordersId},notes=#{notes} where cargo_id=#{cargoId}")
    void update(Cargo cargo);
}
