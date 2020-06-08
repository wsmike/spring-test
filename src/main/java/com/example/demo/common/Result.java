package com.example.demo.common;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class Result<T> {
    /*返回体*/
    private  Integer status;
    private String error;
    private T data;

    public void setStatus(Integer status) {
        this.status = status;
    }
    public void setError(String error) {
        this.error = error;
    }
    public void setData(T data) {
        this.data = data;
    }
}
