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
 * @since 2024-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("salary")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账单编号
     */
    @TableId(value = "salary_id", type = IdType.AUTO)
    private Integer salaryId;

    /**
     * 运单编号
     */
    private Integer transportId;

    /**
     * 司机姓名
     */
    private String driverName;

    /**
     * 司机电话
     */
    private Integer driverTel;

    /**
     * 车牌号码
     */
    private String licensePlate;

    /**
     * 工资金额
     */
    private Integer amount;

    /**
     * 备注
     */
    private String notes;


}
