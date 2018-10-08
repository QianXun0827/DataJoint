package com.pm.lb.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

/**
 * @author huhaiqiang
 * @date 2018/09/14 14:19
 */
@Setter
@Getter
@NoArgsConstructor
public class LbPojo {

    @Id
    private Integer lineStationId;
    private String lineName;
    private Integer lineId;
    private String lineDirection;
    private Integer orderSite;
    private String stationName;
}
