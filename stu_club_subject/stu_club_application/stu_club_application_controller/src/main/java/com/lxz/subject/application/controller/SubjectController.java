package com.lxz.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lxz.subject.application.convert.SubjectAnswerDTOConverter;
import com.lxz.subject.application.convert.SubjectCategoryDTOConverter;
import com.lxz.subject.application.convert.SubjectInfoDTOConverter;
import com.lxz.subject.application.dto.SubjectCategoryDTO;
import com.lxz.subject.application.dto.SubjectInfoDTO;
import com.lxz.subject.common.entity.PageResult;
import com.lxz.subject.common.entity.Result;
import com.lxz.subject.domain.entity.SubjectAnswerBO;
import com.lxz.subject.domain.entity.SubjectCategoryBO;
import com.lxz.subject.domain.entity.SubjectInfoBO;
import com.lxz.subject.domain.service.SubjectInfoDomainService;
import com.lxz.subject.infra.basic.entity.SubjectCategory;
import com.lxz.subject.infra.basic.service.SubjectCategoryService;
import com.lxz.subject.infra.basic.service.SubjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 刷题controller
 *
 * @Author: luo
 * @date: 2023/12/11 19:30
 * @Description:
 * @Version: 1.0
 */

@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {
    @Autowired
    private SubjectCategoryService subjectCategoryService;
    @Autowired
    private SubjectInfoDomainService subjectInfoDomainService;
    @GetMapping("/test")
    public String test(){
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);
        return subjectCategory.getCategoryName();
    }

    /**
     * 新增题目
     * @param subjectInfoDTO
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectController.add().dto:{}", JSON.toJSONString(subjectInfoDTO));
            }

            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                    "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(),"题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(),"题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(),"题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()),
                    "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()),
                    "标签id不能为空");


            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter
                    .INSANCE.convertDtoToBo(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS = SubjectAnswerDTOConverter
                    .INSANCE.convertListDtoToBo(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);

            subjectInfoDomainService.add(subjectInfoBO);

            return Result.ok(true);
        }catch (Exception e) {
            log.error("SubjectController.add().error:{}",e.getMessage(),e);
            return Result.fail("添加题目失败");
        }
    }

    /**
     * 查询题目列表
     * @param subjectInfoDTO
     * @return
     */
    @RequestMapping(value = "/getSubjectPage",method = RequestMethod.POST)
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectController.getSubjectPage().dto:{}", JSON.toJSONString(subjectInfoDTO));
            }

            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(),
                    "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(),
                    "标签id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter
                    .INSANCE.convertDtoToBo(subjectInfoDTO);

            PageResult<SubjectInfoBO> boPageResult = subjectInfoDomainService
                    .getSubjectPage(subjectInfoBO);

            if(log.isInfoEnabled()){
                log.info("SubjectController.getSubjectPage().dto:{}", JSON.toJSONString(boPageResult));
            }


            return Result.ok(boPageResult);
        }catch (Exception e) {
            log.error("SubjectController.getSubjectPage().error:{}",e.getMessage(),e);
            return Result.fail("分页查询失败");
        }
    }

    /**
     * 查询题目详情
     * @param subjectInfoDTO
     * @return
     */
    @RequestMapping(value = "/getSubjectInfo",method = RequestMethod.POST)
    public Result<PageResult<SubjectInfoDTO>> getSubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectController.getSubjectInfo().dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getId(),
                    "题目id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter
                    .INSANCE.convertDtoToBo(subjectInfoDTO);

            SubjectInfoBO boResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);

            SubjectInfoDTO dto = SubjectInfoDTOConverter.INSANCE.convertBoToDto(boResult);

            if(log.isInfoEnabled()){
                log.info("SubjectController.getSubjectInfo().dto:{}", JSON.toJSONString(dto));
            }

            return Result.ok(dto);
        }catch (Exception e) {
            log.error("SubjectController.getSubjectInfo().error:{}",e.getMessage(),e);
            return Result.fail("查询题目详情失败");
        }
    }
}
