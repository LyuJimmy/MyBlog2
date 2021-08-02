package com.example.myblog2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 软件工程10班 吕俊铭
 * @create 2021-08-03 0:27
 * Description:
 */
@Data
@AllArgsConstructor
public class Result {
    private boolean success;
    private int code;
    private String msg;
    private Object data;

    public  static  Result success(Object data){
        return new Result(true,200,"success",data);
    }
    public  static  Result fail(int code,String msg){
        return new Result(false,code,msg,null);
    }

}
