package com.lxz.subject.common.enums;

import lombok.Getter;

/**
 * 删除状态枚举
 */
@Getter
public enum IsDeletedFlagEnum {
    DELETED(1,"已删除"),
    UN_DELETED(0,"未删除");

    public int code;
    public String desc;

    IsDeletedFlagEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static IsDeletedFlagEnum getByCode(int codeVal){
        for (IsDeletedFlagEnum rusultCodeEnum : IsDeletedFlagEnum.values()) {
            if(rusultCodeEnum.code == codeVal){
                return rusultCodeEnum;
            }
        }
        return null;
    }
}
