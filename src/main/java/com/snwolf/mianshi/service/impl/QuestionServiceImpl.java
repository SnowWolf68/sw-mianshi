package com.snwolf.mianshi.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snwolf.mianshi.domain.dto.question.QuestionAddRequest;
import com.snwolf.mianshi.domain.dto.question.QuestionQueryRequest;
import com.snwolf.mianshi.domain.dto.user.UserDTO;
import com.snwolf.mianshi.domain.entity.Question;
import com.snwolf.mianshi.domain.vo.QuestionVO;
import com.snwolf.mianshi.mapper.QuestionMapper;
import com.snwolf.mianshi.result.Result;
import com.snwolf.mianshi.service.QuestionService;
import com.snwolf.mianshi.utils.UserHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author zhang
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2024-11-25 18:01:20
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService {

    @Override
    public Result<Long> addQuestion(QuestionAddRequest questionAddRequest) {
        Question question = new Question();
        BeanUtils.copyProperties(questionAddRequest, question);
        UserDTO user = UserHolder.getUser();
        Long userId = user.getId();
        question.setUserId(userId);
        save(question);
        return Result.success(question.getId());
    }

    @Override
    public QuestionVO getQuestionVO(Long questionId) {
        Question question = getById(questionId);
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        return questionVO;
    }

    @Override
    public Page<Question> pageListVO(QuestionQueryRequest questionQueryRequest) {
        LambdaQueryWrapper<Question> lambdaQueryWrapper = this.getQueryWrapper(questionQueryRequest);
    }

    private LambdaQueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest) {
        if(ObjectUtil.isNull(questionQueryRequest)){
            return new LambdaQueryWrapper<>();
        }
        LambdaQueryWrapper<Question> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.ne(ObjectUtil.isNotNull(questionQueryRequest.getNotId()), QuestionQueryRequest::getNotId, questionQueryRequest.getNotId());
    }
}




