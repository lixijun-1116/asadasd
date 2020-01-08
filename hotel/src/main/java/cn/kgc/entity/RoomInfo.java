package cn.kgc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * roominfo
 * @author 
 */
public class RoomInfo {
    /**
     * 房间id
     */
    private Integer id;

    /**
     * 酒店id
     */
    private Integer oId;

    /**
     * 房间号
     */
    private Integer roomNo;

    /**
     * 房间类型
     */
    private String roomType;

    /**
     * 入住时间
     */
    private Date startDate;

    /**
     * 离开时间
     */
    private Date endDate;


}