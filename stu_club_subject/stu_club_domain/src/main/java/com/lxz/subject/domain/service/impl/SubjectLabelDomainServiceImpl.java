package com.lxz.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.lxz.subject.common.enums.IsDeletedFlagEnum;
import com.lxz.subject.domain.convert.SubjectCategoryConverter;
import com.lxz.subject.domain.convert.SubjectLabelConverter;
import com.lxz.subject.domain.entity.SubjectCategoryBO;
import com.lxz.subject.domain.entity.SubjectLabelBO;
import com.lxz.subject.domain.service.SubjectCategoryDomainService;
import com.lxz.subject.domain.service.SubjectLabelDomainService;
import com.lxz.subject.infra.basic.entity.SubjectCategory;
import com.lxz.subject.infra.basic.entity.SubjectLabel;
import com.lxz.subject.infra.basic.entity.SubjectMapping;
import com.lxz.subject.infra.basic.service.SubjectCategoryService;
import com.lxz.subject.infra.basic.service.SubjectLabelService;
import com.lxz.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {
    @Autowired
    private SubjectLabelService subjectLabelService;
    @Autowired
    private SubjectMappingService subjectMappingService;

    /**
     * 新增标签
     * @param subjectLabelBO
     * @return
     */
    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.add().bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter
                .INSANCE.convertBoToLabel(subjectLabelBO);
        // todo 设置默认值
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        // todo 数据创建时间
        subjectLabel.setCreatedTime(new Date());
        int count = subjectLabelService.insert(subjectLabel);
        return count > 0;
    }

    /**
     * 更新标签
     * @param subjectLabelBO
     * @return
     */
    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            // todo 日志
            log.info("SubjectLabelDomainServiceImpl.update.bo:{}",
                    JSON.toJSONString(subjectLabelBO));
        }
        // todo bo数据转换成SubjectLabel
        SubjectLabel subjectLabel = SubjectLabelConverter
                .INSANCE.convertBoToLabel(subjectLabelBO);
        // todo 数据更新时间
        subjectLabel.setUpdateTime(new Date());
        // todo 更新标签,调用dao层服务
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    /**
     *  删除标签
     * @param subjectLabelBO
     * @return
     */
    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            // todo 日志
            log.info("SubjectLabelDomainServiceImpl.delete.bo:{}",
                    JSON.toJSONString(subjectLabelBO));
        }
        // todo bo数据转换成SubjectLabel
        SubjectLabel subjectLabel = SubjectLabelConverter
                .INSANCE.convertBoToLabel(subjectLabelBO);
        // todo 数据更新时间
        subjectLabel.setUpdateTime(new Date());
        // todo 设置标签状态为已删除
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        // todo 删除标签,调用dao层服务(只修改状态，不删除数据)
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    /**
     * 查询分类下标签
     * @param subjectLabelBO
     * @return
     */
    @Override
    public List<SubjectLabelBO> queryByCategoryId(SubjectLabelBO subjectLabelBO) {
        Long categoryId = subjectLabelBO.getCategoryId();

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        List<SubjectMapping> mappingList = subjectMappingService
                .queryLabelId(subjectMapping);

        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }

        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId)
                .collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);

        List<SubjectLabelBO> boList = new LinkedList<>();
        labelList.forEach(label ->{
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setSortNum(label.getSortNum());
            bo.setCategoryId(categoryId);
            boList.add(bo);
        });
        return boList;
    }
}
