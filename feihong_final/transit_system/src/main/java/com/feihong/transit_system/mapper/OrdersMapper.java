package com.feihong.transit_system.mapper;

import com.feihong.transit_system.entity.Orders;
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
public interface OrdersMapper extends BaseMapper<Orders> {
    @Insert("insert into orders(orders_id,status,start_date,end_date,partya,aaddress,acontacter,acontacter_tel,partyb,baddress,bcontacter,bcontacter_tel,head,head_tel,transport_id,amount,notes) values(#{ordersId},#{status},#{startDate},#{endDate},#{partya},#{aaddress},#{acontacter},#{acontacterTel},#{partyb},#{baddress},#{bcontacter},#{bcontacterTel},#{head},#{headTel},#{transportId},#{amount},#{notes})")
    void add(Orders orders);

    //删
    @Delete("delete from orders where orders_id=#{orders_id}")
    void delete(Integer ordersId);


    //改
    @Update("update orders set start_date=#{startDate},status=#{status},end_date=#{endDate},partya=#{partya},aaddress=#{aaddress},acontacter=#{acontacter},acontacter_tel=#{acontacterTel},partyb=#{partyb},baddress=#{baddress},bcontacter=#{bcontacter},bcontacter_tel=#{bcontacterTel},head=#{head},head_tel=#{headTel},transport_id=#{transportId},amount=#{amount},notes=#{notes} where orders_id=#{ordersId}")
    void update(Orders orders);

}
