package cn.kgc.service.impl;

import cn.kgc.dao.PassengersMapper;
import cn.kgc.entity.Passengers;
import cn.kgc.service.PassengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengersServiceImpl implements PassengersService {
    @Autowired
    private PassengersMapper passengersMapper;

    /**
     * 根据用户id查询所有常用联系人
     * @param uId 用户id
     * @return 常用联系人列表
     */
    @Override
    public List<Passengers> queryAllPassengersByUid(Integer uId) {
        return passengersMapper.selectAllPassengersByUid(uId);
    }

    /**
     * 添加常用联系人
     * @param passengers 新增常用联系人信息
     * @return Integer (1.添加成功 0.添加失败)
     */
    @Override
    public Integer savePassengers(Passengers passengers) {
        return passengersMapper.insertPassengers(passengers);
    }

    /**
     * 根据id修改常用联系人信息
     * @param passengers 修改常用联系人信息
     * @return Integer (1.修改成功 0.修改失败)
     */
    @Override
    public Integer modifyPassengersById(Passengers passengers) {
        return passengersMapper.updatePassengersById(passengers);
    }

    /**
     * 根据id删除常用联系人信息
     * @param id 常用联系人id
     * @return Integer (1.删除成功 0.删除失败)
     */
    @Override
    public Integer removePassengersById(Integer id) {
        return passengersMapper.deletePassengersById(id);
    }
}
