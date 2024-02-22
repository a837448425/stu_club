package com.lxz.subject.common.entity;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Author: luo
 * @date: 2024/1/15 22:17
 * @Description:
 * @Version: 1.0
 *
 * 分页返回实体
 */

@Data
public class PageResult<T> implements Serializable {
    // 当前页数
    private Integer pageNo = 1;
    // 每页显示条数
    private Integer pageSize = 20;
    // 总记录数
    private Integer total = 0;
    // 总页数
    private Integer totalPages = 0;
    // 结果集
    private List<T> result = Collections.emptyList();
    // 起始记录数
    private Integer start = 1;
    // 结束记录数
    private Integer end = 0;

    public void setReCords(List<T> result){
        this.result = result;
        if(result != null && result.size()>0){
            setTotal(result.size());
        }
    }

    public void setTotal(Integer total){
        this.total = total;
        if (this.pageSize > 0){
            this.totalPages = (total / this.pageSize) + (total % this.pageSize == 0 ? 0 : 1);
        }else {
            this.totalPages = 0;
        }
        this.start = (this.pageSize > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
        this.end = (this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0));
    }

    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }

    public void setPageNo(Integer pageNo){
        this.pageNo = pageNo;
    }
}
