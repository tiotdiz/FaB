package cn.tledu.home.controller;

import cn.tledu.home.pojo.PersonPojo;
import cn.tledu.home.pojo.UserPojo;
import cn.tledu.order.dao.VehicleDao;
import cn.tledu.order.domain.Vehicle;
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
 * 控制器类
 */
@RequestMapping({"/home", "/index"})
@Controller
public class HomeController {

    @RequestMapping(value = "/hw", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String hw() {
        return "hello 我的";
    }

    @RequestMapping(value = "/myview", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String myview() {
        //如果不加@ResponseBody, 返回的是一个字符串的话, Spring会把这个字符串当在一个逻辑视图名
        //这个字符串会提交给视图解析器, 视图解析器会执行它的一个查找逻辑(这个逻辑是可以更改的)
        //默认的查找逻辑是
        //在maven项目中
        //它会去src/main/resources/static目录下，以此为基准目录/绝对路径开始找
        return "/hello";
    }

    @RequestMapping(value = "/tableview", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
    public String tableView() {
        // /斜杠相当于static
        return "/views/html/home/demo-table.html";
    }

    @RequestMapping(value = "/parambind", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String paramBindingGet(Integer id, String name, Double salary, UserPojo userPojo) {
        //jackson json
        System.out.println("id=" + id);
        System.out.println("name=" + name);
        System.out.println("salary=" + salary);
        System.out.println("userPojo=" + userPojo);
        return "parambind get";
    }

    @RequestMapping(value = "/parambind", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String paramBindingPost(Integer id, String name, Double salary, UserPojo userPojo) {
        //jackson json
        System.out.println("id=" + id);
        System.out.println("name=" + name);
        System.out.println("salary=" + salary);
        System.out.println("userPojo=" + userPojo);
        return "parambind post";
    }

    @RequestMapping(value = "/complexbind", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    @ResponseBody
    public String complexBindingPost(@RequestBody PersonPojo personPojo) {
        System.out.println("personPojo=" + personPojo);
        //String jsonString =
        // {"code" : 200, "text" : "成功", "result" : []/{}}
        return "{\"id\": 1,\"name\":\"lhl刘十三\", \"salary\" : 2.0}";//complexbind post
    }

    @RequestMapping(value = "/returnValueBind", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResponsePojo returnValueBindPost(@RequestBody PersonPojo personPojo) {
        System.out.println("personPojo=" + personPojo);
        JsonResponsePojo jrp = new JsonResponsePojo(500, "处理异常", null);

        jrp = new JsonResponsePojo(200, "OK", new UserPojo(2, "刘十三", 2.0));

        List<UserPojo> list = new ArrayList<UserPojo>();
        list.add(new UserPojo(1, "小强", 3.0));
        list.add(new UserPojo(2, "小红", 2.0));
        list.add(new UserPojo(3, "小明", 1.0));
        jrp = new JsonResponsePojo(200, "OK", list);
        return jrp;
    }
}
