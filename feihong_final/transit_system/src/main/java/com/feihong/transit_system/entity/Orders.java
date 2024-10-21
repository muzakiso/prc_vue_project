package com.feihong.transit_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author DKH
 * @since 2024-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableId(value = "orders_id", type = IdType.AUTO)
    private Integer ordersId;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 创建日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;

    /**
     * 甲方
     */
    private String partya;

    /**
     * 甲方地址
     */
    private String aaddress;

    /**
     * 甲方联系人
     */
    private String acontacter;

    /**
     * 甲方联系人电话
     */
    private Integer acontacterTel;

    /**
     * 乙方
     */
    private String partyb;

    /**
     * 乙方地址
     */
    private String baddress;

    /**
     * 乙方联系人
     */
    private String bcontacter;

    /**
     * 乙方联系人电话
     */
    private Integer bcontacterTel;

    /**
     * 负责人
     */
    private String head;

    /**
     * 负责人电话
     */
    private Integer headTel;

    /**
     * 运单编号
     */
    private Integer transportId;

    /**
     * 结算金额
     */
    private Integer amount;

    /**
     * 备注
     */
    private String notes;


}
