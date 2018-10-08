package com.pm.lb.vo;

import com.pm.lb.pojo.LbPojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author huhaiqiang
 * @date 2018/09/14 16:31
 */
@Setter
@Getter
@NoArgsConstructor
public class LBPojoList {
    private List<LbPojo>  pojos;
}
