package cn.tledu.order.controller;

import cn.tledu.home.pojo.PersonPojo;
import cn.tledu.home.pojo.UserPojo;
import cn.tledu.order.dao.VehicleDao;
import cn.tledu.order.domain.Vehicle;
import cn.tledu.order.service.VehicleService;
import cn.tledu.pojo.JsonResponsePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理订单业务的控制器类
 */
@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/getVehicleList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResponsePojo getVehicleList() {
        JsonResponsePojo jrp = new JsonResponsePojo(500, "处理异常", null);
        try {
            List<Vehicle> list = vehicleService.selectList(new Vehicle());
            jrp = new JsonResponsePojo(200, "OK", list);
        } catch (Exception e){
            e.printStackTrace();
        }
        return jrp;
    }

    @RequestMapping(value = "/saveVehicle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResponsePojo saveVehicle(String brand, Double price) {
        JsonResponsePojo jrp = new JsonResponsePojo(500, "处理异常", null);
        try {
            int result = vehicleService.save(new Vehicle(brand, price));
            jrp = new JsonResponsePojo(200, "OK, 影响了" + result + "条记录", null);
        } catch (Exception e){
            e.printStackTrace();
        }
        return jrp;
    }
}
