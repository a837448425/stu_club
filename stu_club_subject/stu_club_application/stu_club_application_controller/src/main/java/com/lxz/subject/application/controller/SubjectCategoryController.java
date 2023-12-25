package com.lxz.subject.application.controller;


import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lxz.subject.application.convert.SubjectCategoryDTOConverter;
import com.lxz.subject.application.dto.SubjectCategoryDTO;
import com.lxz.subject.common.entity.Result;
import com.lxz.subject.domain.entity.SubjectCategoryBO;
import com.lxz.subject.domain.service.SubjectCategoryDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: luo
 * @date: 2023/12/13 6:35
 * @Description:
 * @Version: 1.0
 */

@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Autowired
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增分类
     * @param subjectCategoryDTO
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.add().dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }

            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(),"分类类型不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectCategoryDTO.getCategoryName()),"分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"父级分类id不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter
                    .INSANCE.convertBoToCategory(subjectCategoryDTO);

            subjectCategoryDomainService.add(subjectCategoryBO);

            return Result.ok(true);
        }catch (Exception e) {
            log.error("SubjectCategoryController.add().error:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
    }

    /**
     *  查询分类列表
     * @return
     */
    @RequestMapping(value = "/queryPrimaryCategory",method = RequestMethod.GET)
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter
                    .INSANCE.convertDtoCategoryBo(subjectCategoryDTO);

            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService
                    .queryCategory(subjectCategoryBO);

            List<SubjectCategoryDTO> DtoList = SubjectCategoryDTOConverter
                    .INSANCE.convertBoToCategoryDTOList(subjectCategoryBOList);

            return Result.ok(DtoList);
        }catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory().error:{}",e.getMessage(),e);
            return Result.fail("查询失败");
        }
    }

    /**
     * 查询大类下分类
     * @param subjectCategoryDTO
     * @return
     */
    @RequestMapping(value = "/queryCategoryByPrimary",method = RequestMethod.POST)
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try{
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryByPrimary().dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter
                    .INSANCE.convertDtoCategoryBo(subjectCategoryDTO);

            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类id不能为空");

            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService
                    .queryCategory(subjectCategoryBO);

            List<SubjectCategoryDTO> DtoList = SubjectCategoryDTOConverter
                    .INSANCE.convertBoToCategoryDTOList(subjectCategoryBOList);

            return Result.ok(DtoList);
        }catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryByPrimary().error:{}",e.getMessage(),e);
                return Result.fail("查询失败");
        }
    }

    /**
     * 更新分类
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            if (log.isDebugEnabled()){
                log.info("SubjectCategoryController.update().dto:{}",
                        JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter
                    .INSANCE.convertDtoCategoryBo(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(result);
        }catch (Exception e) {
            log.error("SubjectCategoryController.update().error:{}",e.getMessage(),e);
            return Result.fail("更新分类失败");
        }
    }

    /**
     * 删除分类
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            if (log.isDebugEnabled()){
                log.info("SubjectCategoryController.delete().dto:{}",
                        JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter
                    .INSANCE.convertDtoCategoryBo(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Result.ok(result);
        }catch (Exception e) {
            log.error("SubjectCategoryController.delete().error:{}",e.getMessage(),e);
            return Result.fail("删除分类失败");
        }
    }
}
