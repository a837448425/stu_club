package com.lxz.subject.common.enums;

import lombok.Getter;

/**
 * 分类类型枚举
 */
@Getter
public enum CategoryTypeEnum {
    PRIMARY(1,"岗位大类"),
    SECOND(2,"二级分类");

    public int code;
    public String desc;

    CategoryTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CategoryTypeEnum getByCode(int codeVal){
        for (CategoryTypeEnum rusultCodeEnum : CategoryTypeEnum.values()) {
            if(rusultCodeEnum.code == codeVal){
                return rusultCodeEnum;
            }
        }
        return null;
    }
}
