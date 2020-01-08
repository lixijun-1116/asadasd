package cn.kgc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * evaluate
 * @author 
 */
public class Evaluate{
    /**
     * 评价id
     */
    private Integer id;

    /**
     * 酒店id
     */
    private Integer hId;

    /**
     * 订单id
     */
    private Integer oId;

    /**
     * 出游类型
     */
    private String travelType;

    /**
     * 点评内容
     */
    private String commentContent;

    /**
     * 评价时间
     */
    private Date evaluateDate;

    /**
     * 酒店回复
     */
    private String hotelReply;

    /**
     * 是否值得推荐（1、值得推荐2、有待改善）
     */
    private Integer recommending;

    /**
     * 上传图片（base64）
     */
    private String uploadPictures;


}