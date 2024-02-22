package com.lxz.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.lxz.subject.common.entity.PageResult;
import com.lxz.subject.common.enums.IsDeletedFlagEnum;
import com.lxz.subject.domain.convert.SubjectInfoConverter;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.entity.SubjectOPtionBO;
import com.lxz.subject.domain.handler.subject.Factory.SubjectTypeHandlerFactory;
import com.lxz.subject.domain.handler.subject.SubjectTypeHandler;
import com.lxz.subject.domain.service.SubjectInfoDomainService;
import com.lxz.subject.infra.basic.entity.SubjectInfo;
import com.lxz.subject.infra.basic.entity.SubjectLabel;
import com.lxz.subject.infra.basic.entity.SubjectMapping;
import com.lxz.subject.infra.basic.service.SubjectInfoService;
import com.lxz.subject.infra.basic.service.SubjectLabelService;
import com.lxz.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 题目标签domain层
 * @Author: luo
 * @date: 2023/12/12 23:31
 * @Description:
 * @Version: 1.0
 */

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {
    @Autowired
    private SubjectInfoService subjectInfoService;
    @Autowired
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;
    @Autowired
    private SubjectMappingService subjectMappingService;

    @Autowired
    private SubjectLabelService subjectLabelService;

    /**
     * 新增题目
     * @param subjectInfoBO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBO subjectInfoBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectInfoDomainServiceImpl.add().bo:{}",
                    JSON.toJSONString(subjectInfoBO));
        }
        // 转换BO为DO
        SubjectInfo subjectInfo = SubjectInfoConverter
                .INSANCE.convertBoTOInfo(subjectInfoBO);
        //调用方法
        subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        subjectInfoService.insert(subjectInfo);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());

        subjectInfoBO.setId(subjectInfo.getId());


        handler.add(subjectInfoBO);
        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> subjectMappingList = new LinkedList<>();
        categoryIds.forEach(categoryId ->{
            labelIds.forEach(labelId ->{
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                subjectMapping.setLabelId(Long.valueOf(labelId));
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                subjectMappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(subjectMappingList);
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectInfoDomainServiceImpl.getSubjectPage().bo:{}",
                    JSON.toJSONString(subjectInfoBO));
        }
        PageResult<SubjectInfoBO>  pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConverter
                .INSANCE.convertBoTOInfo(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectInfo,
                subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId());
        if(count == 0){
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo,
                subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId(), start, subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoBOS = SubjectInfoConverter.INSANCE
                .convertListInfoToBOList(subjectInfoList);
        pageResult.setReCords(subjectInfoBOS);
        pageResult.setTotal(count);
        return pageResult;
    }

    /**
     * 查询题目信息
     * @param subjectInfoBO
     * @return
     */
    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectInfoDomainServiceImpl.querySubjectInfo().bo:{}",
                    JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBO.getId());
        Integer subjectType = subjectInfo.getSubjectType();
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectType);
        SubjectOPtionBO optionBo = handler.query(subjectInfo.getId().intValue());
        SubjectInfoBO bo = SubjectInfoConverter.INSANCE.convertOptionAndInfoBO(optionBo,subjectInfo);

        //未补充主体
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> labelIdList = subjectMappingList.stream()
                .map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<String> labelNameList = labelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());

        //转换
        bo.setLabelName(labelNameList);
        return bo;
    }
}
