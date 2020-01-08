package cn.kgc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * order
 * @author 
 */
public class OrderFrom {
    /**
     * 订单id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 订单类型（1、全部订单2、未出行3、待付款4、待评价5、已取消）
     */
    private Integer orderType;

    /**
     * 订单号（唯一）
     */
    private String orderNumber;

    /**
     * 入住人姓名
     */
    private Integer pName;

    /**
     * 入住人电话
     */
    private String pPhone;

    /**
     * 预定日期
     */
    private Date reserveDate;

    /**
     * 预计到店时间
     */
    private Date expectedArrivalTime;

    /**
     * 入住日期
     */
    private Date checkinDate;

    /**
     * 离店日期
     */
    private Date checkoutDate;

    /**
     * 酒店id
     */
    private Integer hId;

    /**
     * 房间id
     */
    private Integer rId;

    /**
     * 价格
     */
    private Double price;

    /**
     * 订单状态(1、待支付2、已取消3、未出行4、待评价5、已点评)
     */
    private Integer orderState;


}