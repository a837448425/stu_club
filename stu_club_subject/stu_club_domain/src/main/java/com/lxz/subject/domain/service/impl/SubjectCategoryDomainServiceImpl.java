package com.lxz.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.lxz.subject.common.enums.IsDeletedFlagEnum;
import com.lxz.subject.domain.convert.SubjectCategoryConverter;
import com.lxz.subject.domain.entity.SubjectCategoryBO;
import com.lxz.subject.domain.service.SubjectCategoryDomainService;
import com.lxz.subject.infra.basic.entity.SubjectCategory;
import com.lxz.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: luo
 * @date: 2023/12/12 23:31
 * @Description:
 * @Version: 1.0
 */

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Autowired
    private SubjectCategoryService subjectCategoryService;


    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryController.add().bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter
                .INSANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryPrimaryCategory() {
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setIsDeleted(0);
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryPrimaryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter
                .INSANCE.convertBoToCategory(subjectCategoryList);
        if (log.isInfoEnabled()){
            log.info("SubjectCategoryController.queryPrimaryCategory().boList:{}", JSON.toJSONString(boList));
        }
        return boList;
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter
                .INSANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter
                .INSANCE.convertBoToCategory(subjectCategoryList);
        if (log.isInfoEnabled()){
            log.info("SubjectCategoryController.queryCategory().boList:{}", JSON.toJSONString(boList));
        }
        return boList;
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter
                .INSANCE.convertBoToCategory(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter
                .INSANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        if (count > 0) {
            return true;
        }
        return false;
    }
}
