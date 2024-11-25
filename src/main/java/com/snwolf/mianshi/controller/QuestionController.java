package com.snwolf.mianshi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snwolf.mianshi.annotation.CheckRole;
import com.snwolf.mianshi.constants.UserConstant;
import com.snwolf.mianshi.domain.dto.question.QuestionAddRequest;
import com.snwolf.mianshi.domain.dto.question.QuestionQueryRequest;
import com.snwolf.mianshi.domain.entity.Question;
import com.snwolf.mianshi.domain.vo.QuestionVO;
import com.snwolf.mianshi.result.Result;
import com.snwolf.mianshi.service.QuestionService;
import com.snwolf.mianshi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="https://github.com/SnowWolf68">SnowWolf68</a>
 * @Version: V1.0
 * @Date: 11/25/2024
 * @Description:
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public Result<Long> addQuestion(@RequestBody QuestionAddRequest questionAddRequest){
        return questionService.addQuestion(questionAddRequest);
    }

    @PostMapping("/get/vo")
    public Result<QuestionVO> getQuestionVO(Long questionId){
        return Result.success(questionService.getQuestionVO(questionId));
    }

    @PostMapping("/list/page")
    @CheckRole(role = UserConstant.ADMIN_ROLE)
    public Result<Page<Question>> listQuestionByPage(@RequestBody QuestionQueryRequest questionQueryRequest) {
        return Result.success(questionService.pageListVO(questionQueryRequest));
    }
}
