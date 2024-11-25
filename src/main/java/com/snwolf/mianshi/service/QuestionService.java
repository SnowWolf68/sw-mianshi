package com.snwolf.mianshi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snwolf.mianshi.domain.dto.question.QuestionAddRequest;
import com.snwolf.mianshi.domain.dto.question.QuestionQueryRequest;
import com.snwolf.mianshi.domain.entity.Question;
import com.snwolf.mianshi.domain.vo.QuestionVO;
import com.snwolf.mianshi.result.Result;

/**
* @author zhang
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2024-11-25 18:01:20
*/
public interface QuestionService extends IService<Question> {

    Result<Long> addQuestion(QuestionAddRequest questionAddRequest);

    QuestionVO getQuestionVO(Long questionId);

    Page<Question> pageListVO(QuestionQueryRequest questionQueryRequest);
}
