package com.lxz.subject.common.entity;

import com.lxz.subject.common.enums.RusultCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: luo
 * @date: 2023/12/13 6:49
 * @Description:
 * @Version: 1.0
 */

@Getter
@Setter
public class Result<T>  {
    private Integer code;
    private String msg;
    private Boolean success;
    private T data;

    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(RusultCodeEnum.SUCCES.getCode());
        result.setMsg(RusultCodeEnum.SUCCES.getDesc());
        return result;
    }

    public static <T> Result ok(T data){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(RusultCodeEnum.SUCCES.getCode());
        result.setMsg(RusultCodeEnum.SUCCES.getDesc());
        result.setData(data);
        return result;
    }

    public static Result fail(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(RusultCodeEnum.FAIL.getCode());
        result.setMsg(RusultCodeEnum.FAIL.getDesc());
        return result;
    }

    public static <T> Result fail(T data){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(RusultCodeEnum.FAIL.getCode());
        result.setMsg(RusultCodeEnum.FAIL.getDesc());
        result.setData(data);
        return result;
    }

}
