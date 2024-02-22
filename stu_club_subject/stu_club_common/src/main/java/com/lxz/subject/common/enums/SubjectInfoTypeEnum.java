package com.lxz.subject.common.enums;

import lombok.Getter;

/**
 * 题目类型枚举
 */
@Getter
public enum SubjectInfoTypeEnum {
    RADIO(1,"单选"),
    MULTIPLE(2,"多选"),
    JUDGE(3,"判断"),
    BRIEF(4, "简答");

    public int code;
    public String desc;

    SubjectInfoTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SubjectInfoTypeEnum getByCode(int codeVal){
        for (SubjectInfoTypeEnum rusultCodeEnum : SubjectInfoTypeEnum.values()) {
            if(rusultCodeEnum.code == codeVal){
                return rusultCodeEnum;
            }
        }
        return null;
    }
}
