package com.wzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {
    private Integer status;
    private String msg;
    private Object messageBody;
    public static RespBean ok(String msg){
            return new RespBean(2000,msg,null);
    }
    public static RespBean ok(String msg,Object messageBody){
        return new RespBean(200,msg,messageBody);
    }
    public static RespBean error(String msg){
        return new RespBean(5000,msg,null);
    }
    public static RespBean error(String msg, Object messageBody){
        return new RespBean(500,msg,messageBody);
    }
}
