package cn.tledu.order.service;

import cn.tledu.order.dao.VehicleDao;
import cn.tledu.order.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/9/27.
 */
@Service
public class VehicleService {
    @Autowired
    private VehicleDao vehicleDao;

    public List<Vehicle> selectList(Vehicle record) {
        return vehicleDao.selectList(record);
    }

    public int save(Vehicle record) {
        return vehicleDao.save(record);
    }
}
