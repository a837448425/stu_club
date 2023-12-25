package com.lxz.subject.common.enums;

import lombok.Getter;

@Getter
public enum RusultCodeEnum {
    SUCCES(200,"成功"),
    FAIL(500,"失败");

    public int code;
    public String desc;

    RusultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static RusultCodeEnum getByCode(int codeVal){
        for (RusultCodeEnum rusultCodeEnum : RusultCodeEnum.values()) {
            if(rusultCodeEnum.code == codeVal){
                return rusultCodeEnum;
            }
        }
        return null;
    }
}
