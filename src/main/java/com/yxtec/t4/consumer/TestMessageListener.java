package com.yxtec.t4.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by jerrie on 17-5-18.
 */
public class TestMessageListener implements MessageListener, ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestMessageListener.class);

    private ApplicationContext applicationContext;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                TextMessage text = (TextMessage) message;
                LOGGER.info(text.getText());
            } catch (JMSException e) {
                LOGGER.error(e.getMessage(), e);
            }
        } else {
            LOGGER.warn("接收到的消息不是TextMessage，丢弃该消息!");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
