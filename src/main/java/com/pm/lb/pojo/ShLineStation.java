package com.pm.lb.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

/**
 * 线路站点信息关系类
 *
 * @Author: Liuxilin
 * @Date: Created in 2018/07/18 11:03
 */
@Getter
@Setter
@NoArgsConstructor
public class ShLineStation{
    /**
     * 站点线路ID
     */
    @Id
    private Integer stationLineId;
    /**
     * 站点ID
     */
    private Integer stationId;
    /**
     * 线路ID
     */
    private Integer lineId;
    /**
     * LED编码
     */
    private String lineStationCode;

    private String extraStationId;
    private String extraLineId;
    private Integer orderSite;

}
