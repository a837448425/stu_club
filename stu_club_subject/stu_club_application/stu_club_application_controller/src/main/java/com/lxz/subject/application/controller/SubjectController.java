package com.lxz.subject.application.controller;

import com.lxz.subject.infra.basic.entity.SubjectCategory;
import com.lxz.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class SubjectController {

    @Autowired
    private SubjectCategoryService subjectCategoryService;
    @GetMapping("/test")
    public String test(){
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);
        return subjectCategory.getCategoryName();
    }
}
