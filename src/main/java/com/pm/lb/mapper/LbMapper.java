package com.pm.lb.mapper;


import com.pm.lb.pojo.LbPojo;
import com.pm.lb.pojo.ShLine;
import com.pm.lb.pojo.ShLineStation;
import com.pm.lb.pojo.ShStation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huhaiqiang
 */
public interface LbMapper {

    /*@Insert("INSERT INTO lb_line_station(line_name,line_id,line_direction,order_site,station_name) VALUES(#{lineName},#{lineId},#{lineDirection},#{orderSite},#{stationName})")
    int insetLBData(LbPojo lingBo);

    @Select("SELECT * FROM lb_line_station;")
    List<LbPojo> selectLBData();*/

    @Insert("INSERT INTO sh_line(line_name,line_direction,ticket_price,ticket_type,line_company,project_id,extra_line_id,start_station,end_station) " +
            "VALUES(#{lineName},#{lineDirection},#{ticketPrice},#{ticketType},#{lineCompany},#{projectId},#{extraLineId},#{startStation},#{endStation})")
    @Options(useGeneratedKeys = true, keyProperty = "lineId")
    int insetLineData(ShLine shLine);

    @Insert("INSERT INTO sh_station(project_id,station_name,station_position) " +
            "VALUES(#{projectId},#{stationName},#{stationPosition})")
    @Options(useGeneratedKeys = true, keyProperty = "stationId")
    int insertStationData(ShStation stationName);

    @Insert("INSERT INTO sh_line_station(station_id,line_id,extra_station_id,extra_line_id,order_site) " +
            "VALUES(#{stationId},#{lineId},#{extraStationId},#{extraLineId},#{orderSite})")
    int insetLineStationData(ShLineStation lbOrderSite);

    @Select("SELECT COUNT(*) FROM sh_line WHERE extra_line_id = #{LBLineId} AND line_direction = #{LBLineDirection}")
    int selectLineByExtraLineId(@Param("LBLineId") Integer LBLineId, @Param("LBLineDirection") String LBLineDirection);

    @Select("SELECT station_name FROM lb_line_station WHERE line_id = #{LBLineId} AND line_direction = #{LBLineDirection} ORDER BY order_site")
    List<String> selectSEStationById(@Param("LBLineId") Integer LBLineId, @Param("LBLineDirection") String LBLineDirection);

    @Select("SELECT COUNT(*) FROM sh_station WHERE station_name = #{lbStationName}")
    int selectStationByName(String lbStationName);

    @Select("SELECT station_id FROM sh_station WHERE station_name = #{lbStationName}")
    Integer selectStationIdByName(String lbStationName);
}