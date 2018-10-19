package com.pm.lb.service.impl;

import com.pm.lb.mapper.LbMapper;
import com.pm.lb.pojo.ShLine;
import com.pm.lb.pojo.ShLineStation;
import com.pm.lb.pojo.ShStation;
import com.pm.lb.vo.LBPojoList;
import com.pm.lb.pojo.LbPojo;
import com.pm.lb.service.LbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author huhaiqiang
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class LbServiceImpl implements LbService {

    @Autowired
    private LbMapper lbMapper;

    @Override
    public int insertData(LBPojoList lingBoPojoList) {

//        LbPojo lingBo = new LbPojo();
        int rows = 1;
        ShLine shLine = new ShLine();
        ShStation shStation = new ShStation();

        List<LbPojo> list = lingBoPojoList.getPojos();

        //  新数据插入时使用
        /*lbMapper.insertLineStations(list);*/

        for (LbPojo lingBoPojo : list) {
            String lbLineName = lingBoPojo.getLineName();
            String lbLineDirection = lingBoPojo.getLineDirection();
            Integer lbLineId = lingBoPojo.getLineId();
            Integer lbOrderSite = lingBoPojo.getOrderSite();
            String lbStationName = lingBoPojo.getStationName();
            Integer projectId = 1;
            String lineCompany = "宁波公交公司";
            String ticketPrice = "2";
            Integer ticketType = 0;

            //  线路去重
            int count = lbMapper.selectLineByExtraLineId(lbLineId,lbLineDirection);
            if (count == 0) {

                List<String> stations = lbMapper.selectSEStationById(lbLineId,lbLineDirection);

                String startStation = stations.get(0);
                String endStation = stations.get(stations.size()-1);

                shLine.setLineName(lbLineName);
                shLine.setLineDirection(lbLineDirection);
                shLine.setExtraLineId(lbLineId+"");
                shLine.setProjectId(projectId);
                shLine.setLineCompany(lineCompany);
                shLine.setTicketPrice(ticketPrice);
                shLine.setTicketType(ticketType);
                shLine.setStartStation(startStation);
                shLine.setEndStation(endStation);
                lbMapper.insetLineData(shLine);
            }

            //  站点去重
            int countSta = lbMapper.selectStationByName(lbStationName);
            if (countSta == 0) {
                shStation.setProjectId(projectId);
                shStation.setStationName(lbStationName);
                shStation.setStationPosition(lbStationName);
                lbMapper.insertStationData(shStation);
            }

            Integer stationId = lbMapper.selectStationIdByName(lbStationName);
            ShLineStation shLineStation = new ShLineStation();
            shLineStation.setExtraLineId(lbLineId+"");
            shLineStation.setOrderSite(lbOrderSite);
            shLineStation.setLineId(shLine.getLineId());
            shLineStation.setStationId(stationId);
            shLineStation.setExtraLineId(lbLineId+"");
            lbMapper.insetLineStationData(shLineStation);
        }

        return rows;
    }

    @Override
    public int updateData() {


        return 0;
    }

}
