package com.yxtec.t4.repository;

import com.yxtec.t4.model.Score;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jerrie on 17-5-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-test-jms-producer.xml"})
public class JmsRepositoryTest {


    @Autowired
    private JmsRepository jmsRepository;

    @Test
    public void sendScoreMessage() throws Exception {
//        int total = 1_000_000;
        int total = 1;
        for (int i = 0; i < total; i++) {
            Score score = new Score();
            score.setId((long) i);
            score.setSname("Bot-" + i);
            score.setCourse("Bot Bot Bot");
            score.setScore((float) i);
            jmsRepository.sendScoreMessage(score);
        }
    }

}