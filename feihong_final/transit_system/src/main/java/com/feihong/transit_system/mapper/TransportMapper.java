package com.feihong.transit_system.mapper;

import com.feihong.transit_system.entity.Transport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DKH
 * @since 2024-08-17
 */
public interface TransportMapper extends BaseMapper<Transport> {
    @Insert("insert into transport(transport_id,cargo_id,license_plate,driver_name,driver_tel,send_address,receive_address,amount,date,notes) values(#{transportId},#{cargoId},#{licensePlate},#{driverName},#{driverTel},#{sendAddress},#{receiveAddress},#{amount},#{date},#{notes}")
    void add(Transport transport);

    //删
    @Delete("delete from transport where transport_id=#{transport_id}")
    void delete(Integer transportId);

    //改
    @Insert("update transport set transport_id=#{transportId},cargo_id=#{cargoId},license_plate=#{licensePlate},driver_name=#{driverName},driver_tel=#{driverTel},send_address=#{sendAddress},receive_address=#{receiveAddress},amount=#{amount},date=#{date},notes=#{notes} where transport_id=#{transportId}")
    void update(Transport transport);
}
