package cn.kgc.dao;

import cn.kgc.entity.Passengers;

import java.util.List;

public interface PassengersMapper {

    /**
     * 根据用户id查询所有常用联系人
     * @param uId 用户id
     * @return 常用联系人列表
     */
    List<Passengers> selectAllPassengersByUid(Integer uId);

    /**
     * 添加常用联系人
     * @param passengers 新增常用联系人信息
     * @return Integer (1.添加成功 0.添加失败)
     */
    Integer insertPassengers(Passengers passengers);

    /**
     * 根据id修改常用联系人信息
     * @param passengers 修改常用联系人信息
     * @return Integer (1.修改成功 0.修改失败)
     */
    Integer updatePassengersById(Passengers passengers);

    /**
     * 根据id删除常用联系人信息
     * @param id 常用联系人id
     * @return Integer (1.删除成功 0.删除失败)
     */
    Integer deletePassengersById(Integer id);
}
