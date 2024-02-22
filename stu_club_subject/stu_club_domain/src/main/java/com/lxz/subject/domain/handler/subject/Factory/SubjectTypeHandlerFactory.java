package com.lxz.subject.domain.handler.subject.Factory;

import com.lxz.subject.common.enums.SubjectInfoTypeEnum;
import com.lxz.subject.domain.handler.subject.SubjectTypeHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luo
 * @date: 2024/1/9 23:50
 * @Description:
 * @Version: 1.0
 *
 * 题目类型工厂
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {

    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private Map<SubjectInfoTypeEnum,SubjectTypeHandler> handlerMap = new HashMap<>();

    public SubjectTypeHandler getHandler(int subjectType){
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        return handlerMap.get(subjectInfoTypeEnum);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList) {
            handlerMap.put(subjectTypeHandler.getHandlerType(),subjectTypeHandler);
        }
    }
}
