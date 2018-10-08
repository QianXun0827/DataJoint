package com.pm.lb.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 线路信息
 *
 * @Author: Liuxilin
 * @Date: Created in 2018/07/17 16:52
 */
@Setter
@Getter
@NoArgsConstructor
public class ShLine implements Serializable {
    @Transient
    private static final long serialVersionUID = 1715897225895760818L;

    /**
     * 线路ID
     */
    @Id
    private Integer lineId;
    /**
     * 线路名称
     */
    private String lineName;
    /**
     * 始发站
     */
    private String startStation;
    /**
     * 终点站
     */
    private String endStation;
    /**
     * 运营开始时间
     */
    private String startTime;
    /**
     * 运营结束时间
     */
    private String endTime;
    /**
     * 票价
     */
    private String ticketPrice;
    /**
     * 售票方式
     */
    private Integer ticketType;
    /**
     * 隶属公司
     */
    private String lineCompany;
    /**
     * 线路方向
     */
    private String lineDirection;
    /**
     * 项目id
     */
    private Integer projectId;
    /**
     * 车来了线路id
     */
    private String extraLineId;
}
