package com.yxtec.t4.service;

import com.yxtec.t4.model.Score;
import com.yxtec.t4.repository.DbRepository;
import com.yxtec.t4.repository.JmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO 类描述
 *
 * @author : <a href="mailto:jerrielau@qq.com">刘杰</a>
 * @version : 0.0.1
 * @date : 2017-05-17 23:30
 */
@Service
public class ScoreService {

    @Autowired
    private DbRepository dbRepository;

    @Autowired
    private JmsRepository jmsRepository;

    @Transactional
    public void save(Score score) {
        dbRepository.saveOrUpdate(score);
        jmsRepository.sendScoreMessage(score);
    }

}
