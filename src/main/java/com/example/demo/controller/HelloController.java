package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.RUtils;
import com.example.demo.common.Result;
import com.example.demo.common.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * 测试控制器
 *
 */
@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model) {
        List<User> list = userService.findAllUser();
        System.out.println("输出列表");
        System.out.println(list);
        model.addAttribute("userList", list);
        return "index";
    }

    @RequestMapping("/user/list")
    @ResponseBody  // json格式返回 不走MVC
    public Result list(Model model, HttpServletResponse response) {
        List<User> list = userService.findAllUser();
        System.out.println("输出列表");
        System.out.println(list);
        model.addAttribute("userList", list);
        return RUtils.success(list);
    }

    @RequestMapping(value = "/user/register", method = POST)
    @ResponseBody  // json格式返回 不走MVC
    public Result register(@RequestBody JSONObject json) throws Exception  {
        System.out.println(json.toString());
        String name = (String) json.get("name");
        String sex = (String) json.get("sex");
        String birthday = (String) json.get("birthday");
        String address = (String) json.get("address");
        Integer result = userService.insert(name,sex,birthday,address);
        System.out.println(result);
        if(result != null){
            return RUtils.Err(ResultEnum.UNKNOWN_ERROR.getStatus(),ResultEnum.UNKNOWN_ERROR.getError());

        }
        return RUtils.success("添加成功");
    }

    @RequestMapping(value = "/user/registerUser", method = POST)
    @ResponseBody  // json格式返回 不走MVC
    public Result registerUser(@RequestBody JSONObject json) throws Exception  {
        System.out.println(json.toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

        String name = (String) json.get("name");
        String sex = (String) json.get("sex");

        String birthday = (String) json.get("birthday");
        java.util.Date d = df.parse(birthday);
        Date birthday2 = new Date(d.getTime());

        String address = (String) json.get("address");

        Integer result = userService.insertUser(name,sex,birthday2,address);
        System.out.println(result);
        if(result == null){
            return RUtils.Err(ResultEnum.UNKNOWN_ERROR.getStatus(),ResultEnum.UNKNOWN_ERROR.getError());
        }
        return RUtils.success("添加成功");
    }


    @RequestMapping(value = "/user/updateUser", method = POST)
    @ResponseBody  // json格式返回 不走MVC
    public Result updateUser(@RequestBody JSONObject json) throws Exception  {
        System.out.println(json.toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Integer id = (Integer) json.get("id");

        User user = userService.getUser(id);

        if(user == null){
            return RUtils.Err(ResultEnum.UNKNOWN_ERROR.getStatus(),"没有该用户");
        }

        String name = (String) json.get("name");
        String sex = (String) json.get("sex");

        String birthday = (String) json.get("birthday");
        java.util.Date d = df.parse(birthday);
        Date birthday2 = new Date(d.getTime());

        String address = (String) json.get("address");

        Integer result = userService.updateUser(id,name,sex,birthday2,address);
        System.out.println(result);
        if(result == null){
            return RUtils.Err(ResultEnum.UNKNOWN_ERROR.getStatus(),ResultEnum.UNKNOWN_ERROR.getError());
        }
        return RUtils.success("编辑成功");
    }
}
