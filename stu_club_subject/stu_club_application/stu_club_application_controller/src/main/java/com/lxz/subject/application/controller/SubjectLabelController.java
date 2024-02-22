package com.lxz.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.lxz.subject.application.convert.SubjectLabelDTOConverter;
import com.lxz.subject.application.dto.SubjectLabelDTO;
import com.lxz.subject.common.entity.Result;
import com.lxz.subject.domain.entity.SubjectLabelBO;
import com.lxz.subject.domain.service.SubjectLabelDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: luo
 * @date: 2023/12/26 20:17
 * @Description:
 * @Version: 1.0
 *
 * 标签controller
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {

    @Autowired
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增标签
     * @param subjectLabelDto
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDto){
        try {
            // todo 日志:记录前端获取到的数据
            if(log.isInfoEnabled()){
                log.info("SubjectLabelController.add().dto={}", JSON.toJSONString(subjectLabelDto));
            }
            // todo 校验数据
            Preconditions.checkNotNull(subjectLabelDto.getLabelName(),
                    "标签名称不能为空");
            // todo 将获取到dto数据进行数据转换到bo
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter
                    .INSANCE.convertDtoLabelBO(subjectLabelDto);
            // todo 调用领域服务
            Boolean result = subjectLabelDomainService.add(subjectLabelBO);
            // todo 返回结果
            log.info("SubjectLabelController.add().result={}", result);
            return Result.ok(result);
        }catch (Exception e) {
            log.error("SubjectLabelController.add().error={}", e.getMessage(),e);
            return Result.fail("新增标签失败");
        }
    }

    /**
     * 更新标签
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            if (log.isDebugEnabled()){
                log.info("SubjectLabelController.update().dto:{}",
                        JSON.toJSONString(subjectLabelDTO));
            }
            // todo 校验数据
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"标签id不能为空");
            // todo 将获取到dto数据进行数据转换到bo
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter
                    .INSANCE.convertDtoLabelBO(subjectLabelDTO);
            // todo 调用领域服务
            Boolean result = subjectLabelDomainService.update(subjectLabelBO);
            // todo 返回结果
            return Result.ok(result);
        }catch (Exception e) {
            log.error("SubjectCategoryController.update().error:{}",e.getMessage(),e);
            return Result.fail("更新标签失败");
        }
    }

    /**
     * 删除标签
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            if (log.isDebugEnabled()){
                log.info("SubjectLabelController.delete().dto:{}",
                        JSON.toJSONString(subjectLabelDTO));
            }
            // todo 校验数据
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"标签id不能为空");
            // todo 将获取到dto数据进行数据转换到bo
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter
                    .INSANCE.convertDtoLabelBO(subjectLabelDTO);
            // todo 调用领域服务
            Boolean result = subjectLabelDomainService.delete(subjectLabelBO);
            // todo 返回结果
            return Result.ok(result);
        }catch (Exception e) {
            log.error("SubjectCategoryController.delete().error:{}",e.getMessage(),e);
            return Result.fail("删除标签失败");
        }
    }

    /**
     * 查询分类下标签
     * @param subjectLabelDTO
     * @return
     */
    @RequestMapping(value = "/queryByCategoryId",method = RequestMethod.POST)
    public Result<List<SubjectLabelBO>> queryByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            if (log.isDebugEnabled()){
                log.info("SubjectLabelController.queryByCategoryId().dto:{}",
                        JSON.toJSONString(subjectLabelDTO));
            }
            // todo 校验数据
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(),"分类id不能为空");
            // todo 将获取到dto数据进行数据转换到bo
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter
                    .INSANCE.convertDtoLabelBO(subjectLabelDTO);
            // todo 调用领域服务
            List<SubjectLabelBO> resultList = subjectLabelDomainService
                    .queryByCategoryId(subjectLabelBO);
            // todo 将服务层查询到的结果List<bo>转换成List<dto>
            List<SubjectLabelDTO> dtoList = SubjectLabelDTOConverter
                    .INSANCE.convertDtoLabelBOList(resultList);
            // todo 返回结果
            return Result.ok(dtoList);
        }catch (Exception e) {
            log.error("SubjectCategoryController.queryByCategoryId().error:{}",e.getMessage(),e);
            return Result.fail("查询分类下标签失败");
        }
    }
}
