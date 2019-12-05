package com.chen.utils;

import com.baomidou.mybatisplus.extension.api.R;

import java.util.Map;

/**
 * @ClassName Result
 * @Description: json数据封装类
 * @Author chenGJ
 * @Date 2019/12/5 22:38
 * @Version V1.0
**/
public class Result {

    private String msg;

    private String code;

    private String data;

    private Map map;

    public Result(){

    }

    public Result(String code,String msg,String data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result ok(String data){
        Result r = new Result();
        r.setData(data);
        r.setCode("200");
        r.setMsg("保存成功");
        return r;
    }

    public Result error(String msg){
        Result r = new Result();
        r.setData(null);
        r.setCode("500");
        r.setMsg(msg);
        return r;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
