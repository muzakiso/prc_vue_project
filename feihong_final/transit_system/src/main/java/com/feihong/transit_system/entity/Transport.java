package com.feihong.transit_system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
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
 * @since 2024-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("transport")
public class Transport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 运单编号
     */
    @TableId(value = "transport_id", type = IdType.AUTO)
    private Integer transportId;

    /**
     * 货物捆包号
     */
    @TableField("cargo_id")
    private Integer cargoId;

    /**
     * 车牌号码
     */
    @TableField("license_plate")
    private String licensePlate;

    /**
     * 司机名称
     */
    @TableField("driver_name")
    private String driverName;

    /**
     * 司机电话
     */
    @TableField("driver_tel")
    private Integer driverTel;

    /**
     * 发货地址
     */
    @TableField("send_address")
    private String sendAddress;

    /**
     * 收货地址
     */
    @TableField("receive_address")
    private String receiveAddress;

    /**
     * 运费
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 开票日期
     */
    @TableField("date")
    private LocalDateTime date;

    /**
     * 备注
     */
    @TableField("notes")
    private String notes;


}
