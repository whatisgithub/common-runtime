package com.qmcaifu.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.qmcaifu.common.service.MQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nihao on 2016/9/21.
 */
@Service
public class MQServiceImpl implements MQService {

    private static final Logger logger = LoggerFactory.getLogger(MQServiceImpl.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void send(String routeKey, Object msg) {
        try{
            amqpTemplate.convertAndSend(routeKey, JSON.toJSONString(msg));
        } catch (Exception e) {
            logger.error("发送消息异常 {}", e);
        }
    }
}
