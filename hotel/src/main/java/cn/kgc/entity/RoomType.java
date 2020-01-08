package cn.kgc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * roomtype
 * @author 
 */
public class RoomType {
    /**
     * 房间id
     */
    private Integer id;

    /**
     * 酒店id
     */
    private Integer hId;

    /**
     * 房间名称
     */
    private String roomName;

    /**
     * 房间类型(1、单人间2、双人间3、三人间 4.四人间)
     */
    private String roomType;

    /**
     * 房间价格
     */
    private Double roomPrice;

    /**
     * 房间数量
     */
    private Integer roomCount;

    /**
     * 剩余房间数
     */
    private Integer surplusRooms;

    /**
     * 有无早餐（0、无1、有）
     */
    private Integer breakfast;

    /**
     * 房间图片（base64存储）
     */
    private String roomImg;


}