package com.feihong.transit_system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("cargo")
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 货物捆包号
     */
    @TableId(value = "cargo_id", type = IdType.AUTO)
    private Integer cargoId;

    /**
     * 货物名
     */

    private String cargoName;
    /**
     * 货物重量
     */

    private Double weight;
    /**
     * 货物状态
     */

    private String status;
    /**
     * 订单编号
     */

    private Integer ordersId;
    /**
     * 备注
     */

    private String notes;

}
