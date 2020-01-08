package cn.kgc.controller;

import cn.kgc.entity.Passengers;
import cn.kgc.service.PassengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("passengers")
public class PassengersController {

    @Autowired
    private PassengersService passengersService;

    @RequestMapping(value = "query",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String queryAll(Integer Uid, Model model){
        List<Passengers> queryAllList = passengersService.queryAllPassengersByUid(Uid);
        model.addAttribute("queryAllList",queryAllList);
        return null;
    }
}
