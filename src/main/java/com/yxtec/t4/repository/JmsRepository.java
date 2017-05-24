package com.yxtec.t4.repository;

import com.google.gson.Gson;
import com.yxtec.t4.model.Score;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;

/**
 * TODO 类描述
 *
 * @author : <a href="mailto:jerrielau@qq.com">刘杰</a>
 * @version : 0.0.1
 * @date : 2017-05-17 22:50
 */
@Repository
public class JmsRepository {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ActiveMQQueue queue;

    @Autowired
    private Gson gson;

    public void sendScoreMessage(Score score) {
        jmsTemplate.execute((session, messageProducer) -> {
            ActiveMQTextMessage message = new ActiveMQTextMessage();
            message.setText(gson.toJson(score));
            messageProducer.send(queue, message);
            return null;
        });
    }

}
