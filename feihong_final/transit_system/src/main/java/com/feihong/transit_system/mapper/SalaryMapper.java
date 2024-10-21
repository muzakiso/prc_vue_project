package com.feihong.transit_system.mapper;

import com.feihong.transit_system.entity.Salary;
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
 * @since 2024-08-17
 */
public interface SalaryMapper extends BaseMapper<Salary> {

    @Insert("insert into salary(salary_id,transport_id,driver_name,driver_tel,license_plate,amount,notes) values(#{salaryId},#{transportId},#{driverName},#{driverTel},#{licensePlate},#{amount},#{notes})")
    void add(Salary salary);

    //删
    @Delete("delete from salary where salary_id=#{salaryId}")
    void delete(Integer salaryId);

    //改
    @Update("update salary set salary_id=#{salaryId},transport_id=#{transportId},driver_name=#{driverName},driver_tel=#{driverTel},license_plate=#{licensePlate},amount=#{amount},notes=#{notes} where salary_id=#{salaryId}")
    void update(Salary salary);
}
