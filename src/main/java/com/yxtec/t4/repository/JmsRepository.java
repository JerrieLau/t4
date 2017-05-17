package com.yxtec.t4.repository;

import com.google.gson.Gson;
import com.yxtec.t4.model.Score;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.ProducerCallback;
import org.springframework.stereotype.Repository;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

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

    private ActiveMQQueue queue = new ActiveMQQueue("scores");

    private Gson gson = new Gson();

    public void sendScoreMessage(Score score) {
        jmsTemplate.execute((session, messageProducer) -> {
            ActiveMQTextMessage message = new ActiveMQTextMessage();
            message.setText(gson.toJson(score));
            messageProducer.send(queue, message);
            return null;
        });
    }

}
