package com.example.demo.common;
import com.example.demo.common.Result;
import com.example.demo.common.ResultEnum;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class RUtils {
    /*成功，且返回体有数据*/
    public static Result success(Object object) {
        Result r = new Result();
        r.setStatus(ResultEnum.SUCCESS.getStatus());
        r.setError(ResultEnum.SUCCESS.getError());
        r.setData(object);
        return r;
    }
    //成功，但返回体没数据
    public static  Result success(){
        return success(null);
    }
    //失败返回信息
    public static Result Err(Integer status,String error){
        Result r = new Result();
        r.setStatus(status);
        r.setError(error);
        return r;
    }
}
