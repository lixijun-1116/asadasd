package cn.kgc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * hotel
 * @author 
 */
public class Hotel {
    /**
     * 酒店id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 星级
     */
    private Integer star;

    /**
     * 地址（街道号）
     */
    private String address;

    /**
     * 目的地（所属城市）
     */
    private String destination;

    /**
     * 商圈
     */
    private String businessDistrict;

    /**
     * 酒店类型(1、快捷连锁  2、高端连锁  3、民宿  4、别墅  5、主题酒店  6、青年旅舍 、7.农家乐 8.)
     */
    private Integer hotelType;

    /**
     * 酒店品牌
     */
    private String hotelBrand;

    /**
     * 酒店状态（1.正常 2.待审核 3.审核未通过4.冻结）
     */
    private String hotelStatus;

    /**
     * 酒店图片（base64存储）
     */
    private String hotelImg;


}