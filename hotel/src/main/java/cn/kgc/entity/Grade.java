package cn.kgc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * grade
 * @author 
 */
public class Grade{
    /**
     * 评分id
     */
    private Integer id;

    /**
     * 评价id
     */
    private Integer eId;

    /**
     * 星级
     */
    private Double score;

    /**
     * 评价方向（1、位置2、设施3、服务4、卫生）
     */
    private Integer evaluationDirection;

}