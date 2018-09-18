package com.pm.data.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

/**
 * 站点信息
 *
 * @Author: Liuxilin
 * @Date: Created in 2018/07/17 13:33
 */
@Setter
@Getter
@NoArgsConstructor
public class ShStation {
    /**
     * 站点ID
     */
    @Id
    private Integer stationId;
    /**
     * 站点名
     */
    private String stationName;
    /**
     * 经度
     */
    private String stationLongitude;
    /**
     * 纬度
     */
    private String stationLatitude;
    /**
     * 位置
     */
    private String stationPosition;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 项目id
     */
    private Integer projectId;
    /**
     * 第三方站点id
     */
    private String extraStationId;

}
