package com.lxz.subject.common.entity;

/**
 * @Author: luo
 * @date: 2024/1/15 22:13
 * @Description:
 * @Version: 1.0
 *
 * 分页请求实体类
 */
public class PageInfo {
    private Integer pageNo = 1;
    private Integer pageSize = 20;

    public Integer getPageNo() {
        if(pageNo == null || pageNo < 1){
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if(pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE){
            return 20;
        }
        return pageSize;
    }
}
