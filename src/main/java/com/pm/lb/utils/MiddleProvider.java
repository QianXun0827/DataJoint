package com.pm.lb.utils;

import com.pm.lb.pojo.LbPojo;

import java.util.List;
import java.util.Map;

/**
 * @author huhaiqiang
 * @date 2018/10/19 20:04
 */
public class MiddleProvider {

    public String insertShelterInfoMiddle(Map map) {
        List<LbPojo> lbPojos = (List) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO lb_line_station ");
        sb.append("(line_name,line_id,line_direction,order_site,station_name)");
        sb.append("VALUES ");

        for (int i = 0; i < lbPojos.size(); ++i) {
            sb.append("('" + lbPojos.get(i).getLineName() + "',");
            sb.append(lbPojos.get(i).getLineId() + ",");
            sb.append("'" + lbPojos.get(i).getLineDirection() + "'" + ",");
            sb.append(lbPojos.get(i).getOrderSite() + ",");
            sb.append("'" + lbPojos.get(i).getStationName() + "'" + ")");
            if (i < lbPojos.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
